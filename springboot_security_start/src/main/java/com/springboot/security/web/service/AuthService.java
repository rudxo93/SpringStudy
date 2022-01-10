package com.springboot.security.web.service;

import com.springboot.security.web.dto.auth.SignUpDto;

public interface AuthService {

	public int signup(SignUpDto signUpDto); // 회원가입
	
}
