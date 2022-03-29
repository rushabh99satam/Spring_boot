package com.example.spring_boot.service;

import java.util.List;

import com.example.spring_boot.entity.OrderItems;

public interface OrderService {

	List<OrderItems> getAllOrders();             //Will get all items
	OrderItems saveItem(OrderItems orderItems);	//Will save provided order details to database
	OrderItems addItemsToOrderItems(Integer itemId, Integer orderItemsId); //Will add items to orderItems
	String getTotalCostOfItems(String orderId); //Will get total cost of items
	void deleteOrder(Integer courseId); 
}
