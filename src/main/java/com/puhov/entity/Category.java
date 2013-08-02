package com.puhov.entity;

import java.util.*;
import javax.persistence.*;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String categoryName;
	private String categoryImage;

	public Category(String categoryName, int id) {
		this.id = id;
		this.categoryName = categoryName;
	}
	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	@OneToMany(mappedBy = "category")
	private List<MenuItem> dishList;
	
	public String getCategoryImage() {
		return categoryImage;
	}
	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}
	public Category(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<MenuItem> getDishList() {
		return dishList;
	}
		

}
