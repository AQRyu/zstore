package com.aqryuz.zstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aqryuz.zstore.entity.Order;
import com.aqryuz.zstore.entity.User;
import com.aqryuz.zstore.repository.OrderRepository;


@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findAll(){
		return orderRepository.findAll();
	}

	public Page<Order> findAll(Pageable pageable) {
		return orderRepository.findAll(pageable);
	}

	public Order save(Order order){
		return orderRepository.saveAndFlush(order);
	}

	public void delete(Long id) {
		orderRepository.findById(id).ifPresent(orderRepository::delete);
	}

	public Order findById(Long id) {
		return orderRepository.findById(id).get();
	}

	public Page<Order> findAllByUser(Pageable pageable, User user){
		return orderRepository.findProductsByCreatedBy(pageable, user);
	}

}
