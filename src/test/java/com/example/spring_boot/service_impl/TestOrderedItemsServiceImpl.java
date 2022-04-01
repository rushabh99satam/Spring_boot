package com.example.spring_boot.service_impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.spring_boot.entity.OrderedItems;
import com.example.spring_boot.repository.ItemRepository;
import com.example.spring_boot.service.OrderedItemService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class TestOrderedItemsServiceImpl {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OrderedItemService orderedItemService;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Test
	@DirtiesContext
	void testAddItemsToOrder() {
		orderedItemService.addItemsToOrder(1, 1001);
		OrderedItems order = orderedItemService.addItemsToOrder(1, 1002);
		logger.info("Ordered Items-> {}", order.getItems());
	}

	@Test
	@DirtiesContext
	void testTotalCostOfOrder() {
		orderedItemService.addItemsToOrder(1, 1001);
		orderedItemService.addItemsToOrder(1, 1002);
		assertEquals("2000.0", orderedItemService.totalCostOfOrder("1"));
		
	}
	
	@Test
	@DirtiesContext
	void testDeleteOrdersWithoutItems() {
		List<OrderedItems> orders = orderedItemService.deleteOrders("1");
		logger.info("Orders -> {}",orders);
	}
	
	@Test
	@DirtiesContext
	void testDeleteOrdersWithItems() {
		orderedItemService.addItemsToOrder(1, 1001);
		orderedItemService.addItemsToOrder(1, 1002);
		List<OrderedItems> orders = orderedItemService.deleteOrders("1");
		logger.info("Items orders ->{}",itemRepository.getById(1001).getOrders());
		logger.info("Orders -> {}",orders);
	}
	
	@Test
	@DirtiesContext
	void testdeleteItemsInOrder() {
		orderedItemService.addItemsToOrder(1, 1001);
		orderedItemService.addItemsToOrder(1, 1002);
		OrderedItems deleteItemsInOrder = orderedItemService.deleteItemsInOrder("1", "1001");
		logger.info("Orders ->{}", deleteItemsInOrder);
	}
}
