package com.xmas.game.repository.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xmas.game.entity.User;
import com.xmas.game.repository.UserRepository;


@Component
public class UserRepositoryImpl {
	private static final org.slf4j.Logger DAO_LOGGER = LoggerFactory.getLogger(UserRepositoryImpl.class);
	@Autowired
	UserRepository repository;
	
	public User getUserDetailsByEmail(String email) {
		User user = repository.findByEmail(email);
		DAO_LOGGER.info("User info from DB:{}",user);
		return user;
	}
	public boolean checkUserExists(String email) {
		return repository.existsByEmail(email);
	}
}
