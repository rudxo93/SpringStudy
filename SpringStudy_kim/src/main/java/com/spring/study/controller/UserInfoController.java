package com.spring.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.study.model.UserInfoModel;

@Controller
public class UserInfoController {
	
	@RequestMapping(value = "/user-info-insert", method = RequestMethod.GET)
	public ModelAndView userInfoInsert() {
		ModelAndView mav = new ModelAndView("userInfoInsert");
		return mav;
	}
	
	@RequestMapping(value = "/insert-data", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String insertData(UserInfoModel userInfoModel) { 
		
		System.out.println(userInfoModel.getUser_id());
		System.out.println(userInfoModel.getUser_password());
		System.out.println(userInfoModel.getUser_name());
		System.out.println(userInfoModel.getUser_phone());
		
		return userInfoModel.getUser_id() + ", " + userInfoModel.getUser_password() + ", " 
					+ userInfoModel.getUser_name() + ", " + userInfoModel.getUser_phone();
	}
	
}
/*
 * 1. @Controller component로 만들어준다.
 * 2. 메서드 정의
 * @RequestMapping 정의
 */
