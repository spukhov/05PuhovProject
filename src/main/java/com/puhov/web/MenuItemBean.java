package com.puhov.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.puhov.entity.Category;
import com.puhov.entity.MenuItem;
import com.puhov.service.CategoryService;
import com.puhov.service.MenuItemService;

@Component
@ManagedBean
@RequestScoped
public class MenuItemBean {
	@Autowired
	private MenuItemService menuItemService;
	@Autowired
	private CategoryService categoryService;
	

	private int id;
	private String dishName;
	private double price;
	private int kitchenMade;
	private int prepared;
	private int categoryId;
	private int actual;
	
	private String category;
	
	public MenuItemBean() {

	}
	public List<Category> getCategories(){
		return categoryService.findAll();
	}
	public String getNewMenuItem() {
		List<MenuItem> list = menuItemService.findAll();
		for (MenuItem m : list){
			if (m.getDishName().equals(this.dishName)){
				return "access_denied";
			}
		}
		menuItemService.add( this.dishName, this.kitchenMade, this.categoryId, this.price, this.actual);
		return "result_add_dish";
	}
	
	public String getEdit(){
		menuItemService.edit(this.id, this.dishName, this.kitchenMade, this.categoryId, this.price, this.actual);
		return "category";
	}
	
	public String changeActual(){
		menuItemService.changeActual(this.id);
		return "category";
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemService.findAll();
	}

	public List<Object> getOrderedItemList() {
		return menuItemService.findAllOrdered();
	}

	public List<MenuItem> getMenuItemByCategoryId() {
		return menuItemService.findMenuItemByCategoryId(categoryId);
	}

	public MenuItemService getMenuItemService() {
		return menuItemService;
	}

	public int getId() {
		return id;
	}

	public String getDishName() {
		return dishName;
	}

	public double getPrice() {
		return price;
	}

	public int getKitchenMade() {
		return kitchenMade;
	}

	public int getPrepared() {
		return prepared;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setMenuItemService(MenuItemService menuItemService) {
		this.menuItemService = menuItemService;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	public void setKitchenMade(int kitchenMade) {
		this.kitchenMade = kitchenMade;
	}

	public void setPrepared(int prepared) {
		this.prepared = prepared;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getActual() {
		return actual;
	}

	public void setActual(int actual) {
		this.actual = actual;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
}
