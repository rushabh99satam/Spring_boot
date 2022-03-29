package com.example.spring_boot.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "FieldHandler"})
public class Item {

	@Id
	@GeneratedValue
	private Integer itemId;

	private String name;

	private Double cost;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "items")
	private List<OrderedItems> orders;

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

	public List<OrderedItems> getOrders() {
		return orders;
	}

	public void addOrder(OrderedItems order) {
		 orders.add(order);
	}
	public void removeOrder(OrderedItems order) {
		orders.add(order);
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", cost=" + cost + "]";
	}
	
}
