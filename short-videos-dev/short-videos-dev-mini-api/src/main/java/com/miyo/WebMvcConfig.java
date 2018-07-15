package com.miyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.miyo.pojo.config.bean.SystemUserConfigBean;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private SystemUserConfigBean systemUserConfigBean;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String userUploadDir = "file:" + systemUserConfigBean.getUploadDir() + "/";
		registry.addResourceHandler("/**")
				.addResourceLocations(userUploadDir)
				.addResourceLocations("classpath:/META-INF/resources/");
	}

}
