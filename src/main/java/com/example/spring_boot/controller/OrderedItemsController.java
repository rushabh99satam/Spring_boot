package com.example.spring_boot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot.entity.OrderedItems;
import com.example.spring_boot.service.OrderedItemService;

/**
 * Orders api controller
 * 
 * @author Rushabh Satam
 *
 */
@RestController
@RequestMapping("api/v1")
public class OrderedItemsController {

	@Autowired
	OrderedItemService orderedItemsService;

	/**
	 * This method gets list of OrderedItems from database.
	 * 
	 * @return List of OrderedItems object in json.
	 */
	@GetMapping("/orders")
	public List<OrderedItems> getOrders() {
		return orderedItemsService.getAllOrders();
	}

	/**
	 * This method returns OrderedItems object with specified orderId.
	 * 
	 * @param orderId Id of the OrderedItems in String.
	 * @return OrderedItems object with given orderId in json.
	 */
	@GetMapping("/orders/{orderId}")
	public OrderedItems getOrdersById(@PathVariable String orderId) {
		return orderedItemsService.getOrderById(orderId);
	}

	/**
	 * This method inserts OrderedItems object inside database and returns the
	 * inserted object.
	 * 
	 * @param order OrderedItems object.
	 * @return OrderedItems object.
	 */
	@PostMapping("/orders")
	public OrderedItems addOrder(@RequestBody OrderedItems order) {
		return orderedItemsService.saveItem(order);
	}

	/**
	 * This method inserts Item object with specified itemId in list inside
	 * OrderedItems object with specified orderId.
	 * 
	 * @param orderId Id of OrderedItems object in String.
	 * @param itemId  Id of Item object in String.
	 * @return OrderedItems object with specified orderId in json.
	 */
	@PutMapping("/orders/{orderId}/{itemId}")
	public OrderedItems addItemsToOrder(@PathVariable String orderId, @PathVariable String itemId) {
		return orderedItemsService.addItemsToOrder(orderId, itemId);

	}

	/**
	 * This method will return total cost of OrderedItems with given orderId.
	 * 
	 * @param orderId Id of OrderedItems object in String.
	 * @return Cost of OrderedItems in String and Double in key value pair.
	 */
	@GetMapping("/orders/cost/{orderId}")
	public Map<String, Double> totalCostOfOrder(@PathVariable String orderId) {
		return orderedItemsService.totalCostOfOrder(orderId);
	}

	/**
	 * This method This method deletes specified OrderedItems object from database
	 * and returns list of OrderedItems from database.
	 * 
	 * @param orderId Id of OrderedItems object in String.
	 * @return List of OrderedItems object.
	 */
	@DeleteMapping("/orders/{orderId}")
	public List<OrderedItems> deleteOrder(@PathVariable String orderId) {
		return orderedItemsService.deleteOrders(orderId);
	}

	/**
	 * This method deletes Item object with specified itemId from list of items
	 * inside OrderedItems object with specified orderId
	 * 
	 * @param orderId Id of OrderedItems object in String.
	 * @param itemId  Id of Items object in String.
	 * @return OrderedItems object with given orderId.
	 */
	@DeleteMapping("/orders/{orderId}/{itemId}")
	public OrderedItems deleteItemsInOrder(@PathVariable String orderId, @PathVariable String itemId) {
		return orderedItemsService.deleteItemsInOrder(orderId, itemId);
	}
}
