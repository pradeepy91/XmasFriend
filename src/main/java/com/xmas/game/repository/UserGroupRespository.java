package com.xmas.game.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmas.game.entity.UserGroup;

@Repository
public interface UserGroupRespository extends JpaRepository<UserGroup,Long> {
	List<UserGroup> findByGroupCreatedBy(Long createBy);
}
