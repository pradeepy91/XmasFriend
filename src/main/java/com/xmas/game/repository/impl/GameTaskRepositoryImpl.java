package com.xmas.game.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xmas.game.repository.GameTaskRepository;

@Component
public class GameTaskRepositoryImpl {

	@Autowired
	GameTaskRepository repository;
	public boolean isTaskAssigned(String userId) {
		return repository.findByCreatedBy(Long.parseLong(userId)) != null;
	}
}
