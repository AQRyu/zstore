package com.aqryuz.zstore.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aqryuz.zstore.entity.Order;
import com.aqryuz.zstore.entity.OrderLine;
import com.aqryuz.zstore.entity.User;

@Repository
@Transactional
public interface OrderLineRepository extends JpaRepository<OrderLine, Long>{
	public Page<OrderLine> findAllByOrder(@Param(value = "order")Order order, Pageable pageable);
	public void delete(OrderLine orderLine);
	public Page<OrderLine> findAllByMerchant(Pageable pageable, @Param(value = "merchant") User merchant);
}
