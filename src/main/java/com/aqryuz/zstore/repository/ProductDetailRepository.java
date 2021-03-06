package com.aqryuz.zstore.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aqryuz.zstore.entity.User;
import com.aqryuz.zstore.entity.Variant;

@Repository
@Transactional
public interface ProductDetailRepository extends JpaRepository<Variant, Long>{
	public Page<Variant> findAllByProductId(Long productId, Pageable pageable);
	public Variant findVariantBySize(@Param(value = "size") String size);
	public void delete(Variant variant);
	public List<Variant> findAllByProductId(@Param(value = "productId")Long productId);
	public List<Variant> findAllByCreatedBy(@Param(value = "createdBy") User user);
}
