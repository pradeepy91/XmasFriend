package com.xmas.game.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xmas.game.entity.UserGroup;
import com.xmas.game.repository.UserGroupRespository;

@Component
public class UserGroupRespositoryImpl {
	@Autowired
	UserGroupRespository repository;
	
	public UserGroup createGroup(String groupName,String[] members) {
		UserGroup group = new UserGroup();
		return group;
		
	}
}
