package com.example.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot.entity.OrderItems;

public interface OrderRepository extends JpaRepository<OrderItems, Integer>{

}
