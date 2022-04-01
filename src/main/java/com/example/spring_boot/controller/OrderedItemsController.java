package com.example.spring_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public List<OrderedItems> getOrders() {
		return orderedItemsService.getAllOrders();
	}
	
	//Will add orders
	@PostMapping("/orders")
	public OrderedItems addOrder(@RequestBody OrderedItems order) {
		return orderedItemsService.saveItem(order);
	}
	
	//Will add items to order
	@PutMapping("/orders/{orderId}/{itemId}")
	public OrderedItems addItemsToOrder(@PathVariable String orderId, @PathVariable String itemId) {
		return orderedItemsService.addItemsToOrder(Integer.parseInt(orderId),Integer.parseInt(itemId));
		
	}
	
	//Will get total cost of item
	@GetMapping("/orders/cost/{orderId}")
	public String totalCostOfOrder(@PathVariable String orderId) {
		return orderedItemsService.totalCostOfOrder(orderId);
	}
	
	//Will delete order
	@DeleteMapping("/orders/{orderId}")
	public List<OrderedItems> deleteOrder(@PathVariable String orderId){
		return orderedItemsService.deleteOrders(orderId);
	}
	
	//Will delete items in order
	@DeleteMapping("/orders/{orderId}/{itemId}")
	public OrderedItems deleteItemsInOrder(@PathVariable String orderId, @PathVariable String itemId){
		return orderedItemsService.deleteItemsInOrder(orderId, itemId);
	}
}
