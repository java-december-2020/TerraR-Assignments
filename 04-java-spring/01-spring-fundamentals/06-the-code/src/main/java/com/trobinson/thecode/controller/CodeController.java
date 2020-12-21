package com.trobinson.thecode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	private String home() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	private String tryCode(@RequestParam(value="code") String code, RedirectAttributes redirectAttributes) {
		String incorrect = "";
		if(code.equals("bushido")) {
			return "code.jsp";
			
		} else {
			incorrect = "You must train harder!";
			redirectAttributes.addFlashAttribute("incorrect", incorrect);
			return "redirect:/";
		}
	}
	
}
