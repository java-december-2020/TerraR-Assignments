package com.trobinson.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trobinson.overflow.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

    // Retrieve all
    List<Answer> findAll();

}
