package com.example.spring_boot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
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

import com.example.spring_boot.entity.OrderItems;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class TestOrderServiceImpl {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ItemService itemService;

	@Autowired
	OrderService orderService;

	@Autowired
	EntityManager em;

	@Test
	@DirtiesContext
	void testAddItemsToOrderItems() {
		OrderItems orderItems = orderService.saveItem(new OrderItems(1, new Date(), "Ashokvan"));
		orderService.addItemsToOrderItems(1001, orderItems.getOrderId());
		logger.info("The orders are -> {}", orderItems);

	}

	@Test
	@DirtiesContext
	void testgetTotalCostOfItems() {
		OrderItems orderItems = orderService.saveItem(new OrderItems(1, new Date(), "Ashokvan"));
		orderService.addItemsToOrderItems(1001, orderItems.getOrderId());
		orderService.addItemsToOrderItems(1002, orderItems.getOrderId());
		assertEquals("2000.0", orderService.getTotalCostOfItems(String.valueOf(orderItems.getOrderId())));
	}

	@Test
	@DirtiesContext
	void testdeleteOrderWithoutItems() {
		orderService.deleteOrder(1);
		List<OrderItems> allOrders = orderService.getAllOrders();
		assertEquals(new ArrayList<>(), allOrders);
	}
	
	
	
//	@Test
//	@DirtiesContext
//	void testdeleteOrderWithItems() {
//		OrderItems orderItems = orderService.addItemsToOrderItems(1001, 1);
//		logger.info("Orders -> {}", orderItems);
//		orderService.deleteOrder(1);
//		List<Item> items = orderItems.getItems();
//		for (Item item : items) {
//			logger.info("{}",item.getOrder());
//		}
//		List<OrderItems> allOrders = orderService.getAllOrders();
//		assertEquals(new ArrayList<>(), allOrders);
//	}

}
