package com.example.spring_boot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Integer itemId;

	private String name;

	private Double cost;
	
	@ManyToOne
	private OrderItems order;

	public Item() {
	}

	public Item(String name, Double cost) {
		super();
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Integer getItemId() {
		return itemId;
	}

	public OrderItems getOrder() {
		return order;
	}

	public void setOrder(OrderItems order) {
		this.order = order;
	}

	
}
