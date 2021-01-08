package com.trobinson.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trobinson.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    // this method retrieves all the records
    List<Person> findAll();

	List<Person> findByLicenseIsNull();
}
