package com.example.spring_boot.service_impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot.entity.OrderedItems;
import com.example.spring_boot.repository.OrderedItemsRepository;
import com.example.spring_boot.service.OrderedItemService;

@Service
@Transactional
public class OrderedItemsServiceImpl implements OrderedItemService {

	@Autowired
	OrderedItemsRepository orderedItemsRepository;
	
	@Override
	public List<OrderedItems> getAllItems() {
		return orderedItemsRepository.findAll();
	}

	@Override
	public OrderedItems saveItem(OrderedItems order) {
		return orderedItemsRepository.save(order);
	}

}
