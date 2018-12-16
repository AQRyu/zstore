package com.aqryuz.zstore.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aqryuz.zstore.entity.Order;
import com.aqryuz.zstore.entity.OrderLine;
import com.aqryuz.zstore.entity.Product;
import com.aqryuz.zstore.entity.User;
import com.aqryuz.zstore.entity.Variant;
import com.aqryuz.zstore.model.CartItem;
import com.aqryuz.zstore.model.CheckoutInfo;
import com.aqryuz.zstore.service.EmailService;
import com.aqryuz.zstore.service.OrderLineService;
import com.aqryuz.zstore.service.OrderService;
import com.aqryuz.zstore.service.ProductDetailService;
import com.aqryuz.zstore.service.UserService;
import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.CreditCard;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.Transaction.Status;
import com.braintreegateway.TransactionRequest;
import com.braintreegateway.ValidationError;


@Controller
@Transactional
public class CartController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProductDetailService productDetailService;
	@Autowired
	private OrderLineService orderLineService;
	@Autowired
	private OrderService orderService;
	private List<CartItem> cart = new ArrayList<>();
	private BigDecimal amount = new BigDecimal(0);
	@Autowired
	private BraintreeGateway gateway;
	@Autowired
	private EmailService emailService;

	private Status[] TRANSACTION_SUCCESS_STATUSES = new Status[] {
			Transaction.Status.AUTHORIZED,
			Transaction.Status.AUTHORIZING,
			Transaction.Status.SETTLED,
			Transaction.Status.SETTLEMENT_CONFIRMED,
			Transaction.Status.SETTLEMENT_PENDING,
			Transaction.Status.SETTLING,
			Transaction.Status.SUBMITTED_FOR_SETTLEMENT
	};

	@GetMapping("/cart")
	public String GetCartPage(
			@RequestParam(value = "id") Long productDetailId,
			@RequestParam(value = "quantity") Integer quantity,
			HttpSession session) {
		Variant variant = productDetailService.findById(productDetailId);
		Product product = variant.getProduct();

		addItem(product, variant, quantity);

		session.setAttribute("amount", amount);
		session.setAttribute("cart", cart);
		return "/cart";
	}

	private void addItem(Product product, Variant variant, Integer quantity) {
		CartItem item = new CartItem();
		item.setDiscount(product.getPrice().subtract(product.getSalePrice()));
		item.setImageName(product.getImageName());
		item.setPrice(product.getSalePrice());
		item.setProductName(product.getName());
		item.setSize(variant.getSize());
		item.setQuantity(quantity);
		item.setTotalPrice(item.getPrice().multiply(BigDecimal.valueOf(quantity)));
		item.setVariantId(variant.getId());
		item.setProductId(variant.getProduct().getId());
		if(!cart.contains(item)) {
			cart.add(item);
			amount = amount.add(item.getTotalPrice());
			System.out.println(amount);
		}
	}

	@GetMapping("/cart/remove")
	public String remove(@RequestParam(name = "variantId") Long variantId) {
		for (CartItem cartItem : cart) {
			if(cartItem.getVariantId() == variantId) {
				amount = amount.subtract(cartItem.getTotalPrice());
				cart.remove(cartItem);
				break;
			}
		}
		return "cart";
	}

	@GetMapping("/checkout")
	public String getCheckoutPage(Model model) {
		//get the token
		String clientToken = gateway.clientToken().generate();
		CheckoutInfo info = new CheckoutInfo(getUser());

		//add the token to the model - this will be used in JavaScript code
		model.addAttribute("clientToken", clientToken);
		model.addAttribute("amount", amount);
		model.addAttribute("info", info);
		return "checkout";
	}

	public User getUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = auth.getName();
		System.out.println(currentUserName);
		User user = userService.findUserByEmail(currentUserName);
		System.out.println(user);
		return user;
	}

	/**
	 * We get here when the user submits the transaction - note that it's a POST
	 */
	@PostMapping(value = "/checkout")
	public String doCheckout(@RequestParam("payment_method_nonce") String nonce,
			Model model, 
			final RedirectAttributes redirectAttributes) {
		System.out.println(nonce);
		//submit the request for processing
		TransactionRequest request = new TransactionRequest()
				.amount(amount)
				.paymentMethodNonce(nonce)
				.options()
				.submitForSettlement(true)
				.done();

		//get the response
		Result<Transaction> result = gateway.transaction().sale(request);

		//Update order
		User customer = getUser();
		Order order = new Order();
		order.setId(result.getTarget().getId());
		order.setQuantity(cart.size());
		order.setTotal(amount);
		order.setCustomerName(customer.getName());
		order.setCustomerAddress(customer.getAddress());
		order.setCustomerCity(customer.getCity());
		order.setCustomerPhone(customer.getPhone());
		orderService.save(order);

		for (CartItem item : cart) {
			Variant variant = productDetailService.findById(item.getVariantId());
			OrderLine orderLine = new OrderLine();

			//Create orderLine & prepare product (update quantity & status)
			orderLine.setOrder(order);
			orderLine.setVariant(variant);
			orderLine.setPrice(item.getTotalPrice());
			orderLine.setQuantity(item.getQuantity());
			orderLine.setStatus("Pending");
			orderLine.setMerchant(variant.getCreatedBy());
			
			variant.setQuantity(variant.getQuantity() - item.getQuantity());
			
			productDetailService.save(variant);
			orderLineService.save(orderLine);
		}
		
		//Email solving:
		String to = customer.getEmail();
		String subject = "confirm purchase at ZStore";
		String text = "Hello "+ customer.getName() + "! Your order has been set. Please wait for merchant to ship.";
		emailService.sendSimpleMessage(to, subject, text);

		return checkResult(result, redirectAttributes);
	}



	private String checkResult(Result<Transaction> result, RedirectAttributes redirectAttributes) {

		//if it's a successful transaction, go to the transaction results page
		if (result.isSuccess()) {
			Transaction transaction = result.getTarget();
			return "redirect:checkout/" + transaction.getId();
		} else if (result.getTransaction() != null) {
			Transaction transaction = result.getTransaction();
			return "redirect:checkout/" + transaction.getId();
		} else {
			//if the transaction failed, return to the payment page and display all errors
			String errorString = "";
			for (ValidationError error : result.getErrors().getAllDeepValidationErrors()) {
				errorString += "Error: " + error.getCode() + ": " + error.getMessage() + "\n";
			}
			redirectAttributes.addFlashAttribute("errorDetails", errorString);
			redirectAttributes.addFlashAttribute("amount", amount);
			return "redirect:checkout";
		}
	}

	/**
	 * We get here when the user has submitted a transaction and received a
	 * Transaction ID.
	 */
	@RequestMapping(value = "/checkout/{transactionId}")
	public String getTransaction(@PathVariable String transactionId,
			@RequestParam(value = "paymentMethod", required = false) String paymentMethod,
			Model model) {
		Transaction transaction;
		CreditCard creditCard;
		User customer = getUser();

		List<CartItem> orderInfo = new ArrayList<>(cart);
		cart.clear();
		try {
			//find the transaction by its ID
			transaction = gateway.transaction().find(transactionId);

			//grab credit card info
			creditCard = transaction.getCreditCard();

			//grab the customer info
//			customer = transaction.getCustomer();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
			return "redirect:/checkout";
		}

		//set a boolean that determines whether or not the transaction was successful
		model.addAttribute("isSuccess", Arrays.asList(TRANSACTION_SUCCESS_STATUSES).contains(transaction.getStatus()));

		//put the relevant objects in the model
		model.addAttribute("transaction", transaction);
		model.addAttribute("creditCard", creditCard);
		model.addAttribute("customer", customer);
		System.out.println(orderInfo);
		model.addAttribute("orderInfo", orderInfo);
		if(paymentMethod == null) {
			model.addAttribute("paymentMethod", "paypal");
		}
		else model.addAttribute("paymentMethod", "COD");

		//server transactionResults.html
		return "transactionResults";
	}

}
