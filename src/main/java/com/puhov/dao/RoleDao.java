package com.puhov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.puhov.entity.Category;
import com.puhov.entity.Role;
import com.puhov.entity.UserRoles;
import com.puhov.entity.Users;

@Repository
public class RoleDao extends GenericDaoImpl<Role> {
	@PersistenceContext
    private EntityManager em;

    public List<Role> findAll() {
        return em.createQuery("from Roles").getResultList();
    }
    public Role findByName(String name) {
        return (Role) em.createQuery("SELECT u from Role u where u.roleName = :name").setParameter("name", name).getSingleResult();
    }
    
}
