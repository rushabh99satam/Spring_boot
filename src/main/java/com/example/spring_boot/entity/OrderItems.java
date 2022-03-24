package com.example.spring_boot.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OrderItems {
 
	@Id
	@GeneratedValue
	private Integer orderId;
	
	private int customerId;
	
	private Date dateOfDelivery;
	
	private String addressOfDelivery;
	
	@OneToMany(mappedBy = "order")
	private List<Item> items;

	public OrderItems() {};
	
	public OrderItems(int customerId, Date dateOfDelivery, String addressOfDelivery, List<Item> items) {
		super();
		this.customerId = customerId;
		this.dateOfDelivery = dateOfDelivery;
		this.addressOfDelivery = addressOfDelivery;
		this.items = items;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getDateOfDelivery() {
		return dateOfDelivery;
	}

	public void setDateOfDelivery(Date dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}

	public String getAddressOfDelivery() {
		return addressOfDelivery;
	}

	public void setAddressOfDelivery(String addressOfDelivery) {
		this.addressOfDelivery = addressOfDelivery;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Integer getOrderId() {
		return orderId;
	}
	
	
	
}
