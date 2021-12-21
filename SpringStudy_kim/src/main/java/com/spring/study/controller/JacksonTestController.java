package com.spring.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.study.model.dto.UserDto;

@Controller
public class JacksonTestController {

	@RequestMapping(value = "jacksonRequest", method = RequestMethod.POST)
	@ResponseBody
	/*
	 * @RequestBody가 있다면 jackson이 알아서 객체로 변환시킨다 => ex) userDto객체로 변환
	 * userDto안의 변수명과 JSON의 키값과 일치해야한다.
	 * **jackson을 쓸때 주의사항 @RequestBody가 있어야한다!
	 * 
	 * 서버가 클라이언트한테 JSON데이터 반환
	 * 반환형이 String이 아니라 Object, 객체를 그대로 리턴
	 * @ResponseBody가 있으면 리턴때 Object(객체)를 JSON으로 변환시켜준다.
	 * 
	 * ** 데이터를 전송할때 기본적으로 @ResponseBody가 있어야한다.
	 * 이때 리턴값이 String 이면 일반적인 text값을 리턴, Object 이면 객체를 JSON으로 바꾼 후 리턴.
	 * JSON형태의 데이터를 받을떄는 @RequestBody(요청시 데이터)를 해당 객체로 바꾼다.
	 * 그러기 위해서는 JSON의 키값들이 객체에 들어있는 변수명이 같아야한다.
	 */ 
	public Object jacksonData(@RequestBody UserDto userDto) {
		System.out.println(userDto);
		return userDto;
	}
	 
}
