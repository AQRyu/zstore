package com.aqryuz.zstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.aqryuz.zstore.entity.User;
import com.aqryuz.zstore.entity.Variant;
import com.aqryuz.zstore.repository.ProductDetailRepository;

@Service
public class ProductDetailService {
	@Autowired
	private ProductDetailRepository productDetailRepository;

	
	public Page<Variant> findAll(Long productId, Pageable pageable) {
		return productDetailRepository.findAllByProductId(productId, pageable);
	}
	
	public List<Variant> findAll(Long productId) {
		return productDetailRepository.findAllByProductId(productId);
	}

	public Variant save(Variant variant){
		User user = productDetailRepository.findById(variant.getId()).get().getCreatedBy();
		variant.setCreatedBy(user);
		return productDetailRepository.save(variant);
	}
	
	public void delete(Long id) {
		productDetailRepository.findById(id).ifPresent(productDetailRepository::delete);
	}

	public Variant findById(Long id) {
		return productDetailRepository.findById(id).get();
	}

	public List<Variant> findAllByCreatedBy(User user) {
		return productDetailRepository.findAllByCreatedBy(user);
	}
}
