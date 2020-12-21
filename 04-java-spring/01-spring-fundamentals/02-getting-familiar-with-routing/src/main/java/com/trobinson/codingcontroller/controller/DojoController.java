package com.trobinson.codingcontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/dojo")
public class DojoController {

	@RequestMapping("")
	public String showName(@PathVariable(required=false) String text, Model model) {
		text = "The dojo is awesome!";
		model.addAttribute("text", text);
		return "index.jsp";		
	}

	@RequestMapping("/burbank/{name}")
	public String showCity(@PathVariable("name") String name, Model model) {
		String text = name.concat(", Burbank Dojo is located in Southern California");
		model.addAttribute("text", text);
		return "index.jsp";		
	}

	@RequestMapping("/san-jose/{name}")
	public String showHq(@PathVariable("name") String name, Model model) {
		String text = name.concat(", SJ Dojo is the headquarters");
		model.addAttribute("text", text);
		return "index.jsp";		
	}
	
}
