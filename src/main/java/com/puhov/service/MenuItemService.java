package com.puhov.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.puhov.dao.*;
import com.puhov.entity.*;

@Transactional
@Service
public class MenuItemService {
	
	@Autowired
	private MenuItemDao menuItemDao;
	@Autowired
	private CategoryDao categoryDao;

	public MenuItem findMenuItem(String name){
		return menuItemDao.findByName(name);
	}
	
	public void add(String dishName, int kitchenMade, int categoryId, double price, int actual){
		Category cat = categoryDao.find(categoryId);
		menuItemDao.create(new MenuItem(dishName, kitchenMade, cat, price, actual));
	}
	public void edit(int menuItemId,String dishName, int kitchenMade, int categoryId, double price, int actual){
		Category cat = categoryDao.find(categoryId);
		menuItemDao.editMenuItem(menuItemId, dishName, price, cat, kitchenMade, actual);
	}
	
	public void changeActual(int id){
		menuItemDao.changeActual(id);
	}
	
	public List<MenuItem> findAll(){
		return menuItemDao.findAll();
	}
	public MenuItem find(int id){
		return menuItemDao.find(id);
	}
	public List<Object> findAllOrdered(){
		return menuItemDao.findAllOrdered();
	}
	
	public List<MenuItem> findMenuItemByCategoryId(int id) {
		return menuItemDao.findMenuItemByCategoryId(id);
	}
	public int getId(MenuItem menuItem){
		return menuItemDao.getId(menuItem);
	}
}
