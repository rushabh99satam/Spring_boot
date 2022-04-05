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

import com.example.spring_boot.entity.Item;
import com.example.spring_boot.entity.OrderedItems;
import com.example.spring_boot.service.ItemService;
import com.example.spring_boot.service.OrderedItemService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class TestItemServiceImpl {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	@Autowired
	ItemService itemService;

	@Autowired
	OrderedItemService orderedItemService;

	@Test
	@DirtiesContext
	void testDeleteItemWithoutOrder() {
		logger.info("********** testDeleteItemWithoutOrder **********");
		itemService.deleteItem("1001");
		Item item = em.find(Item.class,1001);
		assertNull(item);
	}

	@Test
	@DirtiesContext
	void testDeleteItemWithOrder() {
		logger.info("********** testDeleteItemWithOrder **********");
		orderedItemService.addItemsToOrder("1", "1001");
		itemService.deleteItem("1001");
		OrderedItems orderById = orderedItemService.getOrderById("1");
		Item item = em.find(Item.class,1001);
		assertNull(item);
		assertEquals(0, orderById.getItems().size());
	}

}
