package com.trobinson.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trobinson.authentication.models.User;
import com.trobinson.authentication.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository uRepo;
    
    // register user and hash their password
    public User registerUser(User newUser) {
    	// Generate a hash
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        // Set the hashed password on the users password field
        newUser.setPassword(hashed);
        // Save the new user with the updated password to the database
        return uRepo.save(newUser);
    }
    
    // find user by email
    public User findByEmail(String email) {
        return uRepo.findByEmail(email);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = uRepo.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = uRepo.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
