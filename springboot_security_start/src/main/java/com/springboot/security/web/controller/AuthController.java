package com.springboot.security.web.controller;

import java.util.Map;
import java.util.WeakHashMap;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.security.web.dto.auth.SignUpDto;

@Controller
public class AuthController {

	@GetMapping("/auth/signin")
	public String signinForm() {
		return "auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String signupForm() {
		return "auth/signup";
	}
	 
	@PostMapping("/auth/signup")
	@ResponseBody
	public Object signup(@Valid SignUpDto signUpDto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) { // 유효성 검사시 에러가 있는지????
			// 유효성 검사시 오류 있음
			Map<String, String> errorMap = new WeakHashMap<String, String>();
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			System.out.println(errorMap);
		} else { 
			// 회원가입 진행
		}
		return signUpDto;
	}
	
}
