package com.example.spring_boot.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Entity for OrderedItems.
 * 
 * @author Rushabh Satam
 */
@Entity
//By default, Jackson 2 will only work with with fields that are either public, or have a public 
//getter methods – serializing an entity that has all fields private or package private will fail:
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer", "FieldHandler" })
public class OrderedItems {

	@Id
	@GeneratedValue
	@Column(name = "Id")
	private Integer orderId;

	@Column(name = "cutomer_Id")
	private int customerId;

	@Column(name = "dateOfDelivery")
	private Date dateOfDelivery;

	@Column(name = "addressOfDelivery")
	private String addressOfDelivery;

	@ManyToMany
	// For customization of table
	@JoinTable(name = "Order_Item", joinColumns = @JoinColumn(name = "Order_Id"), inverseJoinColumns = @JoinColumn(name = "Item_Id"))
	private List<Item> items = new ArrayList<>();

	/**
	 * Default constructor.
	 */
	public OrderedItems() {
	};

	/**
	 * Constructor to initialize customer Id, date of delivery and address of
	 * delivery.
	 * 
	 * @param customerId        Id of customer in integer.
	 * @param dateOfDelivery    Date of delivery in java.util.Date.
	 * @param addressOfDelivery Address of delivery in String.
	 */
	public OrderedItems(int customerId, Date dateOfDelivery, String addressOfDelivery) {
		super();
		this.customerId = customerId;
		this.dateOfDelivery = dateOfDelivery;
		this.addressOfDelivery = addressOfDelivery;
	}

	/**
	 * Gets Id of customer.
	 * 
	 * @return Customer Id in integer.
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Sets Id of customer.
	 * 
	 * @param customerId Id of customer in integer
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * Gets date of delivery.
	 * 
	 * @return date of delivery in java.util.Date.
	 */
	public Date getDateOfDelivery() {
		return dateOfDelivery;
	}

	/**
	 * Sets date of delivery.
	 * 
	 * @param dateOfDelivery Date of delivery in java.util.Date.
	 */
	public void setDateOfDelivery(Date dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}

	/**
	 * Gets Address of delivery.
	 * 
	 * @return Address of delivery in String.
	 */
	public String getAddressOfDelivery() {
		return addressOfDelivery;
	}

	/**
	 * Sets address of delivery.
	 * 
	 * @param addressOfDelivery Address of delivery in string.
	 */
	public void setAddressOfDelivery(String addressOfDelivery) {
		this.addressOfDelivery = addressOfDelivery;
	}

	/**
	 * Gets list of items from the OrderedItems object.
	 * 
	 * @return List of Item object.
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * Adds items to OrderedItems object.
	 * 
	 * @param item Item object.
	 */
	public void addItems(Item item) {
		items.add(item);
	}

	/**
	 * Removes items from OrderedItems object.
	 * 
	 * @param item Item object.
	 */
	public void removeItems(Item item) {
		items.remove(item);
	}

	/**
	 * Gets the Id of the OrderedItem object.
	 * 
	 * @return Id of OrderedItem object in integer.
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * To string method
	 */
	@Override
	public String toString() {
		return "OrderItems [orderId=" + orderId + ", customerId=" + customerId + ", dateOfDelivery=" + dateOfDelivery
				+ ", addressOfDelivery=" + addressOfDelivery + ", items=" + items + "]";
	}

}
