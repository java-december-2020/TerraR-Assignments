package com.trobinson.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trobinson.dojo.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {

    // Retrieve all
    List<Dojo> findAll();
    
}
