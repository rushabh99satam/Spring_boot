package com.example.spring_boot.service;

import java.util.List;

import com.example.spring_boot.entity.OrderedItems;

/**
 * Interface OrderedItem service.
 * @author Rushabh Satam
 *
 */
public interface OrderedItemService {

	/**
	 * This method returns OrderedItems object with specified orderId.
	 * 
	 * @param orderId Id of the OrderedItems in String.
	 * @return OrderedItems object with given orderId
	 */
	OrderedItems getOrderById(String orderId);

	/**
	 * This method gets list of OrderedItems from database.
	 * 
	 * @return List of OrderedItems object.
	 */
	List<OrderedItems> getAllOrders();

	/**
	 * This method inserts OrderedItems object inside database and returns the
	 * inserted object.
	 * 
	 * @param order OrderedItems object.
	 * @return OrderedItems object.
	 */
	OrderedItems saveItem(OrderedItems order);

	/**
	 * This method inserts Item object with specified itemId in list inside OrderedItems
	 * object with specified orderId.
	 * 
	 * @param orderId Id of OrderedItems object in String.
	 * @param itemId  Id of Item object in String.
	 * @return OrderedItems object with specified orderId.
	 */
	OrderedItems addItemsToOrder(String customerId, String itemId);

	/**
	 * This method will return total cost of OrderedItems with given orderId.
	 * 
	 * @param customerId Id of customers in OrderedItems object in String.
	 * @return Cost of OrderedItems in String
	 */
	String totalCostOfOrder(String orderId);

	/**
	 * This method This method deletes specified OrderedItems object from database
	 * and returns list of OrderedItems from database.
	 * 
	 * @param orderId Id of OrderedItems object in String.
	 * @return List of OrderedItems object.
	 */
	List<OrderedItems> deleteOrders(String orderId);

	/**
	 * This method deletes Item object with specified itemId from list of items
	 * inside OrderedItems object with specified orderId
	 * 
	 * @param orderId Id of OrderedItems object in String.
	 * @param itemId  Id of Items object in String.
	 * @return OrderedItems object with given orderId.
	 */
	OrderedItems deleteItemsInOrder(String orderId, String itemId);
}
