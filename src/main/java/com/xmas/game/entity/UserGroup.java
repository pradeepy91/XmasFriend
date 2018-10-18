package com.xmas.game.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_GROUP")
public class UserGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long groupId;
	
	private String groupName;
	private Boolean isGameStarted;
	private Long groupCreatedBy;
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public boolean isGameStarted() {
		return isGameStarted;
	}
	public void setGameStarted(boolean isGameStarted) {
		this.isGameStarted = isGameStarted;
	}
	public Long getGroupCreatedBy() {
		return groupCreatedBy;
	}
	public void setGroupCreatedBy(Long groupCreatedBy) {
		this.groupCreatedBy = groupCreatedBy;
	}
}
