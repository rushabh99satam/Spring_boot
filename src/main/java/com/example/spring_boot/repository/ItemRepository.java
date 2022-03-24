package com.example.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
