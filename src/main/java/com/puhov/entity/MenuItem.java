package com.puhov.entity;

import java.util.*;

import javax.persistence.*;

@Entity
public class MenuItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dishName;
	private int kitchenMade;
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	private double price;
	private int actual;

	@OneToMany(mappedBy = "menuItem")
	private List<OrderedItem> orderedItems;

	public MenuItem() {

	}

	public MenuItem(String dishName, int kitchenMade, Category category,
			double price, int actual) {
		this.dishName = dishName;
		this.kitchenMade = kitchenMade;
		this.category = category;
		this.price = price;
		this.actual = actual;
	}

	@Override
	public String toString() {
		return "Dish: " + dishName + " [id=" + id + ", kitchenMade="
				+ kitchenMade + ", category=" + category + ", price=" + price
				+ "]";
	}

	public int getId() {
		return id;
	}

	public int getActual() {
		return actual;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setActual(int actual) {
		this.actual = actual;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public int getKitchenMade() {
		return kitchenMade;
	}

	public void setKitchenMade(int kitchenMade) {
		this.kitchenMade = kitchenMade;
		if (kitchenMade != 1 && kitchenMade != 0) {
			System.out.println("Insert correct Kitchen-Made parameters (1 or 0)");
		}
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
