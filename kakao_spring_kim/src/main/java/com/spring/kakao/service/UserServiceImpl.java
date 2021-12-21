package com.spring.kakao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kakao.model.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public int signUpEmailCheck(String signUpEmail) {
		return userDao.emailCheck(signUpEmail);
	}

}
