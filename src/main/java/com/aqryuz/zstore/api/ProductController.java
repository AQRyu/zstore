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
import com.aqryuz.zstore.repository.ProductRepository;

@RestController
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	@GetMapping(value = "/api/products")
	public List<Product> products(Model model){
		return productRepository.findAll();
//		return productService.findAllByUser(user);
	}
	
	@GetMapping(value = "/api/productsByMerchant")
	public List<Product> productsByMerchant(){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return productRepository.findProductsByCreatedBy(user);
	}
	@GetMapping(value = "/api/products/{id}")
	public Product getProductById(@PathVariable("id") long id){
		return productRepository.findById(id).get();
	}
}
