package com.xmas.game.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xmas.game.dto.CreateGroupRequest;
import com.xmas.game.dto.CreateGroupResponse;
import com.xmas.game.exception.GameException;
import com.xmas.game.repository.impl.UserGroupRespositoryImpl;
import com.xmas.game.service.GroupActionService;

public class GroupActionServiceImpl implements GroupActionService {

	@Autowired
	UserGroupRespositoryImpl groupDAO;
	@Override
	public CreateGroupResponse createGroup(CreateGroupRequest request) throws GameException {
		try {
			String groupName = request.getGroupName();
			String[] emailIds = request.getGroupMembers().getEmailId();
			
		}
		catch(Exception e){
			
		}
		return null;
	}

}
