package com.aqryuz.zstore.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aqryuz.zstore.entity.Product;
import com.aqryuz.zstore.entity.User;


@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long>{
	public List<Product> findProductByName(@Param(value = "name") String name);
	public void delete(Product product);
	public Page<Product> findProductsByCategory(Pageable pageable, @Param(value = "category") String category);
	public Page<Product> findProductsByCreatedBy(Pageable pageable, @Param(value = "createdBy") User user);
	public List<Product> findProductsByCreatedBy(@Param(value = "createdBy") User user);
}
