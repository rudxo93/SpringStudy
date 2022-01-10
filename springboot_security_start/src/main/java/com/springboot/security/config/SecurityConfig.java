package com.springboot.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration // IOC등록(설정에 관련)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(); // csrf 비활성화
		http.authorizeRequests() // 인증 관련된 요청이 들어오면
			.antMatchers("/", "/index", "/user/**") // 어떤() url요청이 들어오면 전부다 로그인 페이지로 보낼것
			.authenticated() // 위와 같은 요청이 들어오면 전부 다 인증요청이 필요하다.
			.anyRequest() // antMatchers이외에 모든 요청
			.permitAll() // 요청이 없어도 된다(모든 권한을 부여한다.)
			.and()
			.formLogin() // 로그인 페이지 커스텀
			.loginPage("/auth/signin") // get
			.loginProcessingUrl("/auth/signin") // post controller를 따로 만들필요 없다.(security가 자동으로 처리)
			.defaultSuccessUrl("/"); // 로그인 성공시 기본적으로 이동할 경로
	} 
}
