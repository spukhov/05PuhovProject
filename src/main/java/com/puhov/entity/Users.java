package com.puhov.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Users implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String userName;
	private String email;
	private String password;
	private int actual;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="userroles", joinColumns=@JoinColumn(name="userId"),
	   inverseJoinColumns=@JoinColumn(name="roleId"))
	private List<Role> roles;

	
	public Users() {

	}
	
	public Users(String userName, String email, String password, int actual) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.actual = actual;
	}
	
	
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public int getActual() {
		return actual;
	}

	public void setActual(int actual) {
		this.actual = actual;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}



	

}
