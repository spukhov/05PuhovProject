package com.puhov.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.puhov.dao.CategoryDao;
import com.puhov.dao.OrdersDao;
import com.puhov.entity.Category;
import com.puhov.entity.Orders;
import com.puhov.entity.Res;

@Transactional
@Service
public class OrdersService {
	
	@Autowired
	private OrdersDao ordersDao;
	
	
	public List<Orders> findAll(){
		return ordersDao.findAll();
	}
	public Orders find (int id){
		return ordersDao.find(id);
	}
	
	public void saveOrder(Orders orders){
		ordersDao.create(orders);
	}
	public int getIdFromOrder(Orders order){
		return ordersDao.getId(order);
	}
	public List<Res> getResList(java.util.Date date1, java.util.Date date2){
		java.sql.Date d1 = new java.sql.Date(date1.getTime());
		java.sql.Date d2 = new java.sql.Date(date2.getTime());
		return ordersDao.getResList(d1, d2);
	}
}
