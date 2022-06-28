package com.springbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
	
	@GetMapping("/hello")
	public String[] hello() {
		return new String[] { "hello", "World"};
	}
}
