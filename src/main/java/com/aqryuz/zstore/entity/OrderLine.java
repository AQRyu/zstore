package com.aqryuz.zstore.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_lines")
public class OrderLine implements Serializable{
	private static final long serialVersionUID = -965095682769525352L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(optional = false)
    @JoinColumn(name="order_id", nullable=false)
	private Order order;
	
	@ManyToOne(optional = false)
    @JoinColumn(name="variant_id", nullable=false)
	private Variant variant;
	
	@ManyToOne(optional = false)
    @JoinColumn(name="merchant_id", nullable=false)
	private User merchant;
	
	private BigDecimal price;
	private Integer quantity;
	//pending, Awaiting shipment, complete, cancel
	private String status;
}
