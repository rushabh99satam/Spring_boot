package com.example.spring_boot;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.spring_boot.entity.OrderItems;
import com.example.spring_boot.service.ItemService;
import com.example.spring_boot.service.OrderService;

@SpringBootApplication
@Transactional
public class Application implements CommandLineRunner{
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	EntityManager em;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		orderService.saveItem(new OrderItems(1,new Date(),"Ashokvan"));
		
		
	}
	

}
