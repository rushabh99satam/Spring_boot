package com.example.spring_boot.service;

import java.util.List;

import com.example.spring_boot.entity.OrderItems;

public interface OrderService {

	List<OrderItems> getAllItems();
}
