package com.spring.kakao.service;

import com.spring.kakao.model.json.SignUpVo;

public interface UserService {
	
	public int signUpEmailCheck(String signUpEmail);
	public int signUpPhoneCheck(SignUpVo signUpVo);
	public int signUp(SignUpVo signUpVo);

}
