package com.trobinson.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trobinson.dojo.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {

    // Retrieve all
    List<Ninja> findAll();
    
}
