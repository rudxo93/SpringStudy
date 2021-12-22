package com.spring.kakao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kakao.model.dao.UserDao;
import com.spring.kakao.model.json.SignUpVo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public int signUpEmailCheck(String signUpEmail) {
		return userDao.emailCheck(signUpEmail);
	}
	
	@Override
	public int signUpPhoneCheck(SignUpVo signUpVo) {
		return userDao.phoneCheck(signUpVo);
	}
	
	@Override
	public int signUp(SignUpVo signUpVo) {
		return userDao.signUp(signUpVo);
	}

}
