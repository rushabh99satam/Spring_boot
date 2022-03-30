package com.example.spring_boot.service;

import java.util.List;

import com.example.spring_boot.entity.Item;

public interface ItemService {

	//Will get all items
	List<Item> getAllItems();
	//Will save item
	Item saveItem(Item item);
	//Will delete item
	List<Item> deleteItem(String itemId);
}
