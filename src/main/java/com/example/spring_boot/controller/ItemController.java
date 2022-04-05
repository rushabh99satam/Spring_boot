package com.example.spring_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot.entity.Item;
import com.example.spring_boot.service.ItemService;

/**
 * Items api controller.
 * 
 * @author Rushabh Satam
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("api/v1")
public class ItemController {

	@Autowired
	ItemService itemService;

	/**
	 * This method gets all items from database.
	 * 
	 * @return List of Item objects in json .
	 */
	@GetMapping("/items")
	public List<Item> getItems() {
		return itemService.getAllItems();
	}

	/**
	 * This method returns Item object with specified itemId.
	 * 
	 * @param itemId Id of the item in String.
	 * @return Item object with given itemId in json.
	 */
	@GetMapping("/items/{itemId}")
	public Item getItemsById(@PathVariable String itemId) {
		return itemService.getById(itemId);
	}

	/**
	 * This method inserts item inside database and returns inserted Item object.
	 * 
	 * @param item Item object.
	 * @return Item object with given itemId in json.
	 */
	@PostMapping("/items")
	public Item addItem(@RequestBody Item item) {
		return itemService.saveItem(item);
	}

	/**
	 * This method deletes specified Item object from database and returns list of
	 * items from database.
	 * 
	 * @param itemId Id of the item in String.
	 * @return List of Item objects from database in json.
	 */
	@DeleteMapping("/items/{itemId}")
	public List<Item> deleteItem(@PathVariable String itemId) {
		return itemService.deleteItem(itemId);
	}
}
