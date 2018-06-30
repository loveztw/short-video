package com.miyo.mapper;

import com.miyo.pojo.User;
import com.miyo.pojo.vo.UserVO;
import com.miyo.utils.MyMapper;

public interface UserMapper extends MyMapper<User> {
	public UserVO queryAllUserInfo(User user);
}