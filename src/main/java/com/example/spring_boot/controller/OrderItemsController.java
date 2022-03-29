package com.example.spring_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot.entity.OrderItems;
import com.example.spring_boot.service.OrderService;

@RestController
public class OrderItemsController {

	@Autowired
	private OrderService orderService;

	//Will get all the orders
	@GetMapping("/orders")
	public List<OrderItems> itemList(Model model) {
		return orderService.getAllOrders();
	}

	//Will add order details
	@PostMapping("/orders")
	public OrderItems additem(@RequestBody OrderItems order) {
		return orderService.saveItem(order);
	}

	//Will link Order Details and Items
	@PutMapping("/orders/{orderId}/{itemId}")
	public OrderItems addItemToOrderItems(@PathVariable String orderId,@PathVariable String itemId) {
		return orderService.addItemsToOrderItems(Integer.parseInt(itemId), Integer.parseInt(orderId));
	}
	
	//Will find total cost of items in given orderId
	@GetMapping("/orders/cost/{orderId}")
	public String totalCost(@PathVariable String orderId) {
		return orderService.getTotalCostOfItems(orderId);
	}
	
	@DeleteMapping("/orders/{orderId}")
	public void deleteItem(@PathVariable String orderId) {
		orderService.deleteOrder(Integer.parseInt(orderId));
	}
}
