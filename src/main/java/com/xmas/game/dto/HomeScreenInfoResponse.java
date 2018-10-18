package com.xmas.game.dto;

import java.util.Map;

public class HomeScreenInfoResponse {

	boolean isTaskAssigned;
	boolean isGroupCreateByUser;
	Map<Long,Boolean> groupAndGameStatus;
	public boolean isTaskAssigned() {
		return isTaskAssigned;
	}
	public void setTaskAssigned(boolean isTaskAssigned) {
		this.isTaskAssigned = isTaskAssigned;
	}
	public boolean isGroupCreateByUser() {
		return isGroupCreateByUser;
	}
	public void setGroupCreateByUser(boolean isGroupCreateByUser) {
		this.isGroupCreateByUser = isGroupCreateByUser;
	}
	public Map<Long, Boolean> getGroupAndGameStatus() {
		return groupAndGameStatus;
	}
	public void setGroupAndGameStatus(Map<Long, Boolean> groupAndGameStatus) {
		this.groupAndGameStatus = groupAndGameStatus;
	}	
}
