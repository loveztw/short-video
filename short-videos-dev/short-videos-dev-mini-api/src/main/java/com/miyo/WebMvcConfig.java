package com.miyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.miyo.pojo.config.bean.SystemConfigBean;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private SystemConfigBean systemConfigBean;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String userUploadDir = "file:" + systemConfigBean.getUploadDir() + "/";
		registry.addResourceHandler("/**")
				.addResourceLocations(userUploadDir)
				.addResourceLocations("classpath:/META-INF/resources/");
	}

}
