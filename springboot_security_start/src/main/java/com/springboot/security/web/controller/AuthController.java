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
import com.springboot.security.web.dto.auth.SignUpRespDto;
import com.springboot.security.web.service.AuthService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AuthController {
	
	private final AuthService authService;

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
			SignUpRespDto<Map<String, String>> signUpRespDto = new SignUpRespDto<Map<String,String>>();
			signUpRespDto.setCode(400); // 400에러
			signUpRespDto.setMsg(errorMap);
			return signUpRespDto;
		} else { 
			// 회원가입 진행
			SignUpRespDto<String> signUpRespDto = new SignUpRespDto<String>();
			int signupResult = authService.signup(signUpDto);
			if(signupResult == 1) {
				// 회원가입 성공
				signUpRespDto.setCode(200); // 200번 코드는 성공에 대한 코드
				signUpRespDto.setMsg("회원가입 성공.");
			} else if(signupResult == 2) {
				// 아이디 중복
				signUpRespDto.setCode(410); // 클라이언트에서 잘못 400번대 코드 사용
				signUpRespDto.setMsg("이미 가입된 username입니다.");
			} else {
				// DB오류
				signUpRespDto.setCode(500); // 서버에서 문제 500번대 코드 사용
				signUpRespDto.setMsg("회원가입 실패. 관리자에게 문의하세요.");
			}
			return signUpRespDto;
		}
	}
	
}
