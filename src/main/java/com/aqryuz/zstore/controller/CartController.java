package com.aqryuz.zstore.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aqryuz.zstore.entity.Product;
import com.aqryuz.zstore.entity.Variant;
import com.aqryuz.zstore.model.CartItem;
import com.aqryuz.zstore.service.ProductDetailService;
import com.aqryuz.zstore.service.ProductService;


@Controller
public class CartController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductDetailService productDetailService;
	private List<CartItem> cart = new ArrayList<>();

	@GetMapping("/cart")
	public String GetCartPage(
			HttpSession session) {
		session.setAttribute("cart", cart);
		return "/cart";
	}

	@PostMapping("/cart")
	public String addToCart(Variant temp ,HttpSession session) {
		Integer quantity = temp.getQuantity();
		Variant variant = productDetailService.findById(temp.getId());
		variant.setQuantity(quantity);
		Product product = variant.getProduct();
		CartItem item = new CartItem();
		item.setDiscount(product.getPrice().subtract(product.getSalePrice()));
		item.setImageName(product.getImageName());
		item.setPrice(product.getSalePrice());
		item.setProductName(product.getName());
		item.setSize(variant.getSize());
		item.setQuantity(variant.getQuantity());
		item.setTotalPrice(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
		item.setVariantId(variant.getId());
		item.setProductId(variant.getProduct().getId());
		for (CartItem cartItem : cart) {
			if(cartItem.getVariantId() == variant.getId()) {
				return "redirect:/cart";
			}
		}
		cart.add(item);
		return "redirect:/cart";
	}
	@GetMapping("/cart/remove")
	public String remove(@RequestParam(name = "variantId") Long variantId) {
		for (CartItem cartItem : cart) {
			if(cartItem.getVariantId() == variantId) {
				cart.remove(cartItem);
				break;
			}
		}
		return "/cart";
	}
}
