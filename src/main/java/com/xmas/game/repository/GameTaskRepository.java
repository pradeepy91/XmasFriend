package com.xmas.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmas.game.entity.GameTask;

@Repository
public interface GameTaskRepository extends JpaRepository<GameTask, Long> {
	public GameTask findByCreatedBy(Long createdBy);
}
