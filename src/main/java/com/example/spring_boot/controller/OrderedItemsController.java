package com.example.spring_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot.entity.OrderedItems;
import com.example.spring_boot.service.OrderedItemService;

@RestController
public class OrderedItemsController {

	@Autowired
	OrderedItemService orderedItemsService;
	
	//Will get orders
	@GetMapping("/orders")
	public List<OrderedItems> getItems() {
		return orderedItemsService.getAllItems();
	}
	
	//Will add orders
	@PostMapping("/orders")
	public OrderedItems addItem(@RequestBody OrderedItems order) {
		return orderedItemsService.saveItem(order);
	}
	
	
}
