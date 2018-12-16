package com.aqryuz.zstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aqryuz.zstore.entity.OrderLine;
import com.aqryuz.zstore.entity.Product;
import com.aqryuz.zstore.entity.User;
import com.aqryuz.zstore.entity.Variant;
import com.aqryuz.zstore.service.OrderLineService;
import com.aqryuz.zstore.service.ProductDetailService;

@Controller
@RequestMapping("/merchant/orders")
public class OrderController {
	@Autowired
	private OrderLineService orderLineService;
	@Autowired
	private ProductDetailService productDetailService;
	@GetMapping(value = {"","/"})
	public String showInventory(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
			@RequestParam(name = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(name = "type", required = false, defaultValue = "id") String type
			) {
		Sort sortable = null;
		if (sort.equals("ASC")) {
			sortable = Sort.by(type).ascending();
		}
		if (sort.equals("DESC")) {
			sortable = Sort.by(type).descending();
		}
		Pageable pageable = PageRequest.of(page, size, sortable);

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user);
		model.addAttribute("orders", orderLineService.findAllByMerchant(pageable, user));
		return "merchant/orders";
	}

	@GetMapping(value = "/{id}")
	public String showOrderLineDetailPage(
			@PathVariable(name = "id") Long id,
			Model model) {
		OrderLine orderLine = orderLineService.findById(id);
		User customer = orderLine.getOrder().getCreatedBy();
		model.addAttribute("orderLine", orderLine);
		model.addAttribute("customer", customer);
		return "merchant/order";
	}	

	@PostMapping(value = "/save")
	public String save(Model model, OrderLine orderLine, RedirectAttributes redirectAttributes) {
		String message = "";
		switch (orderLine.getStatus()) {
		case "Pending":{
			message = "Please update status";
			break;
		}
		case "Shipping":{
			message = "You updated status to shipping";
			break;
		}
		case "Completed":{
			message = "You updated status to completed";
			break;
		}
		case "Cancel":{
			message = "You updated status to cancel";
			break;
		}
		default:
			break;
		}
		orderLineService.save(orderLine);
		redirectAttributes.addAttribute("message", message);
		return "redirect:/merchant/orders";
	}
}
