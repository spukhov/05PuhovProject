package com.puhov.web;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import org.apache.jasper.tagplugins.jstl.core.Out;

import com.puhov.entity.OrderedItem;
import com.puhov.service.OrderedItemService;

@Component
@ManagedBean
@RequestScoped
public class KitchenBean {
	@Autowired
	private OrderedItemService orderedItemService;

	public KitchenBean() {

	}

	public List<OrderedItem> getOrderedItemList() {
		return orderedItemService.findAll();
	}

	public String markAsPrepared(int orderedItemId) {
		orderedItemService.markAsPrepared(orderedItemId);
		return "kitchen";
	}
}
