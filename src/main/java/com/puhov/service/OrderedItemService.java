package com.puhov.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puhov.dao.MenuItemDao;
import com.puhov.dao.OrderedItemDao;
import com.puhov.dao.OrdersDao;
import com.puhov.dao.UserDao;
import com.puhov.entity.OrderedItem;
import com.puhov.entity.Res;
import com.puhov.entity.ResCategory;
import com.puhov.entity.Users;


@Component
public class OrderedItemService {
	@Autowired
	private OrderedItemDao orderedItemDao;
	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private MenuItemDao menuItemDao;
	
	@Transactional
	public List<OrderedItem> findAll(){
		return orderedItemDao.findAll();
	}
	@Transactional
	public void markAsPrepared(int id){
		orderedItemDao.markAsPrepared(id);
	}
	public void saveOrdereItem(OrderedItem orderedItem){
		orderedItemDao.create(orderedItem);
	}
	@Transactional
	public List<ResCategory> getDetailResList(java.util.Date date1, java.util.Date date2){
		java.sql.Date d1 = new java.sql.Date(date1.getTime());
		java.sql.Date d2 = new java.sql.Date(date2.getTime());
		return orderedItemDao.getDetailResList(d1, d2);
	}
	@Transactional
	public List<ResCategory> getDetailResListByDay(java.util.Date date){
		java.sql.Date d1 = new java.sql.Date(date.getTime());
		return orderedItemDao.getDetailResListByDay(d1);
	}
	
}
