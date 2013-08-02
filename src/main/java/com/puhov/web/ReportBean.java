package com.puhov.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.puhov.entity.Category;
import com.puhov.entity.Res;
import com.puhov.entity.ResCategory;
import com.puhov.service.OrderedItemService;
import com.puhov.service.OrdersService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@ManagedBean
@RequestScoped
public class ReportBean {
	@Autowired
	OrdersService ordersService;
	@Autowired
	OrderedItemService orderedItemService;
	
	
	private java.util.Date startDate;
	private java.util.Date endDate;
	private SimpleDateFormat dtFrm = new SimpleDateFormat("dd.MM.yyyy");
	
	List<ResCategory> list;
	

	public List<Res> getReportList(){
		return ordersService.getResList(this.startDate, this.endDate);
	}
	
	public List<ResCategory> getDetailReportList(){
		return orderedItemService.getDetailResList(this.startDate, this.endDate);
	}
	public List<ResCategory> getDetailReportListByDay(java.util.Date d){
		return orderedItemService.getDetailResListByDay(d);
	}

	

	
	/// Getters and Setters
	
	public java.util.Date getStartDate() {
		return startDate;
	}
	public String getStartDateFormat() {
		return dtFrm.format(startDate);
	}
	 
	public java.util.Date getEndDate() {
		return endDate;
	}

	

	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}
	
	
	public ReportBean(){
		
	}

}
