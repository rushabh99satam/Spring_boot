package com.example.spring_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
	private ItemService itemService;
	
//	public ItemController(ItemService itemService) {
//		super();
//		this.itemService = itemService;
//	}

//Will get all the items
	@GetMapping("/items")
	public List<Item> itemList(Model model) {
		return itemService.getAllItems();
	}
	
	//Will add items to database
	@PostMapping("/items")
	public Item additem(@RequestBody Item item) {
		return itemService.saveItem(item);
	}
	
	//Will delete items in database
	@DeleteMapping("/items/{itemId}")
	public void deleteItem(@PathVariable String itemId) {
		itemService.deleteItem(Integer.parseInt(itemId));
	}
	
	
}
