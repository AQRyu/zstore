package com.aqryuz.zstore.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aqryuz.zstore.entity.OrderLine;
import com.aqryuz.zstore.service.OrderLineService;

@RestController
public class OrderLineController {
	@Autowired
	private OrderLineService orderLineService;
	@GetMapping("/api/orders")
	public List<OrderLine> orders() {
		return orderLineService.findAll();
	}
}
