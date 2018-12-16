package com.aqryuz.zstore.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "products")
public class Product extends Auditable implements Serializable{
	private static final long serialVersionUID = -3176501715539191096L;
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private BigDecimal price;
	private BigDecimal salePrice;
	@Transient
	private MultipartFile image;
	private String imageName;
	@Lob
	private String description;
	private String status;
	private String category;
}