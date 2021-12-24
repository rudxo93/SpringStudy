package com.spring.kakao.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.kakao.model.dto.UserDto;
import com.spring.kakao.service.NoticeService;
import com.spring.kakao.service.UserService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public ModelAndView noticeIndex(@RequestParam String pageNumber, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) { // 무시
			for (Cookie c : cookies) {
				if(c.getName().equals("user_email")) {
					HttpSession session = request.getSession();
					UserDto userDto = userService.getUser(c.getValue()); // email값 
					session.setAttribute("login_user", userDto);
				}
			}
		} 
		ModelAndView mav = new ModelAndView("notice/notice");
		mav.addObject("noticeList", noticeService.getNoticeList(noticeService.parseIntPageNumber(pageNumber)));
		mav.addObject("noticeBean", noticeService.getNoticeBean());
		return mav; 
	}
	
	@RequestMapping(value = "notice-insert", method = RequestMethod.GET)
	public String noticeInsertIndex(Model model, HttpServletRequest request) {
		return "notice/notice_insert";
	}

	public String noticeInsert(Model model) {
		return "redirect:notice?pageNumber=1";
	}
	
}
