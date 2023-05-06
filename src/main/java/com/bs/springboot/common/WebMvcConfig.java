package com.bs.springboot.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	//기본 화면전환에 대한 설정을 하는 메소드를 구현
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/loginpage").setViewName("loginPage");
	}

	
	//vue, react, angular js프레임워크를 view로 선정했을때
	//ajax를 이용해서 요청을 보냄 -> javascript보안상 같은 origin이 아니면 통신을 차단
	//cors
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:3000");
	}
	
	
	
	
	
	
}
