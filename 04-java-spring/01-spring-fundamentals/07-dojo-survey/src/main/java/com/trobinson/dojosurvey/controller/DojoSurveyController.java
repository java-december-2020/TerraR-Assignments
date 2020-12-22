package com.trobinson.dojosurvey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoSurveyController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	private String home() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/redirect", method=RequestMethod.POST)
	private String redirectHome() {
		return "redirect:/";
	}

	@RequestMapping(value="/result", method=RequestMethod.POST)
	private String result(@RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment") String comment, Model viewModel) {
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("location", location);
		viewModel.addAttribute("language", language);
		viewModel.addAttribute("comment", comment);
		return "result.jsp";
	}

}
