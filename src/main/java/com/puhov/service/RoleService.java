package com.puhov.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.puhov.dao.CategoryDao;
import com.puhov.dao.RoleDao;
import com.puhov.entity.Category;
import com.puhov.entity.Role;

@Transactional
@Service
public class RoleService {
	
	@Autowired
	private RoleDao roleDao;

	public Role findRoleByName(String name){
		return roleDao.findByName(name);
	}
	public Role find(Role role){
		return roleDao.find(role);
	}
	
	

}
