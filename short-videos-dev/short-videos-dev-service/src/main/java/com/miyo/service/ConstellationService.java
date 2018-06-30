package com.miyo.service;

public interface ConstellationService {
	
	/* 根据日期获取对应星座 **/
	public int getConstellationByDate(String date);
	
	public String getConstellationNameById(Integer id);
	
}
