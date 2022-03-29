package com.example.spring_boot.service_impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot.entity.Item;
import com.example.spring_boot.entity.OrderItems;
import com.example.spring_boot.repository.ItemRepository;
import com.example.spring_boot.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public Item saveItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public void deleteItem(Integer itemId) {
		Item item = itemRepository.getById(itemId);
		OrderItems order = item.getOrder();
		if (order == null) {
			itemRepository.delete(item);
		}
		else {
			order.removeItems(item);
			itemRepository.delete(item);
		}
			
		
	}

}
