package com.example.spring_boot.service;

import java.util.List;

import com.example.spring_boot.entity.OrderedItems;

public interface OrderedItemService {

	//Will get all items
	List<OrderedItems> getAllOrders();
	//Will save item
	OrderedItems saveItem(OrderedItems order);
	//Add items to order
	OrderedItems addItemsToOrder(Integer orderId, Integer itemId);
	//Find the total cost of order
	String totalCostOfOrder(String orderId);
	//Delete Order
	List<OrderedItems> deleteOrders(String orderId);
	//Delete items in order
	OrderedItems deleteItemsInOrder(String orderId, String itemId);
}
