package com.spring.kakao.model.dao;

import com.spring.kakao.model.dto.UserDto;
import com.spring.kakao.model.json.SignInVo;
import com.spring.kakao.model.json.SignUpVo;

public interface UserDao {

	public int emailCheck(String signUpEmail); // email 중복확인
	public int phoneCheck(SignUpVo signUpVo); // phone인증요청
	public int signUp(SignUpVo signUpVo); // 회원가입 마지막단계
	public int signIn(SignInVo signInVo); // 로그인
	public UserDto getUser(String user_email); // 세션에 넣어줄 유저 정보 DB로부터 들고오기
}
