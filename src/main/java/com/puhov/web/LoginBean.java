package com.puhov.web;
import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "loginBean", eager = true)
@SessionScoped
public class LoginBean {
	private static final long serialVersionUID = 1L;
	
	public String login;
	public String password;
	
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
