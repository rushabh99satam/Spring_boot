package com.example.spring_boot.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//By default, Jackson 2 will only work with with fields that are either public, or have a public 
//getter methods – serializing an entity that has all fields private or package private will fail:
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "FieldHandler"})
public class OrderItems {
 

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
	
	@OneToMany(mappedBy = "order")
	private List<Item> items = new ArrayList<>();

	public OrderItems() {};
	
//	public OrderItems(int customerId, Date dateOfDelivery, String addressOfDelivery, List<Item> items) {
//		super();
//		this.customerId = customerId;
//		this.dateOfDelivery = dateOfDelivery;
//		this.addressOfDelivery = addressOfDelivery;
//		this.items = items;
//	}
	
	public OrderItems(int customerId, Date dateOfDelivery, String addressOfDelivery) {
		super();
		this.customerId = customerId;
		this.dateOfDelivery = dateOfDelivery;
		this.addressOfDelivery = addressOfDelivery;
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

	public void addItems(Item item) {
		items.add(item);
	}
	
	public void removeItems(Item item) {
		items.remove(item);
	}

	public Integer getOrderId() {
		return orderId;
	}
	
	@Override
	public String toString() {
		return "OrderItems [orderId=" + orderId + ", customerId=" + customerId + ", dateOfDelivery=" + dateOfDelivery
				+ ", addressOfDelivery=" + addressOfDelivery + ", items=" + items + "]";
	}
		
}
