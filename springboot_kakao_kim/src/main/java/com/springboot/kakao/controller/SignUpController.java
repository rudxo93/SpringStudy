package com.springboot.kakao.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.kakao.model.dto.UserDto;
import com.springboot.kakao.model.vo.SignUpVo;
import com.springboot.kakao.service.UserService;

@Controller
public class SignUpController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String SignUpIndex(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		if(cookies != null) { // 무시
			for (Cookie c : cookies) {
				if(c.getName().equals("user_email")) {
					UserDto userDto = userService.getUser(c.getValue()); // email값
					session.setAttribute("login_user", userDto);
				}
			}
		} 
		if(session.getAttribute("login_user") != null) {
			return "redirect:index";
		}
		return"signUp/sign_up";
	}
	
	@RequestMapping(value = "/sign-up-emailCheck", method = RequestMethod.POST)
	@ResponseBody
	public Object signUpEmailCheck(@RequestParam String signUpEmail) {  // JSON데이터를 전달해야 되기 때문에 object 사용
		SignUpVo signUpVo = new SignUpVo();
		signUpVo.setSignUpEmail(signUpEmail);
		signUpVo.setEmailFlag(userService.signUpEmailCheck(signUpEmail));
		System.out.println(signUpVo);
		return signUpVo;
	}
	
	@RequestMapping(value = "/phone-number-check", method = RequestMethod.POST)
	@ResponseBody
	public Object signUpPhoneCheck(@RequestBody SignUpVo signUpVo) { // JSON을 전달받기 때문에 RequestBody
		signUpVo.setPhoneFlag(userService.signUpPhoneCheck(signUpVo)); // 결과가 담긴 JSON 완성(0, 1, 2의 결과)
		return signUpVo;
	}
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	@ResponseBody
	public String signUp(@RequestBody SignUpVo signUpVo) {
		return Integer.toString(userService.signUp(signUpVo));
	}
	
}
