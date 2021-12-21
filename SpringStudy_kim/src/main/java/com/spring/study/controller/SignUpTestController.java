package com.spring.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.study.model.dao.UserDao;
import com.spring.study.model.dto.UserDto;

@Controller
public class SignUpTestController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/signUpIndex", method = RequestMethod.GET)
	public ModelAndView signUpIndex() {
		return new ModelAndView("signUp");
	}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	@ResponseBody
	public String idCheck(@RequestParam String user_email) {
		String flag = null;
		flag = Integer.toString(userDao.idCheck(user_email));
		return flag;
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	@ResponseBody
	public String signUp(@RequestBody UserDto userDto) {
		String flag = Integer.toString(userDao.signUp(userDto));
		return flag;
	}
}
