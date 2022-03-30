package com.example.spring_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot.entity.Item;
import com.example.spring_boot.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;
	
	//Will get items
	@GetMapping("/items")
	public List<Item> getItems() {
		return itemService.getAllItems();
	}
	
	//Will add item
	@PostMapping("/items")
	public Item addItem(@RequestBody Item item) {
		return itemService.saveItem(item);
	}
	
	//Will delete item
	@DeleteMapping("/items/{itemId}")
	public List<Item> deleteItem(@PathVariable String itemId){
		return itemService.deleteItem(itemId);
	}
}
