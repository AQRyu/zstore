package com.aqryuz.zstore.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aqryuz.zstore.entity.Product;
import com.aqryuz.zstore.entity.Variant;
import com.aqryuz.zstore.service.ProductDetailService;
import com.aqryuz.zstore.service.ProductService;

@Controller
@Transactional
public class ShopController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductDetailService productDetailService;


	@GetMapping(value = {"/", "/index", "/home"})
	public String CustomerHome(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "4") Integer size,
			@RequestParam(name = "sort", required = false, defaultValue = "DESC") String sort) {
		Sort sortable = null;
		if (sort.equals("ASC")) {
			sortable = Sort.by("id").ascending();
		}
		if (sort.equals("DESC")) {
			sortable = Sort.by("id").descending();
		}
		Pageable pageable = PageRequest.of(page, size, sortable);

		model.addAttribute("products", productService.findAll(pageable));
		return "index";
	}

	@GetMapping("/category")
	public String getCategoryPage(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "9") Integer size,
			@RequestParam(name = "sort", required = false, defaultValue = "DESC") String sort) {
		Sort sortable = null;
		if (sort.equals("ASC")) {
			sortable = Sort.by("id").ascending();
		}
		if (sort.equals("DESC")) {
			sortable = Sort.by("id").descending();
		}
		Pageable pageable = PageRequest.of(page, size, sortable);
		model.addAttribute("products", productService.findAll(pageable));
		return "category";
	}

	@GetMapping("/detail")
	public String getProductDetailPage(Model model,
			@RequestParam(name = "productId", required = true) Long productId) {
		Product product = productService.findById(productId);
		List<Variant> variants = productDetailService.findAll(productId);
		model.addAttribute("product", product);
		model.addAttribute("productDetail", new Variant());
		model.addAttribute("details", variants);
		return "detail";
	}



	@GetMapping("/contact")
	public String getContactPage() {
		return "contact";
	}

	@GetMapping("/blog")
	public String getBlogPage() {
		return "blog";
	}

	@GetMapping("/post")
	public String getPostPage() {
		return "post";
	}

	@GetMapping("/demo")
	public String demo() {
		return "demo";
	}



	/*@PostMapping("/cart")
	public String addToCart(Variant temp ,HttpSession session) {
		Integer quantity = temp.getQuantity();
		Variant variant = 
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
				return "/cart";
			}
		}
		cart.add(item);
		return "/cart";
	}*/


}
