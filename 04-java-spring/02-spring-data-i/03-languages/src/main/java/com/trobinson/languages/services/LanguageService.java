package com.trobinson.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trobinson.languages.models.Language;
import com.trobinson.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
    // add the repository as a dependency
   private final LanguageRepository lRepo;
    
   // Constructor
   public LanguageService(LanguageRepository languageRepository) {
       this.lRepo = languageRepository;
   }
    
    //Methods
    
    // Retrieve All
    public List<Language> findAll() {
        return this.lRepo.findAll();
    }
    // Create
    public Language create(Language newLanguage) {
        return this.lRepo.save(newLanguage);
    }
    
    // Read
    public Language findById(Long id) {
        return this.lRepo.findById(id).orElse(null);
    }
    
    // Update
    public Language update(Language updatedLanguage) {
        return this.lRepo.save(updatedLanguage);
    }

    // Delete
    public void deleteById(Long id) {
        this.lRepo.deleteById(id);
    }
}
