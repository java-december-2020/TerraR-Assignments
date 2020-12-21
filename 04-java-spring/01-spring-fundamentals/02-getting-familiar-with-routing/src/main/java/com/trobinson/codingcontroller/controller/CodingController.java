package com.trobinson.codingcontroller.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
	
	@RequestMapping("")
	public String helloDojo() {
		return "Hello Coding Dojo!";
	}
	
	@RequestMapping("/python")
	public String helloPython() {
		return "Python/Django was awesome!";
	}

	@RequestMapping("/java")
	public String helloJava() {
		return "Java/Spring is better!";
	}
	
}
