package com.miyo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miyo.pojo.vo.BgmVO;
import com.miyo.service.BgmService;
import com.miyo.utils.JsonResponse;
import com.miyo.utils.PagedResult;

@RestController
@RequestMapping("/bgm")
public class bgmController {
	
	@Autowired
	private BgmService bgmService;
	
	@GetMapping("/list/{type}")
	public JsonResponse getBgmList(@PathVariable Integer type) {
		List<BgmVO> bgmVOList = bgmService.getBgmByType(type);
		return JsonResponse.ok(bgmVOList);
	}

	@PostMapping("/listPage")
	public JsonResponse getBgmListPage(@RequestBody Integer page) {
		
		PagedResult pagedResult = bgmService.getBgmByPage(page);
		return JsonResponse.ok(pagedResult);
	}
}
