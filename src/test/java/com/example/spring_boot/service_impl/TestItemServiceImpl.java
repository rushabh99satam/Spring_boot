package com.example.spring_boot.service_impl;

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

import com.example.spring_boot.entity.Item;
import com.example.spring_boot.entity.OrderedItems;
import com.example.spring_boot.service.ItemService;
import com.example.spring_boot.service.OrderedItemService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class TestItemServiceImpl {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ItemService itemService;

	@Autowired
	OrderedItemService orderedItemService;

	@Test
	@DirtiesContext
	@Transactional
	void testDeleteItemWithoutOrder() {
		List<Item> items = itemService.deleteItem("1001");
		logger.info("{}", items);
	}

	@Test
	@DirtiesContext
	void testDeleteItemWithOrder() {
		orderedItemService.addItemsToOrder(1, 1001);
		List<Item> items = itemService.deleteItem("1001");
		OrderedItems order = orderedItemService.addItemsToOrder(1, 1002);
		logger.info("Order -> {}", order);
		logger.info("Items -> {}", items);
	}

}
