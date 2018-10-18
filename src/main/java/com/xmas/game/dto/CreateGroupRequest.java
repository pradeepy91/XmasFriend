package com.xmas.game.dto;

public class CreateGroupRequest {
	public String groupName;
	public GroupMembers groupMembers;
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public GroupMembers getGroupMembers() {
		return groupMembers;
	}
	public void setGroupMembers(GroupMembers groupMembers) {
		this.groupMembers = groupMembers;
	}
	
}
