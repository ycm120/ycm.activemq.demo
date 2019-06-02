package com.ztycm.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello {

	@RequestMapping("test")
	public Map<String, String> test(){
		Map<String, String> result = new HashMap<>();
		result.put("name", "周彤");
		return result;
	} 
}
