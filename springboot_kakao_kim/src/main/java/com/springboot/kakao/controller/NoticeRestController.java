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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.kakao.model.beans.FileBean;
import com.springboot.kakao.model.dto.NoticeDto;
import com.springboot.kakao.model.dto.NoticeInsertDto;
import com.springboot.kakao.model.dto.NoticeUpdateDto;
import com.springboot.kakao.model.dto.UserDto;
import com.springboot.kakao.service.NoticeService;
import com.springboot.kakao.service.UserService;

@RestController
@RequestMapping("/notice")
public class NoticeRestController {
	
	@Autowired
	private NoticeService noticeService;

	@PostMapping("/insert")
	public String noticeInsert(NoticeInsertDto noticeInsertDto) {
		int insertFlag = 0;
		insertFlag = noticeService.noticeInsert(noticeInsertDto);
		return Integer.toString(insertFlag);
	}
	
	@GetMapping("/file-download/{originFileName}") // 어떤 파일을 다운받는지 명확하게 보여주기 위해서
	public byte[] noticeDtlFileDownload(HttpServletResponse response,
										@PathVariable String originFileName,
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
	
	@PutMapping("/update/{code}")
	public String noticeUpdate(@PathVariable int code, NoticeUpdateDto noticeUpdateDto) {
		System.out.println(noticeUpdateDto);
		return "1";
	}
}
