package com.example.spring_boot.service;

import java.util.List;

import com.example.spring_boot.entity.OrderedItems;

public interface OrderedItemService {

	//Will get all items
	List<OrderedItems> getAllItems();
	//Will save item
	OrderedItems saveItem(OrderedItems order);
	//Add items to order
	OrderedItems addItemsToOrder(Integer orderId, Integer itemId);
}
