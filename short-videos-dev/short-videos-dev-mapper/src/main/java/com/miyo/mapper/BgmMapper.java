package com.miyo.mapper;

import java.util.List;

import com.miyo.pojo.Bgm;
import com.miyo.pojo.vo.BgmVO;
import com.miyo.utils.MyMapper;

public interface BgmMapper extends MyMapper<Bgm> {
	public List<BgmVO> queryBgmByType(BgmVO bgm);
}