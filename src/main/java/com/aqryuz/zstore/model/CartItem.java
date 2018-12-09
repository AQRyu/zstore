package com.aqryuz.zstore.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartItem {
	private String imageName;
	private String productName;
	private Integer quantity;
	private String size;
	private BigDecimal price;
	private BigDecimal discount;
	private BigDecimal totalPrice;
	private Long variantId;
	private Long productId;

}
