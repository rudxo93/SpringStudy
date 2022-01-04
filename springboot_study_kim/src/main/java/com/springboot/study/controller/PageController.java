package com.springboot.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String helloIndex(Model model) {
		return "hello";
	}
	
}
