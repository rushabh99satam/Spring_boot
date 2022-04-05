package com.example.spring_boot.service;

import java.util.List;

import com.example.spring_boot.entity.Item;

/**
 * Interface for Item service
 * @author Rushabh Satam
 *
 */
public interface ItemService {

	/**
	 * This method returns Item object with specified itemId.
	 * 
	 * @param itemId Id of the item in String.
	 * @return Item object with given itemId.
	 */
	Item getById(String itemId);

	/**
	 * This method gets all items from database.
	 * 
	 * @return List of Item objects.
	 */
	List<Item> getAllItems();

	/**
	 * This method inserts item inside database and returns inserted Item object.
	 * 
	 * @param item Item object.
	 * @return Item object.
	 */
	Item saveItem(Item item);

	/**
	 * This method deletes specified Item object from database and returns list of
	 * items from database.
	 * 
	 * @param itemId Id of item in String.
	 * @return List of Item object.
	 */
	List<Item> deleteItem(String itemId);
}
