package com.trobinson.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trobinson.relationships.models.Person;
import com.trobinson.relationships.repositories.PersonRepository;

@Service
public class PersonService {

	// add the repository as a dependency
	private final PersonRepository pRepo;

	public PersonService(PersonRepository pRepo) {
		this.pRepo = pRepo;
	}
    // Retrieve All
    public List<Person> getAllPersons() {
        return this.pRepo.findAll();
    }
	// Retrieve Unlicensed
    public List<Person> getUnlicensedPeople() {
		return pRepo.findByLicenseIsNull();
	}
    // Create
    public Person createPerson(Person newPerson) {
        return this.pRepo.save(newPerson);
    }
    
    // Read
    public Person getSinglePerson(Long id) {
        return this.pRepo.findById(id).orElse(null);
    }
    
    // Update
    public Person updatePerson(Person updatedPerson) {
        return this.pRepo.save(updatedPerson);
    }

    // Delete
    public void deletePerson(Long id) {
        this.pRepo.deleteById(id);
    }


}
