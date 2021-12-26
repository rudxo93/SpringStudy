package com.spring.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.study.model.dto.FileDto;

@Controller
public class FileTestController {

	@RequestMapping(value = "file-insert", method = RequestMethod.GET)
	public String fileInsertIndex(Model model) {
		return "file";
	}
	
	@RequestMapping(value = "file-insert", method = RequestMethod.POST)
	@ResponseBody
	public String fileInsert(FileDto fileDto) {
		System.out.println(fileDto);
		
		for(MultipartFile file : fileDto.getUser_photo()) { // 몇번째의 파일을 가져올것인지	
			System.out.println(file.getOriginalFilename());
		}
		
		return "1";
	}
	
}
 