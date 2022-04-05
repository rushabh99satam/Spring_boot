package com.example.spring_boot.service_impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

import com.example.spring_boot.entity.OrderedItems;
import com.example.spring_boot.service.ItemService;
import com.example.spring_boot.service.OrderedItemService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class TestOrderedItemsServiceImpl {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	@Autowired
	OrderedItemService orderedItemService;
	
	@Autowired
	ItemService itemService;
	
	@Test
	@DirtiesContext
	void testAddItemsToOrder() {
		logger.info("********** testAddItemsToOrder **********");
		OrderedItems order = orderedItemService.addItemsToOrder("1", "1001");
		assertEquals(1, order.getItems().size());
	}

	@Test
	@DirtiesContext
	void testTotalCostOfOrder() {
		logger.info("********** testTotalCostOfOrder **********");
		orderedItemService.addItemsToOrder("1", "1001");
		orderedItemService.addItemsToOrder("1", "1002");
		assertEquals("2000.0", orderedItemService.totalCostOfOrder("1"));
		
	}
	
	@Test
	@DirtiesContext
	void testDeleteOrdersWithoutItems() {
		logger.info("********** testDeleteOrdersWithoutItems **********");
		orderedItemService.deleteOrders("1");
		assertNull(em.find(OrderedItems.class, 1));
	}
	
	@Test
	@DirtiesContext
	void testDeleteOrdersWithItems() {
		logger.info("********** testDeleteOrdersWithItems **********");
		orderedItemService.addItemsToOrder("1", "1001");
		orderedItemService.addItemsToOrder("1", "1002");
		orderedItemService.deleteOrders("1");
		assertNull(em.find(OrderedItems.class, 1));
		assertEquals(0,itemService.getById("1001").getOrders().size());
	}
	
	@Test
	@DirtiesContext
	void testdeleteItemsInOrder() {
		logger.info("********** testdeleteItemsInOrder **********");
		orderedItemService.addItemsToOrder("1", "1001");
		orderedItemService.addItemsToOrder("1", "1002");
		OrderedItems deleteItemsInOrder = orderedItemService.deleteItemsInOrder("1", "1001");
		assertEquals(1, deleteItemsInOrder.getItems().size());
	}
}
