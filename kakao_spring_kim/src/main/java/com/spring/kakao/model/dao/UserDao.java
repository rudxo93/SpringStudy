package com.spring.kakao.model.dao;

import com.spring.kakao.model.json.SignUpVo;

public interface UserDao {

	public int emailCheck(String signUpEmail); // email 중복확인
	public int phoneCheck(SignUpVo signUpVo); // phone인증요청
	public int signUp(SignUpVo signUpVo); // 회원가입 마지막단계
	
}
