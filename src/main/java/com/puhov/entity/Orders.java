package com.puhov.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String clientName;
	private String phoneNumber;
	private java.sql.Date orderDate;
	private double orderTotal;
	
	@OneToMany(mappedBy = "orders")
	private List<OrderedItem> orderedItems;

	
	public Orders(String clientName, String phoneNumber, java.sql.Date orderDate,
			double orderTotal) {
		
		this.clientName = clientName;
		this.phoneNumber = phoneNumber;
		this.orderDate = new java.sql.Date(new java.util.Date().getTime());
		this.orderTotal = orderTotal;
	}
	
	public Orders(String clientName, String phoneNumber, 
			double orderTotal) {
		this.orderDate = new java.sql.Date(new java.util.Date().getTime());
		this.clientName = clientName;
		this.phoneNumber = phoneNumber;
		this.orderTotal = orderTotal;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public java.sql.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.sql.Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public int getId() {
		return id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", clientName=" + clientName
				+ ", orderDate=" + orderDate + ", orderTotal=" + orderTotal
				+ "]";
	}

	public Orders() {

	}

}
