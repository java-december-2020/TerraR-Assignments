package com.trobinson.overflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trobinson.overflow.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    // Retrieve all
    List<Question> findAll();

    // Find question by id optional (can be null)
    Optional<Question> findById(Long id);
    
}
