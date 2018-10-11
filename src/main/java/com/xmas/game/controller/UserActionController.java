package com.xmas.game.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmas.game.constant.GameConstants;
import com.xmas.game.dto.LoginResponse;
import com.xmas.game.dto.UserAvailablity;
import com.xmas.game.dto.UserDto;
import com.xmas.game.service.UserActionService;

@RestController
@RequestMapping(GameConstants.BASE_URI)
public class UserActionController {

	@Autowired
	UserActionService userService;
	@PostMapping(name="validateUser",path=GameConstants.PATH_VALIDATE_USER,consumes = "application/json" , produces = "application/json")
	public ResponseEntity<LoginResponse> validateUser(@Valid @RequestBody UserDto userInfo,Errors Error){
		LoginResponse response = userService.validateUser(userInfo);
		ResponseEntity<LoginResponse> responseEntity = new ResponseEntity<>(response,HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping(name="checkUserExists")
	public ResponseEntity<UserAvailablity> checkUserExists(@RequestParam String emailId){
		UserAvailablity response = userService.checkUserAvailability(emailId);
		ResponseEntity<UserAvailablity> responseEntity = new ResponseEntity<>(response,HttpStatus.OK);
		return responseEntity;
	}
}
