package com.xmas.game.service;

import org.springframework.stereotype.Service;

import com.xmas.game.dto.CreateUserRequest;
import com.xmas.game.dto.CreateUserResponse;
import com.xmas.game.dto.HomeScreenInfoResponse;
import com.xmas.game.dto.LoginResponse;
import com.xmas.game.dto.UserAvailablity;
import com.xmas.game.dto.UserDto;
import com.xmas.game.exception.GameException;

@Service
public interface UserActionService {
	public LoginResponse loginUser(UserDto user) throws GameException;
	public CreateUserResponse createUser(CreateUserRequest createUser)throws GameException;
	public UserAvailablity checkUserAvailability(String emailId)throws GameException;
	public HomeScreenInfoResponse getHomeScreenInfo(String userId) throws GameException;
}
