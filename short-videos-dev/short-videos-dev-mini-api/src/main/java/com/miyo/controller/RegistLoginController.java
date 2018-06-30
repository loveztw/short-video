package com.miyo.controller;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miyo.pojo.User;
import com.miyo.pojo.vo.UserVO;
import com.miyo.service.ConstellationService;
import com.miyo.service.UserService;
import com.miyo.utils.JsonResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="用户注册登录的接口", tags={"0.1"})
public class RegistLoginController extends BasicController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ConstellationService constellationService;
	
	@ApiOperation(value="用户登录", notes="用户登录的接口")
	@PostMapping("/login")
	public JsonResponse login(@RequestBody User user) {
		
		String userName = user.getUsername();
		String password = user.getPassword();
		
		if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
			return JsonResponse.errorMsg("用户名和密码不能为空");
		}
		
		UserVO userInfo = userService.queryUserInfo(userName);
		if (userInfo == null) {
			return JsonResponse.errorMsg("用户名不存在");
		}
		
		if (!password.equals(userInfo.getPassword())) {
			return JsonResponse.errorMsg("密码不正确");
		}
		
		//UUID Gen
		String userToken = UUID.randomUUID().toString();
		redisOperator.set(USER_SESSION_KEY + ':' + userInfo.getId(), userToken, 1000*60*10);
		
		//获取星座名
		//Integer constellId = userInfo.getConstellationId();
		//String constellName = constellationService.getConstellationNameById(constellId);
		
		//UserVO userVO = new UserVO();
		//BeanUtils.copyProperties(userInfo, userVO);
		userInfo.setUserToken(userToken);
		//userVO.setConstellationName(constellName);
		return JsonResponse.ok(userInfo);
	}
	
	@ApiOperation(value="用户注册", notes="用户注册的接口")
	@PostMapping("/regist")	
	public JsonResponse regist(@RequestBody User user) {
		
		String userName = user.getUsername();
		String password = user.getPassword();
		
		if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
			return JsonResponse.errorMsg("用户名和密码不能为空");
		}
		
		boolean userExitFlg = userService.isUserExist(userName);
		if (userExitFlg == true) {
			return JsonResponse.errorMsg("用户名已存在");
		}
		
	    user.setFansCount(0);
	    user.setFollowCount(0);
	    user.setNickname(userName);
	    user.setReceiveLikeCount(0);
	    userService.saveUser(user);
		
		return JsonResponse.ok();
	}
	
}
