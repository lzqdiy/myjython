package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/index")
	public String index() {
		return "index.html";
	}
	@RequestMapping("/image")
	public String image() {
		return "dall-e.html";
	}
}
