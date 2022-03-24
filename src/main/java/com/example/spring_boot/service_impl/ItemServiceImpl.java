package com.example.spring_boot.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot.entity.Item;
import com.example.spring_boot.repository.ItemRepository;
import com.example.spring_boot.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

}
