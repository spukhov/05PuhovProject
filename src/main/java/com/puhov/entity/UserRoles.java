package com.puhov.entity;

import javax.persistence.*;

@Entity
public class UserRoles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int users;
	private int role;
	public UserRoles(int users, int role) {
		this.users = users;
		this.role = role;
	}
	public UserRoles(){
		
	}
}
