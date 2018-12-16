package com.aqryuz.zstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aqryuz.zstore.entity.OrderLine;
import com.aqryuz.zstore.entity.User;
import com.aqryuz.zstore.repository.OrderLineRepository;

@Service
public class OrderLineService {
	@Autowired
	private OrderLineRepository orderLineRepository;

	public List<OrderLine> findAll(){
		return orderLineRepository.findAll();
	}


	public Page<OrderLine> findAll(Pageable pageable) {
		return orderLineRepository.findAll(pageable);
	}

	public OrderLine save(OrderLine rderLine){
		return orderLineRepository.saveAndFlush(rderLine);
	}

	public void delete(Long id) {
		orderLineRepository.findById(id).ifPresent(orderLineRepository::delete);
	}

	public OrderLine findById(Long id) {
		return orderLineRepository.findById(id).get();
	}

	public Page<OrderLine> findAllByMerchant(Pageable pageable, User user) {
		return orderLineRepository.findAllByMerchant(pageable, user);
	}

}
