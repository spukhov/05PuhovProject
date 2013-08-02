package com.puhov.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.puhov.dao.UserDao;
import com.puhov.dao.UserRolesDao;
import com.puhov.entity.Role;
import com.puhov.entity.UserRoles;
import com.puhov.entity.Users;

@Transactional
@Component
public class UserRolesService {
	@Autowired
	private UserRolesDao userRolesDao;

	public void add(UserRoles userRole) {
		userRolesDao.create(userRole);
	}

}
