package com.trobinson.products.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trobinson.products.models.Category;
import com.trobinson.products.repositories.CategoryRepository;

@Service
public class CategoryService {

    // add the repository as a dependency
   private final CategoryRepository cRepo;
    
   // Constructor
   public CategoryService(CategoryRepository categoryRepository) {
       this.cRepo = categoryRepository;
   }
    
    //Methods
    
    // Retrieve All
    public List<Category> findAllCategories() {
        return this.cRepo.findAll();
    }
    // Create
    public Category createCategory(Category newCategory) {
        return this.cRepo.save(newCategory);
    }
    
    // Read - Find One
    public Category findOneCategory(Long id) {
        return this.cRepo.findById(id).orElse(null);
    }
    
    // Update
    public Category updateCategory(Category updatedCategory) {
        return this.cRepo.save(updatedCategory);
    }

    // Delete
    public void deleteCategory(Long id) {
        this.cRepo.deleteById(id);
    }

	
}
