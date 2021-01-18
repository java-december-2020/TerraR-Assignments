package com.trobinson.overflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trobinson.overflow.models.Tag;

@Repository
public interface TagRepository 
extends CrudRepository<Tag, Long> {

    // Retrieve all
    List<Tag> findAll();

    // Find tag by subject, optional (can be null)
    Optional<Tag> findBySubject(String subject);
}
