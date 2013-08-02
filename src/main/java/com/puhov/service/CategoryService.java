package com.puhov.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.puhov.dao.CategoryDao;
import com.puhov.entity.Category;

@Transactional
@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public Category findCategory(String name) {
		return categoryDao.findByName(name);
	}

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public Map<String, Integer> getCategoriesForSelect() {
		List<Category> list = categoryDao.findAll();
		LinkedHashMap<String, Integer> categoryList = new LinkedHashMap<String, Integer>();
		for (Category cat : list) {
			categoryList.put(cat.getCategoryName(), cat.getId());
		}

		return categoryList;
	}

	public void saveCategory(Category category) {
		categoryDao.create(category);
	}

}
