package com.example.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot.entity.OrderedItems;

public interface OrderedItemsRepository extends JpaRepository<OrderedItems, Integer>{

}
