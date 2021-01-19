package com.trobinson.authentication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trobinson.authentication.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    // Retrieve a user by their email address
	User findByEmail(String email);
	
	// Search for email
	boolean existsByEmail(String email);

}
