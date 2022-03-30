package com.example.spring_boot;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.spring_boot.entity.OrderedItems;
import com.example.spring_boot.service.OrderedItemService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	OrderedItemService orderedItemService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		orderedItemService.saveItem(new OrderedItems(1, new Date(), "Borivali"));
		orderedItemService.saveItem(new OrderedItems(2, new Date(), "Thane"));
		
	}

}
