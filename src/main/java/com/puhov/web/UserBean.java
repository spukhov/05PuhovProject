package com.puhov.web;

import java.util.*;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puhov.entity.Role;
import com.puhov.entity.UserRoles;
import com.puhov.entity.Users;
import com.puhov.service.RoleService;
import com.puhov.service.UserRolesService;
import com.puhov.service.UserService;

@Component
@ManagedBean (eager=true)
@SessionScoped
public class UserBean {

	private static final Logger log = Logger
			.getLogger(UserBean.class.getName());

	@Autowired
	private UserService userService;
	@Autowired
	private UserRolesService userRolesService;
	@Autowired
	private RoleService roleService;


	private String userName;
	private int userId;
	private String email;
	private String password;

	private boolean isLogged;

	private boolean flagKitchen;
	private boolean flagManager;
	private boolean flagAdmin;

	public UserBean() {
	}

	//@Transactional
	public String findUser() {
		 
		try{
			Users user = userService.findByEmailAndPass(this.email, this.password);
			for (Role r : user.getRoles()) {
				if (r.getRoleName().equals("Administrator"))
					flagAdmin = true;
				if (r.getRoleName().equals("Manager"))
					flagManager = true;
				if (r.getRoleName().equals("Kitchen Worker"))
					flagKitchen = true;
			}
			this.isLogged = true;
			log.info("User " + user.getUserName() + " is logged in");
			return "result_login";
		}
		catch(NoResultException e){
			return "access_denied";
		}
		
		
	}

	public List<Users> getAll() {
		return userService.findAllUsers();
	}
	@Transactional
	public String getCreateUser() {
		List<Role> roles= new ArrayList<Role>();
		Users user = new Users(this.userName, this.email, this.password,1);
		if (flagAdmin){
			roles.add(roleService.findRoleByName("Administrator"));	
		}
		if (flagManager){
			roles.add(roleService.findRoleByName("Manager"));	
		}
		if (flagKitchen){
			roles.add(roleService.findRoleByName("Kitchen Worker"));	
		}
		user.setRoles(roles);
		
		userService.add(user);
		
		return "result_add_user";
	}

	public String changeActual() {
		userService.changeActual(this.userId);
		return "info";
	}

	public String getEditUser() {
		userService.editUser(this.userId, this.userName, this.email,
				this.password, 1);
		return "info";
	}

	public boolean verifyUser() {
		boolean flag = false;
		if (userService.findByEmailAndPass(this.email, this.password) != null) {
			flag = true;
		}
		return flag;
	}

	public void logout() {
		isLogged = false;
		flagAdmin = false;
		flagKitchen = false;
		flagManager = false;
	}

	// Getters - Setters

	public int getUserId() {
		return userId;
	}

	public boolean getIsLogged() {
		return isLogged;
	}

	public boolean isFlagKitchen() {
		return flagKitchen;
	}

	public boolean isFlagManager() {
		return flagManager;
	}

	public boolean isFlagAdmin() {
		return flagAdmin;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public void setFlagKitchen(boolean flagKitchen) {
		this.flagKitchen = flagKitchen;
	}

	public void setFlagManager(boolean flagManager) {
		this.flagManager = flagManager;
	}

	public void setFlagAdmin(boolean flagAdmin) {
		this.flagAdmin = flagAdmin;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
