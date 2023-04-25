package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@GetMapping("/hello")
	public @ResponseBody TestDto hello() {
		TestDto dto = new TestDto();
		dto.setName("김치");
		dto.setHp("010-1234-6789");
		dto.setAddr("경기도 경기시 경기동");
		return dto;
	}
}
