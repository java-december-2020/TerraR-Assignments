package com.trobinson.events.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

import com.trobinson.events.models.User;
import com.trobinson.events.repositories.UserRepository;

@Component
public class UserValidator {

	@Autowired
	private UserRepository uRepo;

	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		//Make sure password and password confirmation match
		if(!user.getPassword().equals(user.getPasswordConfirmation())) {
			errors.rejectValue("password", "Match", "Passwords do not match!");
		}
		//Make sure email is unique in the database
		if(uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Unique", "Email is already taken!");
		}
	}
	
}
