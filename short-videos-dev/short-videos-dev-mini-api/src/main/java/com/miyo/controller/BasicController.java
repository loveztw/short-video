package com.miyo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.miyo.utils.RedisOperator;

public class BasicController {
	
	@Autowired
	protected RedisOperator redisOperator;
	
	protected final String USER_SESSION_KEY = "user_session_key";
}
