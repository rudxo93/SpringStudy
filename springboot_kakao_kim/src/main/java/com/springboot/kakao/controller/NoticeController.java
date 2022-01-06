package com.springboot.kakao.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.kakao.model.beans.FileBean;
import com.springboot.kakao.model.dto.NoticeDto;
import com.springboot.kakao.model.dto.NoticeInsertDto;
import com.springboot.kakao.model.dto.UserDto;
import com.springboot.kakao.service.NoticeService;
import com.springboot.kakao.service.UserService;

@Controller
@RequestMapping("notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private UserService userService;
	 
	@GetMapping("list/{page}")
	public ModelAndView noticeIndex(@PathVariable String page, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("user_email")) {
					HttpSession session = request.getSession();
					UserDto userDto = userService.getUser(c.getValue());
					session.setAttribute("login_user", userDto);
				}
			}
		}
		ModelAndView mav = new ModelAndView("notice/notice");
		mav.addObject("noticeList", noticeService.getNoticeList(noticeService.parseIntPageNumber(page)));
		mav.addObject("noticeBean", noticeService.getNoticeBean());
		return mav;
	}
	 
	@GetMapping("insert")
	public String noticeInsertIndex(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login_user") == null) {
			return "redirect:sign-in";
		}
		
		Date date = new Date();
		model.addAttribute("now", date);
		return "notice/notice_insert";
	}

	@RequestMapping(value = "notice-insert", method = RequestMethod.POST)
	@ResponseBody
	public String noticeInsert(NoticeInsertDto noticeInsertDto) {
		int insertFlag = 0;
		insertFlag = noticeService.noticeInsert(noticeInsertDto);
		return Integer.toString(insertFlag);
	}
	
	@GetMapping("{code}")
	public String noticeDtlIndex(Model model, @PathVariable String code) {
		NoticeDto noticeDto = noticeService.getNotice(code);
		System.out.println(noticeDto);
		model.addAttribute("notice", noticeDto);
		model.addAttribute("fileList", noticeService.getFileList(noticeDto));
		return "notice/notice_dtl";
	}
	
	@RequestMapping(value = "file-download", method = RequestMethod.GET)
	@ResponseBody
	public byte[] noticeDtlFileDownload(HttpServletResponse response,
															@RequestParam String originFileName,
															@RequestParam String tempFileName) {
		FileBean fileBean = new FileBean();
		fileBean.setOriginFileName(originFileName);
		fileBean.setTempFileName(tempFileName);
		byte[] fileData = noticeService.fileDownload(fileBean);
		
		String encodingOriginFileName = null;
		
		try {
			encodingOriginFileName = new String(originFileName.getBytes("UTF-8"), "ISO-8859-1"); // 인코딩 해줘야한다.
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		response.setHeader("Content-Disposition", "attachment;filename=\"" + encodingOriginFileName + "\"");
		response.setContentLength(fileData.length);
		
		return fileData;
	}
	
	@DeleteMapping("{code}")
	public String noticeDelete(Model model, @PathVariable String code) {
		int result = noticeService.noticeDelete(code);
		if(result == 2) {
			return "redirect:notice/list/1";
		}
		return "redirect:notice/" + code; // code가 붙으면 게시글 dtl들어간다.
	}
}
