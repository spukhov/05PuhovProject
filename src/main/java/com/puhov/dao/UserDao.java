package com.puhov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.puhov.entity.Users;

@Repository
public class UserDao extends GenericDaoImpl<Users> {
	@PersistenceContext
    private EntityManager em;

    public Users findByEmail(String email) {
        return (Users) em.createQuery("SELECT u from Users u where u.email = :email").setParameter("email", email).getSingleResult();
    }
    public void changeActual(int userId){
    	find(userId).setActual(0);
    }
    public void editUser(int userId, String userName, String email,String password,int actual){
    	Users user = find(userId);
    	user.setUserName(userName);
    	user.setEmail(email);
    	user.setPassword(password);
    	user.setActual(1);
    	update(user);
    }
    
    public Users findByEmailAndPass(String email, String pass) {
        return (Users) em.createQuery("SELECT u from Users u where u.email = :email and u.password =:pass")
        		.setParameter("email", email).setParameter("pass", pass).getSingleResult();
    }
    
    
    
    public List<Users> findAll() {
        return em.createQuery("Select u from Users u Where u.actual=1").getResultList();
    }
}
