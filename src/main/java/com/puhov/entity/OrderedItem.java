package com.puhov.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class OrderedItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Orders orders;
	@ManyToOne
	@JoinColumn(name = "menuItemId")
	private MenuItem menuItem;
	private double price;
	private int prepared;
	
	
	public OrderedItem(Orders orders, MenuItem menuItem, double price) {
		this.orders = orders;
		this.menuItem = menuItem;
		this.price = price;
		this.prepared = 0;
	}
//	public OrderedItem(int orderId, int menuItemId, int cooked) {
//		super();
//		this.orderId = orderId;
//		this.menuItemId = menuItemId;
//		this.prepared = cooked;
//	}

	public int getPrepared() {
		return prepared;
	}

	public void setPrepared(int cooked) {
		this.prepared = cooked;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
		
	public OrderedItem(){
		
	}
	
}
