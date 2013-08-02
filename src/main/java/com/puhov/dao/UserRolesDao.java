package com.puhov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.puhov.entity.Category;
import com.puhov.entity.Role;
import com.puhov.entity.UserRoles;

@Repository
public class UserRolesDao extends GenericDaoImpl<UserRoles> {
	@PersistenceContext
    private EntityManager em;

    public List<UserRoles> findAll() {
        return em.createQuery("from UserRoles").getResultList();
    }
}
