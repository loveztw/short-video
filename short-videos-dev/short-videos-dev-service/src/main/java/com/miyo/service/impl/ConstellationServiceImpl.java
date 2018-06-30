package com.miyo.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miyo.constval.DBColumnNames;
import com.miyo.mapper.ConstellationMapper;
import com.miyo.pojo.Constellation;
import com.miyo.service.ConstellationService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class ConstellationServiceImpl implements ConstellationService {

	@Autowired
	private ConstellationMapper	constellationMapper;
	
	@Override
	/* 根据日期获取对应星座
	 * @param: date -> MMDD
	**/
	@Transactional(propagation = Propagation.SUPPORTS)
	public int getConstellationByDate(String date) {
		if (StringUtils.isBlank(date)) {
			return -1;
		}
		
		Example constellationExample = new Example(Constellation.class);
		Criteria criteria = constellationExample.createCriteria();
		criteria.andGreaterThanOrEqualTo(DBColumnNames.CONSTEL_END_DATE, date);
		criteria.andLessThanOrEqualTo(DBColumnNames.CONSTEL_START_DATE, date);
		Constellation constellation = constellationMapper.selectOneByExample(constellationExample);
		if (constellation == null){
			return -1;
		}
		
		return constellation.getId();
	}

	
	@Transactional(propagation = Propagation.SUPPORTS)
	public String getConstellationNameById(Integer id) {
		Example constellationExample = new Example(Constellation.class);
		Criteria criteria = constellationExample.createCriteria();
		criteria.andEqualTo(DBColumnNames.CONSTEL_ID, id);
		Constellation constellation = constellationMapper.selectOneByExample(constellationExample);
		if (constellation == null){
			return null;
		}
		
		return constellation.getName();
	}
}
