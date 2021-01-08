package com.trobinson.dojo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trobinson.dojo.models.Ninja;
import com.trobinson.dojo.repositories.NinjaRepository;

@Service
public class NinjaService {

    // add the repository as a dependency
   private final NinjaRepository nRepo;
    
   // Constructor
   public NinjaService(NinjaRepository ninjaRepository) {
       this.nRepo = ninjaRepository;
   }
    
    //Methods
    
    // Retrieve All
    public List<Ninja> findAllNinjas() {
        return this.nRepo.findAll();
    }
    // Create
    public Ninja createNinja(Ninja newNinja) {
        return this.nRepo.save(newNinja);
    }
    
    // Read - Find One
    public Ninja findOneNinja(Long id) {
        return this.nRepo.findById(id).orElse(null);
    }
    
    // Update
    public Ninja updateNinja(Ninja updatedNinja) {
        return this.nRepo.save(updatedNinja);
    }

    // Delete
    public void deleteNinja(Long id) {
        this.nRepo.deleteById(id);
    }
	
}
