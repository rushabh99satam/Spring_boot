package com.example.spring_boot.service_impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot.entity.Item;
import com.example.spring_boot.entity.OrderedItems;
import com.example.spring_boot.repository.ItemRepository;
import com.example.spring_boot.repository.OrderedItemsRepository;
import com.example.spring_boot.service.OrderedItemService;

/**
 * Implementation of OrderedItemService
 * 
 * @author Rushabh Satam
 */
@Service
@Transactional
public class OrderedItemsServiceImpl implements OrderedItemService {

	@Autowired
	OrderedItemsRepository orderedItemsRepository;

	@Autowired
	ItemRepository itemRepository;

	@Override
	public List<OrderedItems> getAllOrders() {
		return orderedItemsRepository.findAll();
	}

	@Override
	public OrderedItems saveItem(OrderedItems order) {
		return orderedItemsRepository.save(order);
	}

	@Override
	public OrderedItems addItemsToOrder(String customerId, String itemId) {
		List<OrderedItems> allOrders = getAllOrders();
		int orderId = 0;
		for (OrderedItems orderedItems : allOrders) {
			if (orderedItems.getCustomerId() == Integer.parseInt(customerId)) {
				orderId = orderedItems.getOrderId();
			}
		}
		OrderedItems orderedItems = orderedItemsRepository.getById(orderId);
		Item item = itemRepository.getById(Integer.parseInt(itemId));
		item.addOrder(orderedItems);
		orderedItems.addItems(item);
		return orderedItemsRepository.save(orderedItems);
	}

	@Override
	public Map<String, Double> totalCostOfOrder(String orderId) {
		OrderedItems orderedItems = orderedItemsRepository.getById(Integer.parseInt(orderId));
		Double cost = 0d;
		for (Item item : orderedItems.getItems()) {
			cost = cost + item.getCost();
		}
		Map<String, Double> response = new HashMap<String, Double>();
		response.put(orderId, cost);
		return response;
	}

	@Override
	public List<OrderedItems> deleteOrders(String orderId) {
		OrderedItems orderedItem = orderedItemsRepository.getById(Integer.parseInt(orderId));
		List<Item> items = orderedItem.getItems();
		if (items == null) {
			orderedItemsRepository.delete(orderedItem);
		} else {
			for (Item item : items) {
				item.removeOrder(orderedItem);
			}
			orderedItemsRepository.delete(orderedItem);
		}

		return getAllOrders();
	}

	@Override
	public OrderedItems deleteItemsInOrder(String orderId, String itemId) {
		OrderedItems order = orderedItemsRepository.getById(Integer.parseInt(orderId));
		Item item = itemRepository.getById(Integer.parseInt(itemId));
		order.removeItems(item);
		item.removeOrder(order);
		return saveItem(order);
	}

	@Override
	public OrderedItems getOrderById(String orderId) {
		return orderedItemsRepository.getById(Integer.parseInt(orderId));
	}

}
