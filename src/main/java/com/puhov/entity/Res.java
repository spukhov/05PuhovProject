package com.puhov.entity;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Res {
	private java.util.Date orderDate;
	private long orderCount;
	private double orderTotalSum;
	private SimpleDateFormat dtFrm = new SimpleDateFormat("dd.MM.yyyy");
	
	private List<ResCategory> list;

	public java.util.Date getOrderDate() {
		return orderDate;
	}
	public String getOrderDateFormat() {
		return  dtFrm.format(orderDate);
	}

	public void setOrderDate(java.sql.Date orderDate) {
		this.orderDate = orderDate;
	}

	public long getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(long orderCount) {
		this.orderCount = orderCount;
	}

	public double getOrderTotalSum() {
		return orderTotalSum;
	}

	public void setOrderTotalSum(double orderTotalSum) {
		this.orderTotalSum = orderTotalSum;
	}
	
	private ArrayList<ResCategory> resList = new ArrayList<ResCategory>();
	
	public ArrayList<ResCategory> getResList() {
		return resList;
	}

	public void setResList(ArrayList<ResCategory> resList) {
		this.resList = resList;
	}

	public Res(){
		
	}

	public Res(java.util.Date orderDate, long orderCount, double orderTotalSum) {
		this.orderDate = orderDate;
		this.orderCount = orderCount;
		this.orderTotalSum = orderTotalSum;
	}
	
	public Res(java.util.Date orderDate, long orderCount, double orderTotalSum, ArrayList<ResCategory> resList) {
		this.orderDate = orderDate;
		this.orderCount = orderCount;
		this.orderTotalSum = orderTotalSum;
		this.resList = resList;
	}


}
