package com.puhov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.puhov.entity.Category;
import com.puhov.entity.Orders;
import com.puhov.entity.Res;

@Repository
public class OrdersDao extends GenericDaoImpl<Orders> {
	@PersistenceContext
    private EntityManager em;


    public List<Orders> findAll() {
        return em.createQuery("from Orders").getResultList();
    }
    public int getId (Orders order){
    	int id = 0;
    	 TypedQuery query = em.createQuery(
    					"SELECT o from Orders o where o.phoneNumber=:phone and o.orderDate=:date",
    					Orders.class);
    	 query.setParameter("phone", order.getPhoneNumber());
    	 query.setParameter("date", order.getOrderDate());
    	 Orders searchedOrder = (Orders)query.getSingleResult();
    	return order.getId();
    }
    
    public List<Res> getResList(java.sql.Date date1, java.sql.Date date2){
    	TypedQuery<Res> query = em.createQuery(
				"SELECT new com.puhov.entity.Res(o.orderDate, COUNT(o), SUM(o.orderTotal)) " +
						"FROM Orders o WHERE o.orderDate BETWEEN ?1 AND ?2  GROUP BY o.orderDate", Res.class);
    	query.setParameter(1, date1);
    	query.setParameter(2, date2);
    	
    	return query.getResultList();
    }

}    