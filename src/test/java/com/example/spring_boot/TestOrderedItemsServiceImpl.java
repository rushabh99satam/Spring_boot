package com.example.spring_boot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.spring_boot.entity.OrderedItems;
import com.example.spring_boot.service.OrderedItemService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class TestOrderedItemsServiceImpl {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OrderedItemService orderedItemService;
	
	@Test
	@DirtiesContext
	void testAddItemsToOrder() {
		orderedItemService.addItemsToOrder(1, 1001);
		OrderedItems order = orderedItemService.addItemsToOrder(1, 1002);
		logger.info("Ordered Items-> {}", order.getItems());
	}

}
