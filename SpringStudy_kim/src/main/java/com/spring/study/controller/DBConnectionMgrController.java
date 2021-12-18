package com.spring.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.study.model.dao.UserDao;

@Controller
public class DBConnectionMgrController {
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/getUserData", method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String userData(@RequestParam String email) {
		return userDao.getUser(email).toString();
	}
}