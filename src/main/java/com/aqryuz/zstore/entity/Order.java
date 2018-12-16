package com.aqryuz.zstore.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "orders")
public class Order extends Auditable implements Serializable{
	private static final long serialVersionUID = 549639641086984302L;
	@Id
	private String id;
	private Integer quantity;
	private BigDecimal total;
	private String customerName;
	private String customerAddress;
	private String customerCity;
	private String customerPhone;

}
