package com.springboot.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.study.model.dao.LoginDao;
import com.springboot.study.model.vo.Login;

@RestController
public class RestLoginController {
	
	@Autowired
	private LoginDao loginDao;
	
	@GetMapping("login-submit/{loginid}/{loginpassword}")
	public Object login(@PathVariable String loginid, @PathVariable String loginpassword) {
		
		Login login = new Login();
		login.setLoginid(loginid);
		login.setLoginpassword(loginpassword);
		
		login.setLoginFlag(loginDao.login(login));
		 
		System.out.println(login);
		
		return login;
	}

}
