package com.xmas.game.repository;


import org.springframework.data.repository.Repository;

import com.xmas.game.entity.User;

@org.springframework.stereotype.Repository
public interface UserRepository extends Repository<User, Long> {
	public User findByEmail(String emailid);
	public boolean existsByEmail(String emailid);
}
