package com.spring.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.study.model.dao.UserDao;
import com.spring.study.model.dto.UserDto;

@Controller
public class LoginTestController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/login-index", method = RequestMethod.GET)
	public ModelAndView loginIndex() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value ="/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(UserDto userDto) {
		String flag = null;
		flag = Integer.toString(userDao.login(userDto));
		return flag;
	}

}
