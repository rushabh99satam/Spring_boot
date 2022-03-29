package com.example.spring_boot.service;

import java.util.List;

import com.example.spring_boot.entity.Item;

public interface ItemService {

	List<Item> getAllItems();	//Will get all the items
	Item saveItem(Item item);	//Will save items to database
	void deleteItem(Integer itemId); // Will delete item
}
