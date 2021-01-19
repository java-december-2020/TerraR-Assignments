package com.trobinson.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.trobinson.authentication.models.User;
import com.trobinson.authentication.services.UserService;
import com.trobinson.authentication.validators.UserValidator;

@Controller
public class UsersController {
	@Autowired
    private UserService uService;
	
	@Autowired
	private UserValidator validator;
    
	@RequestMapping("/home")
	public String home(HttpSession session, Model viewModel) {
	    // get user from session, save them in the model and return the home page
		viewModel.addAttribute(session);
		return "homePage.jsp";
	}
	
	
	// Register User
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	validator.validate(user, result);
		if (result.hasErrors()) {
			return "registrationPage.jsp";
		} else {
			User newUser = uService.registerUser(user);
			session.setAttribute("user_id", newUser.getId());
			return "redirect:/home";
		}
    }    
    
    // Authenticate user
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
     
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model viewModel, RedirectAttributes redirectAttrs, HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    	if(!uService.authenticateUser(email, password)) {
    		redirectAttrs.addFlashAttribute("error", "Invalid Credentials");
    		return "redirect:/login";
    	} else {
    		User user = this.uService.findByEmail(email);
    		session.setAttribute("user_id", user.getId());    		
    		return "loginPage.jsp";
    	}
    	
    }
    
 
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    	return "redirect:/loginPage";
    }
}