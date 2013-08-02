package com.puhov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.puhov.entity.OrderedItem;
import com.puhov.entity.Res;
import com.puhov.entity.ResCategory;
@Repository
public class OrderedItemDao extends GenericDaoImpl<OrderedItem> {
	@PersistenceContext
    private EntityManager em;
	
	public List<OrderedItem> findAll(){
		return em.createQuery("SELECT o FROM OrderedItem o WHERE o.menuItem.kitchenMade=1 and o.prepared=0").getResultList();
	}
	
	public void markAsPrepared(int id){
		find(id).setPrepared(1);
	}
	
	public List<ResCategory> getDetailResList(java.sql.Date date1, java.sql.Date date2){
    	TypedQuery<ResCategory> query = em.createQuery(
				"SELECT new com.puhov.entity.ResCategory(d.orders.orderDate, d.menuItem.category, COUNT(d), SUM(d.price)) " +
		  "FROM OrderedItem d " +
		  "WHERE d.orders.orderDate BETWEEN ?1 AND ?2 " +
		  "GROUP BY d.orders.orderDate, d.menuItem.category ", 
		  ResCategory.class);
    	query.setParameter(1, date1);
    	query.setParameter(2, date2);
    	
    	return query.getResultList();
    }
	public List<ResCategory> getDetailResListByDay(java.sql.Date date){
    	TypedQuery<ResCategory> query = em.createQuery(
				"SELECT new com.puhov.entity.ResCategory(d.orders.orderDate, d.menuItem.category, COUNT(d), SUM(d.price)) " +
		  "FROM OrderedItem d " +
		  "WHERE d.orders.orderDate = ?1 " +
		  "GROUP BY d.orders.orderDate, d.menuItem.category ", 
		  ResCategory.class);
    	query.setParameter(1, date);
    	
    	return query.getResultList();
    }
	
}
