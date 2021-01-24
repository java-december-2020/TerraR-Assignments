package com.trobinson.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trobinson.events.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

	// Retrieve all
	List<Comment> findAll();


}
