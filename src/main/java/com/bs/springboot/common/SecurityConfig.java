package com.bs.springboot.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	//security에서 사용할 bean을 등록한다.
	//1. 인증처리할 bean등록하기
	//2. 시큐리티 설정하는 bean 등록하기
	private MyProvider provider;
	
	public SecurityConfig(MyProvider provider) {
		this.provider=provider;
	}
	
	@Bean
	public SecurityFilterChain authenticationPath(HttpSecurity http) throws Exception{
		return http.csrf().disable()
			.formLogin()
//				.successForwardUrl("/")
//				.failureForwardUrl("/")
				//.loginPage("/loginpage")
				//.passwordParameter("pw")
				//.usernameParameter("id")
				//.loginProcessingUrl("/loginEnd.do")
			.and()
			.authorizeHttpRequests()
				.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/logout.do").permitAll()
				.antMatchers("/loginpage").permitAll()
				.antMatchers("/**")
				.hasAnyAuthority(MyAuthority.ADMIN.name(),MyAuthority.USER.name())
			.and()
			.logout()
				.logoutUrl("/logout.do")
			.and()
			.authenticationProvider(provider)
			.build();
	}
	
	
	
}
