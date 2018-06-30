package com.miyo.service;

import com.miyo.pojo.User;
import com.miyo.pojo.vo.UserVO;

public interface UserService {
	
	public UserVO queryUserInfo(String username);
	
	public User queryUserInfoById(String id);
	
	public boolean isUserExist(String username);
	
	public void saveUser(User user);
	
	public UserVO editUserInfo(User user);
}
