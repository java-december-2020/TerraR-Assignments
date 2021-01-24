package com.trobinson.events.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trobinson.events.models.Comment;
import com.trobinson.events.models.Event;
import com.trobinson.events.models.User;
import com.trobinson.events.repositories.CommentRepository;
import com.trobinson.events.repositories.EventRepository;
import com.trobinson.events.repositories.UserRepository;

@Service
public class CommentService {

	@Autowired  
	private CommentRepository cRepo;
	    
	@Autowired  
	private UserRepository uRepo;
	
	@Autowired  
	private EventRepository eRepo;
	
	    
	// Retrieve All
	public List<Comment> findAllComments() {
		return this.cRepo.findAll();
	}
	
	// Create
	public Comment createComment(String message, Long eventId, Long userId) {

		User user = uRepo.findById(userId).orElse(null);
		Event event = eRepo.findById(eventId).orElse(null);
		Comment comment = new Comment();
		
		comment.setEvent(event);
		comment.setCommenter(user);
		comment.setMessage(message);
		
		return this.cRepo.save(comment);
	}
	
	
	    
	// Read - Find One
	public Comment findCommentById(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	    
	// Update
	public Comment updateComment(Comment updatedComment) {
		return this.cRepo.save(updatedComment);
	}
	
	// Delete
	public void deleteComment(Long id) {
		this.cRepo.deleteById(id);
	}
	
}
