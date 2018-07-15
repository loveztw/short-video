package com.miyo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.miyo.pojo.User;
import com.miyo.pojo.config.bean.SystemUserConfigBean;
import com.miyo.pojo.vo.UserVO;
import com.miyo.service.UserService;
import com.miyo.utils.JsonResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="文件上传的接口", tags={"0.1"})
@RequestMapping("/user")
public class UserController extends BasicController {

	@Autowired
	private SystemUserConfigBean systemUserConfigBean; 
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="头像上传", notes="头像上传的接口")
	@PostMapping("/face-upload")
	public JsonResponse faceUpload(String userId, @RequestParam("file") MultipartFile[] files) throws IOException {
		
		if (files == null) {
			return JsonResponse.errorMsg("文件对象不能为空");
		}
		
		if (files.length != 1) {
			return JsonResponse.errorMsg("只允许上传一个文件");
		}
		
		String inputFile = files[0].getOriginalFilename();
		if (StringUtils.isBlank(inputFile)) {
			return JsonResponse.errorMsg("上传的文件名为空");
		}
		
		if (userId == null || StringUtils.isBlank(userId)) {
			return JsonResponse.errorMsg("请传入正确的user-id");
		}
				
		String BaseDir = systemUserConfigBean.getUploadDir();
		String relativeFacePath = "/user/" + userId + "/face";
		String serverPath = relativeFacePath + "/" + inputFile;
		File file = new File(BaseDir + relativeFacePath);
		if (!file.isDirectory()) {
			file.mkdirs();
		}
		
		InputStream is;
		FileOutputStream fos = null;
		try {
			is = files[0].getInputStream();
			fos = new FileOutputStream(BaseDir + serverPath);
			IOUtils.copy(is, fos);
		} catch (IOException e) {
			e.printStackTrace();
			return JsonResponse.errorMsg("系统内部错误");
		}finally{
			if (fos != null){
				fos.close();
			}
		}
		
		User user = new User();
		user.setFaceImage(serverPath);
		return JsonResponse.ok(user);
	}

	@ApiOperation(value="用户信息编辑", notes="用户信息编辑的接口")
	@PostMapping("/edit")	
	public JsonResponse editUserInfo(@RequestBody User user) {
		
		String uid = user.getId();
		String sex = user.getSex();
		//Date birthday = new java.sql.Date(user.getBirthday().getTime());
		Date birthday = user.getBirthday();
		String signature = user.getSignature();
		String nickname = user.getNickname();
		String faceImage = user.getFaceImage();
		
		if (StringUtils.isBlank(uid)) {
			return JsonResponse.errorMsg("UserId不能为空");
		}
		
		User updUser = new User();
		updUser.setId(uid);
		
		if (!StringUtils.isBlank(sex)) {
			updUser.setSex(sex);
		}
		
		if (!StringUtils.isBlank(signature)) {
			updUser.setSignature(signature);
		}
		
		if (birthday != null) {
			updUser.setBirthday(birthday);
		}
		
		if (!StringUtils.isBlank(nickname)) {
			updUser.setNickname(nickname);
		}		

		if (!StringUtils.isBlank(faceImage)) {
			updUser.setFaceImage(faceImage);
		}			
		
		UserVO userVO = userService.editUserInfo(updUser);
		return JsonResponse.ok(userVO);
	}
}
