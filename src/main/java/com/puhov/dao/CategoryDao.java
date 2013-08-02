package com.puhov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.puhov.entity.Category;

@Repository
public class CategoryDao extends GenericDaoImpl<Category> {
	@PersistenceContext
    private EntityManager em;

    public Category findByName(String name) {
        return (Category) em.createQuery("SELECT c from Category c where c.categoryName = :name").setParameter("name", name).getSingleResult();
    }

    public List<Category> findAll() {
        return em.createQuery("from Category").getResultList();
    }
}
