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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.trobinson.events.models.StateArray;
import com.trobinson.events.models.User;
import com.trobinson.events.services.UserService;
import com.trobinson.events.validators.UserValidator;

@Controller
public class UserController {

	@Autowired
    private UserService uService;
	
	@Autowired
	private UserValidator validator;
    
	// Register or Login User
    @GetMapping("/")
    public String registerForm(@ModelAttribute("user") User user, Model viewModel) {
    	StateArray stateArray = new StateArray();
        List<String> states = new ArrayList<>();
        states = stateArray.getStates();
    	viewModel.addAttribute("state", states);
        return "index.jsp";
    }
    
    // Process Registration
    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	validator.validate(user, result);
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			User newUser = uService.registerUser(user);
			session.setAttribute("user_id", newUser.getId());
			return "redirect:/";
		}
    }    
       
    // Process Login
    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttrs, HttpSession session) {
    	if(!uService.authenticateUser(email, password)) {
    		redirectAttrs.addFlashAttribute("error", "Invalid Credentials");
    		return "redirect:/";
    	} else {
    		User user = this.uService.findByEmail(email);
    		session.setAttribute("user_id", user.getId());    		
    		return "redirect:/events";
    	}
    }
    
    // Logout User
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
	
}
