package com.trobinson.events.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trobinson.events.models.Comment;
import com.trobinson.events.models.Event;
import com.trobinson.events.models.User;
import com.trobinson.events.services.CommentService;
import com.trobinson.events.services.EventService;
import com.trobinson.events.services.UserService;

@Controller
public class CommentController {

	@Autowired
	private EventService eService;
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private CommentService cService;
	
	
	// Message page
	@GetMapping("/events/{id}")
	public String displayFormComment(@PathVariable("id") Long eventId, Model viewModel, HttpSession session) {

		Long userId = (Long)session.getAttribute("user_id");
		User user = this.uService.findUserById(userId);
		viewModel.addAttribute("user", user);
		
		Event event = eService.findEventById(eventId);
		viewModel.addAttribute("event", event);
		
		List<Comment> comments = cService.findAllComments();
		viewModel.addAttribute("comments", comments);
	
		return "comments.jsp";
	}
	
	// Process message
	@PostMapping("/events/{id}")
	public String processFormComment(@PathVariable("id") Long eventId, @RequestParam("message") String message, Model viewModel, HttpSession session) {
		
			Long userId = (Long)session.getAttribute("user_id");
			
			this.cService.createComment(message, eventId, userId);
			
			return "redirect:/events";
	}
}
