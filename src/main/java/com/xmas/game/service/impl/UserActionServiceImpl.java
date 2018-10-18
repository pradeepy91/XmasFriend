package com.xmas.game.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmas.game.dto.CreateUserRequest;
import com.xmas.game.dto.CreateUserResponse;
import com.xmas.game.dto.HomeScreenInfoResponse;
import com.xmas.game.dto.LoginResponse;
import com.xmas.game.dto.UserAvailablity;
import com.xmas.game.dto.UserDto;
import com.xmas.game.entity.User;
import com.xmas.game.entity.UserGroup;
import com.xmas.game.exception.GameException;
import com.xmas.game.repository.impl.GameTaskRepositoryImpl;
import com.xmas.game.repository.impl.UserRepositoryImpl;
import com.xmas.game.service.UserActionService;


@Service
public class UserActionServiceImpl implements UserActionService{
	Logger SERVICE_IMPL = LoggerFactory.getLogger(getClass());
	@Autowired
	UserRepositoryImpl userDAO;
	@Autowired
	GameTaskRepositoryImpl taskDAO;
	@Override
	public LoginResponse loginUser(UserDto user) throws GameException {
		LoginResponse response = new LoginResponse();
		try {
			User userInfo = userDAO.getUserDetailsByEmail(user.getEmailId());
			if( !StringUtils.equals(userInfo.getPassword(), user.getPassword())) {
				throw new GameException("Invalid Login username or password wrong.");
			}
			response.setSuccess(true);
			response.setUserid(userInfo.getId());
			return response;
		}catch(Exception e) {
			SERVICE_IMPL.info("Error during the validation of user:{}",e.getMessage());
			throw new GameException(e);
		}
	}

	@Override
	public CreateUserResponse createUser(CreateUserRequest createRequest) throws GameException {
		User userData = new User();
		try {
			UserAvailablity userAvailablity = checkUserAvailability(createRequest.getEmailId());
			if(userAvailablity.isAvailable()) {
				// Throw Error to handle the user exists.
				throw new GameException("User Already exists");
			}
			userData.setEmail(createRequest.getEmailId());
			userData.setName(createRequest.getName());
			userData.setPassword(createRequest.getPassword());
			userData = userDAO.createUser(userData);
			CreateUserResponse response = new CreateUserResponse();
			response.setSuccess(true);
			response.setUserId(userData.getId().toString());
			return response;
		}catch(Exception e) {
			SERVICE_IMPL.error("Error Occured in Create User:{}",e);
			throw new GameException(e);
		}
	}

	@Override
	public UserAvailablity checkUserAvailability(String emailId) throws GameException {
		try {
			UserAvailablity userAvailablity = new UserAvailablity();
			userAvailablity.setEmailId(emailId);
			userAvailablity.setAvailable(userDAO.checkUserExists(emailId));
			return userAvailablity;
		}catch(Exception e) {
			SERVICE_IMPL.error("Error occured during check user availablity:{}",e);
			throw new GameException(e);
		}		
	}

	@Override
	public HomeScreenInfoResponse getHomeScreenInfo(String userId) throws GameException {
		try {
			HomeScreenInfoResponse homeScreenInfo = new HomeScreenInfoResponse();
			List<UserGroup> userInGroup = userDAO.getUserInGroups(userId);
			homeScreenInfo.setGroupAndGameStatus(userInGroup.stream()
							.collect(Collectors
							.toMap(UserGroup::getGroupId, UserGroup::isGameStarted)));
			homeScreenInfo.setGroupCreateByUser( !userInGroup.isEmpty());
			homeScreenInfo.setTaskAssigned(taskDAO.isTaskAssigned(userId));
			return homeScreenInfo;
		}catch(Exception e) {
			SERVICE_IMPL.error("Error Occured in Getting Home Screen Info:{}",e);
		}
		return null;
	}

}
