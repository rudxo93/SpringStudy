package com.springboot.study.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.study.model.vo.JsonTest;

@RestController
public class RestTestController {

	@GetMapping("get-req/{data}/{num}")
	public String getMapping(@PathVariable String data, @PathVariable String num) {
		return data+"/"+num;
	}
	
	@PostMapping("post-req")
	public String postMapping(@RequestParam String data) {
		return data;
	}
	
	@PutMapping("put-req/{data}/{num}")
	public String putMapping(@PathVariable String data, @PathVariable String num, @RequestBody JsonTest jsonTest) {
		return data+"/"+num + "->" + jsonTest;
	}
	
	@DeleteMapping("delete-req/{border}/{code_number}")
	public String deleteMapping(@PathVariable String border, @PathVariable String code_number) {
		return "delete";
	}
	
}
