package com.spring.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.study.model.CustomerModel;

@Controller
public class DeliveryController {
	
	@RequestMapping(value = "/delivery", method = RequestMethod.GET)  // delivery 페이지를 열어줍니다.
	public ModelAndView delivery(){  // 그냥 페이지를 열어줍니다. 가지고 갈 모델이 딱히없다.
		return new ModelAndView("delivery");
	}
	
	@RequestMapping(value = "/delivery-request", method = RequestMethod.POST)  // submit이 일어남 post요청
	public ModelAndView deliveryRequest(CustomerModel customerModel){  // deliveryInfo 페이지를 열어줍니다.
		// 객체 생성
        ModelAndView mav = new ModelAndView("deliveryInfo");
        // 객체 그대로 전달  customerModel 키값으로 customerModel을 그대로 전달해준다.
		mav.addObject("customerModel", customerModel );
		return mav;
	}}

