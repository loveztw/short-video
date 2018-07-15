package com.miyo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miyo.pojo.vo.BgmVO;
import com.miyo.service.BgmService;
import com.miyo.utils.JsonResponse;

@RestController
@RequestMapping("/bgm")
public class bgmController {
	
	@Autowired
	private BgmService bgmService;
	
	@GetMapping("/list/{type}")
	public JsonResponse getBgmList(@PathVariable Integer type) {
		List<BgmVO> bgmVOList = bgmService.getBgmByType(type);
		for (BgmVO bgmVO : bgmVOList) {
			String dbUrl = bgmVO.getUrl();
			String servUrl = "/bgm" + dbUrl;
			bgmVO.setUrl(servUrl);
		}
		
		return JsonResponse.ok(bgmVOList);
	}
	
}
