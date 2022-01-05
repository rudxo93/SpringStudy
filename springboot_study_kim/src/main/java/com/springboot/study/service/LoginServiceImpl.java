package com.springboot.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.study.model.dao.LoginDao;
import com.springboot.study.model.vo.Login;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public int login(Login login) {
		return loginDao.login(login);
	}
	
}
