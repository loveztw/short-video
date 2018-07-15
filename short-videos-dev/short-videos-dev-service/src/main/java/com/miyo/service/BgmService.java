package com.miyo.service;

import java.util.List;

import com.miyo.pojo.vo.BgmVO;
import com.miyo.utils.PagedResult;

public interface BgmService {
	
	/** 根据音乐类型获取音乐列表 */
	public List<BgmVO> getBgmByType(int type);
	
	/** 根据引用计数获得热门歌曲列表 */
	public PagedResult getBgmByPage(int page);
}
