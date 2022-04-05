package com.example.spring_boot.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Item Entity
 * 
 * @author Rushabh Satam
 */
@Entity
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer", "FieldHandler" })
public class Item {

	@Id
	@GeneratedValue
	private Integer itemId;

	private String name;

	private Double cost;

	@JsonIgnore
	@ManyToMany(mappedBy = "items")
	private List<OrderedItems> orders;

	/**
	 * Default item constructor.
	 */
	public Item() {
	}

	/**
	 * Item constructor that accepts name and cost.
	 * 
	 * @param name Name of the item in string.
	 * @param cost Cost of the item in double.
	 */
	public Item(String name, Double cost) {
		super();
		this.name = name;
		this.cost = cost;
	}

	/**
	 * Gets name of the item.
	 * 
	 * @return Name of the item in string.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name of the item in String.
	 * 
	 * @param name of the item in string.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets cost of the item.
	 * 
	 * @return Cost of the item in double.
	 */
	public Double getCost() {
		return cost;
	}

	/**
	 * Sets cost of the item.
	 * 
	 * @param cost Cost of item in double.
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}

	/**
	 * Gets Id of the item.
	 * 
	 * @return Id of Item object in integer.
	 */
	public Integer getItemId() {
		return itemId;
	}

	/**
	 * Gets list of OrderedItem object from Item object.
	 * 
	 * @return List of OrderedItem object.
	 */
	public List<OrderedItems> getOrders() {
		return orders;
	}

	/**
	 * Adds OrderedItems object in list.
	 * 
	 * @param order OrderedItems object.
	 */
	public void addOrder(OrderedItems order) {
		orders.add(order);
	}

	/**
	 * Removes OrderedItems object from list.
	 * 
	 * @param order OrderedItems object.
	 */
	public void removeOrder(OrderedItems order) {
		orders.add(order);
	}

	/**
	 * To string method.
	 */
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", cost=" + cost + "]";
	}

}
