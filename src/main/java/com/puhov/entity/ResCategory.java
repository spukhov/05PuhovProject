package com.puhov.entity;

import java.text.SimpleDateFormat;

public class ResCategory {

	private java.util.Date orderDate;
	 private Category category;
	 private long orderCount;
	 private double orderTotalSum;
	 private SimpleDateFormat dtFrm = new SimpleDateFormat("dd.MM.yyyy");
	 
	 public ResCategory() {
	  
	 }
	 public ResCategory(java.util.Date orderDate, Category category, long orderCount, double orderTotalSum) {
	  super();
	  this.orderDate = orderDate;
	  this.category = category;
	  this.orderCount = orderCount;
	  this.orderTotalSum = orderTotalSum;
	 }
	 public ResCategory( Category category, long orderCount, double orderTotalSum) {
		  super();
		  this.category = category;
		  this.orderCount = orderCount;
		  this.orderTotalSum = orderTotalSum;
		 }
	 
	 public void printInfo() {
	  System.out.println("Date:" + getOrderDate());
	  System.out.println("Category:" + getCategory().getCategoryName());
	  System.out.println("product count:" + getOrderCount());
	  System.out.println("Total sum:" + getOrderTotalSum());
	 }
	 
	 public Category getCategory() {
	  return category;
	 }
	 public String getOrderDateFormat() {
			return  dtFrm.format(orderDate);
		}
	 public void setCategory(Category category) {
	  this.category = category;
	 }
	 public long getOrderCount() {
	  return orderCount;
	 }
	 public void setOrderCount(long count) {
	  this.orderCount = count;
	 }
	 public double getOrderTotalSum() {
	  return orderTotalSum;
	 }
	 public void setOrderTotalSum(double totalSum) {
	  this.orderTotalSum = totalSum;
	 }
	 public java.util.Date getOrderDate() {
	  return orderDate;
	 }
	 public void setOrderDate(java.util.Date orderDate) {
	  this.orderDate = orderDate;
	 }
}
