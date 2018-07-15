package com.miyo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miyo.mapper.BgmMapper;
import com.miyo.pojo.Bgm;
import com.miyo.pojo.config.bean.SystemConfigBean;
import com.miyo.pojo.vo.BgmVO;
import com.miyo.service.BgmService;
import com.miyo.utils.PagedResult;

import tk.mybatis.mapper.entity.Example;

@Service
public class BgmServiceImpl implements BgmService {

	@Autowired
	private BgmMapper bmgMapper;

	@Autowired
	private SystemConfigBean systemConfigBean; 
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<BgmVO> getBgmByType(int type) {
		BgmVO bgm = new BgmVO();
		bgm.setType(type);
		return bmgMapper.queryBgmByType(bgm);
	}
	
	@Override
	public PagedResult getBgmByPage(int page) {
		
		PageHelper.startPage(page, systemConfigBean.getBgmPageSize());
		Example bgmExample = new Example(Bgm.class);
		bgmExample.setOrderByClause("ref_cnt DESC");
		List<Bgm> bgmList = bmgMapper.selectByExample(bgmExample);
		
		PageInfo<Bgm> pageList = new PageInfo<>(bgmList);
		
		PagedResult pagedResult = new PagedResult();
		pagedResult.setPage(page);
		pagedResult.setTotal(pageList.getPages());
		pagedResult.setRows(bgmList);
		pagedResult.setRecords(pageList.getTotal());
		return pagedResult;
	}
}
