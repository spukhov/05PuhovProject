package com.puhov.web;
import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import org.apache.jasper.tagplugins.jstl.core.Out;

import com.puhov.entity.Category;
import com.puhov.entity.MenuItem;
import com.puhov.service.CategoryService;

@Component
@ManagedBean
@RequestScoped
public class CategoryBean {
	@Autowired
	private CategoryService categoryService;

	
	public CategoryBean(){
	}
	public List<Category> getCategoryList(){
		return categoryService.findAll();
	}
	
	public Map<String,Integer> getCategoriesForSelect(){
		return categoryService.getCategoriesForSelect();
	}
	
}
