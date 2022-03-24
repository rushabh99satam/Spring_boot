package com.example.spring_boot.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot.entity.OrderItems;
import com.example.spring_boot.repository.OrderRepository;
import com.example.spring_boot.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<OrderItems> getAllItems() {
		return orderRepository.findAll();
	}
	
	

}
