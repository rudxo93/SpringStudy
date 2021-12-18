package com.spring.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.study.model.CustomerModel;

@Controller
public class PostManController {

	@RequestMapping(value = "/postManTest", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String postResponse(@RequestParam String id,
												@RequestParam String pwd,
												@RequestParam String name,
												@RequestParam String phone ) {
		return "사용자 id : " + id + " 비밀번호 : " + pwd + " 이름 : " + name + " 전화번호 : " + phone;
	}
	
	@RequestMapping(value="/postManDelivery", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String postDelivery(CustomerModel customerModel) {
		return "고객명: " + customerModel.getCustomer_name() + " 배송지(주소): " + customerModel.getCustomer_addr() 
					+ " 연락처: " + customerModel.getCustomer_phone() + " 기타사항: " + customerModel.getCustomer_etc();
	}
	
}
