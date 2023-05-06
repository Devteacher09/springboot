package com.bs.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableAspectJAutoProxy
@SpringBootApplication
public class HellobootApplication{

	public static void main(String[] args) {
		SpringApplication.run(HellobootApplication.class, args);
	}	
}
