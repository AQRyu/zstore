package com.aqryuz.zstore.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aqryuz.zstore.entity.Product;
import com.aqryuz.zstore.entity.User;
import com.aqryuz.zstore.entity.Variant;
import com.aqryuz.zstore.repository.ProductDetailRepository;

@RestController
public class VariantController {
	@Autowired
	private ProductDetailRepository productDetailRepository;
	@GetMapping(value = "/api/variants")
	public List<Variant> users(Model model){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return productDetailRepository.findAll();
//		return productService.findAllByUser(user);
	}
	
	@GetMapping(value = "/api/variants/{id}")
	public Variant getProductById(@PathVariable("id") long id){
		return productDetailRepository.findById(id).get();
	}
}
