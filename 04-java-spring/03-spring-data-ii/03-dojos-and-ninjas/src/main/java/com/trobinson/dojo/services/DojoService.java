package com.trobinson.dojo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trobinson.dojo.models.Dojo;
import com.trobinson.dojo.repositories.DojoRepository;

@Service
public class DojoService {

    // add the repository as a dependency
   private final DojoRepository dRepo;
    
   // Constructor
   public DojoService(DojoRepository dojoRepository) {
       this.dRepo = dojoRepository;
   }
    
    //Methods
    
    // Retrieve All
    public List<Dojo> findAllDojos() {
        return this.dRepo.findAll();
    }
    // Create
    public Dojo createDojo(Dojo newDojo) {
        return this.dRepo.save(newDojo);
    }
    
    // Read - Find One
    public Dojo findOneDojo(Long id) {
        return this.dRepo.findById(id).orElse(null);
    }
    
    // Update
    public Dojo updateDojo(Dojo updatedDojo) {
        return this.dRepo.save(updatedDojo);
    }

    // Delete
    public void deleteDojo(Long id) {
        this.dRepo.deleteById(id);
    }
	
}
