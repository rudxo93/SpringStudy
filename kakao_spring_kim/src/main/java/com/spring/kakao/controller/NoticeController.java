package com.spring.kakao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.kakao.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public ModelAndView noticeIndex(@RequestParam String pageNumber) {
		ModelAndView mav = new ModelAndView("notice/notice");
		mav.addObject("noticeList", noticeService.getNoticeList(noticeService.parseIntPageNumber(pageNumber)));
		mav.addObject("noticeBean", noticeService.getNoticeBean());
		return mav; 
	}

}
