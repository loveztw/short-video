package com.miyo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miyo.mapper.UserMapper;
import com.miyo.pojo.User;
import com.miyo.pojo.vo.UserVO;
import com.miyo.service.ConstellationService;
import com.miyo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ConstellationService constellationService;
	
	@Autowired
	private Sid sid;
	
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public UserVO queryUserInfo(String username) {
		User user = new User();
		user.setUsername(username);
		
		return userMapper.queryAllUserInfo(user);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public User queryUserInfoById(String id) {
		User user = new User();
		user.setId(id);
		
		return userMapper.selectOne(user);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean isUserExist(String username) {

		User user = new User();
		user.setUsername(username);
		
		User userResult = userMapper.selectOne(user);
		if (userResult == null) {
			return false;
		}
		
		return true;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void saveUser(User user) {
		
		String userId = sid.nextShort();
		user.setId(userId);
		
		userMapper.insert(user);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override	
	public UserVO editUserInfo(User user) {
		Date birthday = user.getBirthday();
		if (birthday != null) {
			//根据生日日期计算星座
			SimpleDateFormat formatter = new SimpleDateFormat("MMdd");
			String mmdd = formatter.format(birthday);
			int constelId = constellationService.getConstellationByDate(mmdd);
			user.setConstellationId(constelId);
			//计算年龄
			formatter = new SimpleDateFormat("YYYY");
			String birthYear = formatter.format(birthday);
			
			Date curDate = new Date();
			String curYear = formatter.format(curDate);
			
			user.setAge(Integer.parseInt(curYear) - Integer.parseInt(birthYear));
		}
		
		userMapper.updateByPrimaryKeySelective(user);
		return userMapper.queryAllUserInfo(user);
	}
	
}
