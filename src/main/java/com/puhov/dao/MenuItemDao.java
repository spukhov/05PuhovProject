package com.puhov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.puhov.entity.*;

@Repository
public class MenuItemDao extends GenericDaoImpl<MenuItem> {
	@PersistenceContext
	private EntityManager em;

	public MenuItem findByName(String name) {
		return (MenuItem) em
				.createQuery(
						"SELECT m from MenuItem m where m.menuItemName = :name")
				.setParameter("name", name).getSingleResult();
	}

	public List<MenuItem> findAll() {
		return em.createQuery("from MenuItem").getResultList();
	}

	public List<Object> findAllOrdered() {
		return em.createQuery(
						"SELECT m.dishName, o.prepared from MenuItem m, OrderedItem o WHERE m.id=o.menuItemId AND m.kitchenMade=1")
				.getResultList();
	}

	public List<MenuItem> findMenuItemByCategoryId(int id) {
		return em
				.createQuery(
						"FROM MenuItem m WHERE m.category.id = :id and actual=1")
				.setParameter("id", id).getResultList();
	}
	public void changeActual(int menuItemId){
    	find(menuItemId).setActual(0);
    }
	public void editMenuItem(int menuItemId, String dishName, double price, Category category, int kitchenMade, int actual){
    	MenuItem m = find(menuItemId);
    	m.setDishName(dishName);
    	m.setKitchenMade(kitchenMade);
    	m.setPrice(price);
    	m.setCategory(category);
    	m.setActual(actual);
    	update(m);
    }
	public int getId (MenuItem menuItem){
    	int id = 0;
    	 TypedQuery query = em.createQuery(
    					"SELECT m from MenuItem m where m.dishName=:name",
    					MenuItem.class);
    	 query.setParameter("name", menuItem.getDishName());
    	 MenuItem searchedOrder = (MenuItem)query.getSingleResult();
    	return menuItem.getId();
    }

}
