package com.trobinson.events.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.trobinson.events.models.Event;
import com.trobinson.events.models.StateArray;
import com.trobinson.events.models.User;
import com.trobinson.events.services.EventService;
import com.trobinson.events.services.UserService;

@Controller
public class EventController {
	
	@Autowired
	private EventService eService;
	
	@Autowired
	private UserService uService;

	
	// Load events page
	@GetMapping("/events")
	public String displayFormEvent(@ModelAttribute("event") Event event, Model viewModel, HttpSession session, RedirectAttributes redirectAttr) {
		if(session.getAttribute("user_id") == null) {
			redirectAttr.addFlashAttribute("error", "You must log in!");
			
	    	StateArray stateArray = new StateArray();
	        List<String> states = new ArrayList<>();
	        states = stateArray.getStates();
	    	viewModel.addAttribute("state", states);
	    	
			return "redirect:/";
		}
		
		Long userId = (Long)session.getAttribute("user_id");
		User user = this.uService.findUserById(userId);
		viewModel.addAttribute("user", user);
		
		List<Event> events = eService.findAllEvents();
		viewModel.addAttribute("events", events);
		
    	StateArray stateArray = new StateArray();
        List<String> states = new ArrayList<>();
        states = stateArray.getStates();
    	viewModel.addAttribute("state", states);

		return "events.jsp";
	}
	
	// Cancel an event joined
	@GetMapping("/event/cancel/{id}")
	public String cancel(@PathVariable("id") Long eventId, HttpSession session) {

		Long userId = (Long)session.getAttribute("user_id");
		User user = this.uService.findUserById(userId);

		Event event = this.eService.findEventById(eventId);

		this.eService.removeJoiner(user, event);

		return "redirect:/events";
	}
	
	// Join an event
	@GetMapping("/event/join/{id}")
	public String like(@PathVariable("id") Long eventId, HttpSession session) {

		Long userId = (Long)session.getAttribute("user_id");
		User user = this.uService.findUserById(userId);
		System.out.println("User: " + user.getId());

		Event event = this.eService.findEventById(eventId);
		this.eService.addJoiner(user, event);
		System.out.println("Event: " + event.getId());
		
		return "redirect:/events";
	}


	// Create an event
	@PostMapping("/events")
	public String processFormEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model viewModel, HttpSession session) {
		if (result.hasErrors()) {
			
			List<Event> events = eService.findAllEvents();
			viewModel.addAttribute("events", events);
			
	    	StateArray stateArray = new StateArray();
	        List<String> states = new ArrayList<>();
	        states = stateArray.getStates();
	    	viewModel.addAttribute("state", states);
	    	
			Long userId = (Long)session.getAttribute("user_id");
			User user = this.uService.findUserById(userId);
			viewModel.addAttribute("user", user);
			
			return "events.jsp";
		} else {
			eService.createEvent(event);
			return "redirect:/events";
		}
	}
	
	
	// Edit an event
	@GetMapping("/events/{id}/edit")
	public String displayFormEdit(@PathVariable("id") Long eventId, Model viewModel) {
		Event event = eService.findEventById(eventId);
		viewModel.addAttribute("event", event);
		
    	StateArray stateArray = new StateArray();
        List<String> states = new ArrayList<>();
        states = stateArray.getStates();
    	viewModel.addAttribute("state", states);
		
		return "edit.jsp";
	}
	
	// Process edited event
	@PostMapping("/events/{id}/edit")
	public String processFormEdit(@Valid @ModelAttribute("event") Event event, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {

			return "redirect:/";
		}
	}
	
	
}
