package com.aqryuz.zstore.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aqryuz.zstore.entity.Product;
import com.aqryuz.zstore.entity.User;
import com.aqryuz.zstore.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	public static String uploadDirectory = System.getProperty("user.dir")+"/images";


	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	public Product save(Product product){
		MultipartFile image = product.getImage();
		String imgName = image.getOriginalFilename();;
		product.setImageName(imgName);

		Path fileNameAndPath = Paths.get(uploadDirectory, imgName);
		try {
			Files.write(fileNameAndPath, image.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		product.setCreatedBy(user);
		return productRepository.save(product);
	}

	public void delete(Long id) {
		productRepository.findById(id).ifPresent(productRepository::delete);
	}

	public Product findById(Long id) {
		return productRepository.findById(id).get();
	}

	public Page<Product> findAllByName(Pageable pageable, String category){
		return productRepository.findProductsByCategory(pageable, category);
	}

	public Page<Product> findAllByUser(Pageable pageable, User user){
		return productRepository.findProductsByCreatedBy(pageable, user);
	}
	
	public List<Product> findAllByUser(User user){
		return productRepository.findProductsByCreatedBy(user);
	}
}
