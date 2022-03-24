package com.example.spring_boot.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot.service.ItemService;

@RestController
public class ItemController {

	private ItemService itemService;
	
	public ItemController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}


	@GetMapping("/items")
	public String itemList(Model model) {
		model.addAttribute("item", itemService.getAllItems());
		return "items";
	}
}
