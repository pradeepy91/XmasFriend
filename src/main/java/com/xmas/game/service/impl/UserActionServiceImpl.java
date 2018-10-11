package com.xmas.game.service.impl;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmas.game.dto.LoginResponse;
import com.xmas.game.dto.UserAvailablity;
import com.xmas.game.dto.UserDto;
import com.xmas.game.entity.User;
import com.xmas.game.repository.impl.UserRepositoryImpl;
import com.xmas.game.service.UserActionService;

@Service
public class UserActionServiceImpl implements UserActionService{

	@Autowired
	UserRepositoryImpl userDAO;
	@Override
	public LoginResponse validateUser(UserDto user) {
		LoginResponse response = new LoginResponse();
		User userInfo = userDAO.getUserDetailsByEmail(user.getEmailId());
		if( StringUtils.equals(userInfo.getPassword(), user.getPassword())) {
			response.setSuccess(true);
			response.setUserid(userInfo.getId());
		}
		return response;
	}

	@Override
	public void createUser(UserDto user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserAvailablity checkUserAvailability(String emailId) {
		UserAvailablity userAvailablity = new UserAvailablity();
		userAvailablity.setEmailId(emailId);
		userAvailablity.setAvailable(userDAO.checkUserExists(emailId));
		return userAvailablity;
	}

}
