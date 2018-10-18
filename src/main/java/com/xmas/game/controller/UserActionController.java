package com.xmas.game.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmas.game.constant.GameConstants;
import com.xmas.game.dto.CreateUserRequest;
import com.xmas.game.dto.CreateUserResponse;
import com.xmas.game.dto.HomeScreenInfoResponse;
import com.xmas.game.dto.LoginResponse;
import com.xmas.game.dto.ResponseError;
import com.xmas.game.dto.UserAvailablity;
import com.xmas.game.dto.UserDto;
import com.xmas.game.service.UserActionService;

@RestController
@RequestMapping(GameConstants.BASE_URI)
public class UserActionController {
	Logger CONTROLLER_LOG = LoggerFactory.getLogger(getClass());
	@Autowired
	UserActionService userService;
	@PostMapping(name="validateUser",path=GameConstants.PATH_VALIDATE_USER,consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> loginUser(@Valid @RequestBody UserDto userInfo,Errors Error){
		try {
			LoginResponse response =  userService.loginUser(userInfo);
			ResponseEntity<Object> responseEntity = new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}catch(Exception e) {
			CONTROLLER_LOG.error("Error Occcured in Validate User:{}",e);
			ResponseError error = new ResponseError();
			error.setErrorCode("Error-"+HttpStatus.INTERNAL_SERVER_ERROR.name());
			error.setUserErrorMessage(e.getMessage());
			error.setSystemErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(name="checkUserExists")
	public ResponseEntity<Object> checkUserExists(@RequestParam String emailId){
		try {
			UserAvailablity response = userService.checkUserAvailability(emailId);
			ResponseEntity<Object> responseEntity = new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}catch(Exception e) {
			CONTROLLER_LOG.error("Error Occcured in Validate User:{}",e);
			ResponseError error = new ResponseError();
			error.setErrorCode("Error-"+HttpStatus.INTERNAL_SERVER_ERROR.name());
			error.setUserErrorMessage(e.getMessage());
			error.setSystemErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PostMapping(name="createUser",path=GameConstants.PATH_CREATE_USER , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createUser(@RequestBody CreateUserRequest createRequest,Errors errors) {
		try {
			CreateUserResponse response = userService.createUser(createRequest);
			ResponseEntity<Object> responseEntity = new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}catch(Exception e) {
			CONTROLLER_LOG.error("Error Occcured in Validate User:{}",e);
			ResponseError error = new ResponseError();
			error.setErrorCode("Error-"+HttpStatus.INTERNAL_SERVER_ERROR.name());
			error.setUserErrorMessage(e.getMessage());
			error.setSystemErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(name="homeScreen",path= GameConstants.PATH_HOME_SCREEN)
	public ResponseEntity<Object> homeScreen(@RequestParam String userId){
		try {
			HomeScreenInfoResponse response = userService.getHomeScreenInfo(userId);
			ResponseEntity<Object> responseEntity = new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}catch(Exception e) {
			CONTROLLER_LOG.error("Error in Getting Home Screen Info:{}",e);
		}
		return null;
	}
}
