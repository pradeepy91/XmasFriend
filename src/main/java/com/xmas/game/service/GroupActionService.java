package com.xmas.game.service;

import com.xmas.game.dto.CreateGroupRequest;
import com.xmas.game.dto.CreateGroupResponse;
import com.xmas.game.exception.GameException;

public interface GroupActionService {
	public CreateGroupResponse createGroup(CreateGroupRequest request)throws GameException;
}
