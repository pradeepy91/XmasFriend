package com.xmas.game.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmas.game.constant.GameConstants;

@RestController
@RequestMapping(GameConstants.GROUP_BASE_URI)
public class GroupActionController {
	Logger CONTROLLER_LOG = LoggerFactory.getLogger(getClass());
	
}
