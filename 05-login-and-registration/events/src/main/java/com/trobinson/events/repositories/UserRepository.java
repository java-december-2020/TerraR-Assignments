package com.trobinson.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trobinson.events.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	// Retrieve all
	List<User> findAll();

	// Retrieve a user by their email address
	User findByEmail(String email);
	
	// Search for email
	boolean existsByEmail(String email);
	
}
