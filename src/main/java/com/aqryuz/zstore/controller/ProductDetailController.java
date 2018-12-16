package com.aqryuz.zstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aqryuz.zstore.entity.Product;
import com.aqryuz.zstore.entity.Variant;
import com.aqryuz.zstore.service.ProductDetailService;
import com.aqryuz.zstore.service.ProductService;

@Controller
@RequestMapping("/merchant/inventory/product")
public class ProductDetailController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductDetailService productDetailService;


	@GetMapping("/{productId}")
	public String showProductDetail(Model model,
			@PathVariable(name = "productId") Long productId,
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

		model.addAttribute("variants", productDetailService.findAll(productId, pageable));
		return "merchant/productDetail";
	}	

	@GetMapping(value = "/{productId}/save")
	public String showSaveProductDetailPage(
			@PathVariable(name = "productId") Long productId,
			@RequestParam(name = "variantId", required = false)Long variantId,
			Model model) {
		Variant variant= new Variant();
		if(variantId != null) {
			variant = productDetailService.findById(variantId);
		}
		model.addAttribute("variant",variant);
		return "merchant/saveProductDetail";
	}	

	@PostMapping(value = "/{productId}/save")
	public String save(
			@PathVariable(value = "productId") Long productId,
			Model model, Variant variant, RedirectAttributes redirectAttributes) {
		Product product = productService.findById(productId);
		variant.setProduct(product);
		productDetailService.save(variant);
		return "redirect:/inventory/product/" + productId;
	}


	@GetMapping(value = "/{productId}/delete")
	public String delete(@PathVariable(name = "productId") Long productId, 
			@RequestParam(name = "variantId", required = true) Long variantId) {
		productDetailService.delete(variantId);
		return "redirect:/inventory/product/" + productId;
	}
}
