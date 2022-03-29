package com.example.spring_boot.service_impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot.entity.Item;
import com.example.spring_boot.entity.OrderItems;
import com.example.spring_boot.repository.ItemRepository;
import com.example.spring_boot.repository.OrderRepository;
import com.example.spring_boot.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private EntityManager em;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public List<OrderItems> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public OrderItems saveItem(OrderItems orderItems) {
		return orderRepository.save(orderItems);
	}

	@Override
	public OrderItems addItemsToOrderItems(Integer itemId, Integer orderItemsId) {
		Item item = itemRepository.getById(itemId);
		OrderItems order = orderRepository.getById(orderItemsId);
		order.addItems(item);
		item.setOrder(order);
		em.persist(item);
		return order;
	}

	@Override
	public String getTotalCostOfItems(String orderId) {
		OrderItems orderItems = orderRepository.getById(Integer.parseInt(orderId));
		List<Item> items = orderItems.getItems();
		Double cost = 0d;
		for (Item item : items) {
			cost = cost + item.getCost();
		}
		return String.valueOf(cost);
	}

	@Override
	public void deleteOrder(Integer courseId) {
		OrderItems orderItem = orderRepository.getById(courseId);
		List<Item> items = orderItem.getItems();
		if (items == null) {
			orderRepository.delete(orderItem);
		} else {
			for (Item item : items) {
				item.setOrder(null);
			}

			orderRepository.delete(orderItem);
		}
	}

}
