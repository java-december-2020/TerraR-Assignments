package com.trobinson.events.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trobinson.events.models.Event;
import com.trobinson.events.models.User;
import com.trobinson.events.repositories.EventRepository;

@Service
public class EventService {

	@Autowired  
	private EventRepository eRepo;
	    
	//Methods
	    
	// Retrieve All
	public List<Event> findAllEvents() {
		return this.eRepo.findAll();
	}
	
	// Create
	public Event createEvent(Event newEvent) {
		return this.eRepo.save(newEvent);
	}
	    
	// Read - Find One
	public Event findEventById(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	    
	// Update
	public Event updateEvent(Event updatedEvent) {
		return this.eRepo.save(updatedEvent);
	}
	
	public void addJoiner(User user, Event event) {
		// Get list of joiners
		List <User> joiner = event.getJoiner();
		// Add user to list of joiners
		joiner.add(user);
		// Save event to DB
		this.eRepo.save(event);
	}
	
	public void removeJoiner(User user, Event event) {
		// Get list of joiners
		List <User> joiner = event.getJoiner();
		// Remove user from list of joiners
		joiner.remove(user);
		// Save event to DB
		this.eRepo.save(event);
	}
	
}
