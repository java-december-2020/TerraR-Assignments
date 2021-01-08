package com.trobinson.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trobinson.products.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    // Retrieve all
    List<Product> findAll();

}
