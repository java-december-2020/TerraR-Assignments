package com.trobinson.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trobinson.events.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

	// Retrieve all
	List<Event> findAll();


}
