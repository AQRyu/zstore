package com.aqryuz.zstore.controller;

import java.util.List;

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
	public String getCategoryPage() {
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

}
