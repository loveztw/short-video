package com.miyo.pojo.config.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix="com.miyo.sys")
@PropertySource("classpath:system.properties")
public class SystemConfigBean {
	private int bgmPageSize;

	public int getBgmPageSize() {
		return bgmPageSize;
	}

	public void setBgmPageSize(int bgmPageSize) {
		this.bgmPageSize = bgmPageSize;
	}


}
