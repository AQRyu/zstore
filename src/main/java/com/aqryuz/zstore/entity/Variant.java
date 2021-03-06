package com.aqryuz.zstore.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "variants")
public class Variant extends Auditable implements Serializable{
	private static final long serialVersionUID = -975258019680564571L;
	@Id
	@GeneratedValue
	private Long id;
	private String size;
	private Integer quantity;

	@ManyToOne( optional=false)
	@JoinColumn(name="product_id", nullable=false)
	private Product product;
}