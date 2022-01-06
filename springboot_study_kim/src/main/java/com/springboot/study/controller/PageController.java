package com.springboot.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("dtl")
	public String helloIndex(Model model) {
		return "hello";
	}
	
	@GetMapping("login")
	public String loginIndex(Model model) {
		return "login";
	}
	
}
