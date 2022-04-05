package com.example.spring_boot.service_impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot.entity.Item;
import com.example.spring_boot.entity.OrderedItems;
import com.example.spring_boot.repository.ItemRepository;
import com.example.spring_boot.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;

	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public Item saveItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public List<Item> deleteItem(String itemId) {
		Item item = itemRepository.getById(Integer.parseInt(itemId));
		List<OrderedItems> orders = item.getOrders();
		if (orders == null) {
			itemRepository.delete(item);
		} else {
			for (OrderedItems orderedItems : orders) {
				orderedItems.removeItems(item);
			}
			itemRepository.delete(item);
		}

		return getAllItems();
	}

	@Override
	public Item getById(String itemId) {
		return itemRepository.getById(Integer.parseInt(itemId));
	}

}
