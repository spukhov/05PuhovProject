package com.puhov.entity;

import java.util.*;

import javax.persistence.*;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToMany
	@JoinTable(name="userroles", joinColumns=@JoinColumn(name="roleId"),
	   inverseJoinColumns=@JoinColumn(name="userId"))
	private List<Users> usersList;
	
	private String roleName;
	
	public Role(){
		
	}
	

	public Role(String roleName) {
		this.roleName = roleName;
	}


	public int getId() {
		return id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	

	public List<Users> getUsersList() {
		return usersList;
	}
	
	
	

}
