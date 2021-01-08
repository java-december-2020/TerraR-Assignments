package com.trobinson.products.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trobinson.products.models.Category;
import com.trobinson.products.models.Product;
import com.trobinson.products.repositories.ProductRepository;

@Service
public class ProductService {

    // add the repository as a dependency
   private final ProductRepository pRepo;
    
   // Constructor
   public ProductService(ProductRepository productRepository) {
       this.pRepo = productRepository;
   }
    
    //Methods
    
    // Retrieve All
    public List<Product> findAllProducts() {
        return this.pRepo.findAll();
    }
    // Create
    public Product createProduct(Product newProduct) {
        return this.pRepo.save(newProduct);
    }
    
    // Read - Find One
    public Product findOneProduct(Long id) {
        return this.pRepo.findById(id).orElse(null);
    }
    
    // Update
    public Product updateProduct(Product product) {
        return this.pRepo.save(product);
    }

    // Add category to product
    public void updateProductCategory(Product product, Category category) {
    	product.getCategories().add(category);
    	pRepo.save(product);
    }
    
    // Delete
    public void deleteProduct(Long id) {
        this.pRepo.deleteById(id);
    }

	
}
