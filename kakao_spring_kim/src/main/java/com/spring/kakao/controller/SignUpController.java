package com.spring.kakao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.kakao.model.json.SignUpVo;
import com.spring.kakao.service.UserService;

@Controller
public class SignUpController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public ModelAndView SignUpIndex() {
		return new ModelAndView("signUp/sign_up");
	}
	
	@RequestMapping(value = "/sign-up-emailCheck", method = RequestMethod.POST)
	@ResponseBody
	public Object signUpEmailCheck(@RequestParam String signUpEmail) {  // json데이터를 전달해야 되기 때문에 object 사용
		SignUpVo signUpVo = new SignUpVo();
		signUpVo.setSignUpEmail(signUpEmail);
		signUpVo.setEmailFlag(userService.signUpEmailCheck(signUpEmail));
		System.out.println(signUpVo);
		return signUpVo;
	}
	
}