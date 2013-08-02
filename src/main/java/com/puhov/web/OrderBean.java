package com.puhov.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puhov.entity.MenuItem;
import com.puhov.entity.OrderedItem;
import com.puhov.entity.Orders;
import com.puhov.service.MenuItemService;
import com.puhov.service.OrderedItemService;
import com.puhov.service.OrdersService;

@Component
@ManagedBean
@RequestScoped
public class OrderBean {
	@Autowired
	private MenuItemService menuItemService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	OrderedItemService orderedItemService;

	private int menuItemId;

	private int id;
	private String clientName;
	private String phoneNumber;

	private List<MenuItem> menuItemList = new ArrayList<MenuItem>();

	public double orderSum() {
		double sum = 0.0;
		for (MenuItem m : getMenuItemList()) {
			sum += m.getPrice();
		}
		return sum;
	}

	public String addToOrder() {
		menuItemList.add(menuItemService.find(this.menuItemId));
		return "category";
	}

	public String removeFromOrder(int menuItemId) {
		Iterator<MenuItem> i = menuItemList.iterator();
		while (i.hasNext()) {
			if (i.next().getId() == menuItemId) {
				i.remove();
			}
		}
		return "order_page";
	}

	@Transactional
	public String getSaveOrder() {
		Orders order = new Orders(this.clientName, this.phoneNumber, orderSum());
		ordersService.saveOrder(order);
		int orderId = ordersService.getIdFromOrder(order);
		Orders searchedOrder = ordersService.find(orderId);

		Iterator<MenuItem> iterator = menuItemList.iterator();
		while (iterator.hasNext()) {
			MenuItem menu = iterator.next();
			MenuItem searchedMenu = menuItemService.find(menuItemService
					.getId(menu));

			orderedItemService.saveOrdereItem(new OrderedItem(searchedOrder,
					searchedMenu, searchedMenu.getPrice()));
		}

		return "result_save_order";
	}
	
	
	/// Getters and Setters

	public int getMenuItemId() {
		return menuItemId;
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public OrdersService getOrdersService() {
		return ordersService;
	}

	public int getId() {
		return id;
	}

	public String getClientName() {
		return clientName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
