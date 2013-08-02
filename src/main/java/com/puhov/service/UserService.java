package com.puhov.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puhov.dao.UserDao;
import com.puhov.entity.Users;

@Transactional
@Component
public class UserService {
	@Autowired
	private UserDao userDao;

	public void add(Users user) {
		userDao.create(user);
	}

	public List<Users> findAllUsers() {
		return userDao.findAll();
	}

	public Users findByEmail(String name) {
		return userDao.findByEmail(name);
	}
	
	public void changeActual(int id){
		userDao.changeActual(id);
	}
	
	public void editUser(int userId, String userName, String email,String password,int actual){
		userDao.editUser(userId, userName, email, password, actual);
	}

	public Users findByEmailAndPass(String email, String pass) {
		return userDao.findByEmailAndPass(email, pass);
	}
}
