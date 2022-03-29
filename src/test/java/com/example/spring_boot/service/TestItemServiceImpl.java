package com.example.spring_boot.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.spring_boot.entity.Item;
import com.example.spring_boot.entity.OrderItems;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class TestItemServiceImpl {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ItemService itemService;

	@Autowired 
	OrderService orderService;
	
	@Autowired
	EntityManager em;
	
	@Test
	@DirtiesContext
	void testDeleteItemWhenItIsLinkToOrder() {
		OrderItems orderItems = orderService.addItemsToOrderItems(1001, 1);
		logger.info("OrderItems -> {}", orderItems);
		itemService.deleteItem(1001);
		List<Item> allItems = itemService.getAllItems();
		logger.info("OrderItems -> {}", orderItems);
		logger.info("AllItems -> {}", allItems);
	}
	
	@Test
	@DirtiesContext
	void testDeleteItemWhenItIsNotLinkToOrder() {
		itemService.deleteItem(1001);
		List<Item> allItems = itemService.getAllItems();
		logger.info("AllItems -> {}", allItems);
	}

}
