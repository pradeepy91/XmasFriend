package com.xmas.game.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.xmas.game.entity.User;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByEmail(String emailid);
	public boolean existsByEmail(String emailid);
}
