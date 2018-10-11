package com.xmas.game.service;

import org.springframework.stereotype.Service;

import com.xmas.game.dto.LoginResponse;
import com.xmas.game.dto.UserAvailablity;
import com.xmas.game.dto.UserDto;

@Service
public interface UserActionService {
	public LoginResponse validateUser(UserDto user);
	public void createUser(UserDto user);
	public UserAvailablity checkUserAvailability(String emailId);
}
