package com.trobinson.displaydate.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DateController {
	
	@GetMapping("/")
	private String homePage() {
		return "index.jsp";
	}
	@GetMapping("/date")
	private String datePage(Model model) {

		DateFormat df = new SimpleDateFormat("EEEE', the' dd 'of' MMMM', 'yyyy");
		Date date = new Date();
		String currentDate = df.format(date);
		
		model.addAttribute("currentDate", currentDate);
		return "date.jsp";
	}
	
	@GetMapping("/time")
	private String timePage(Model model) {
		
		DateFormat tf = new SimpleDateFormat("hh:mm a");
		Date time = new Date();
		String currentTime = tf.format(time);
		
		model.addAttribute("currentTime", currentTime);
		
		return "time.jsp";
	}

}
