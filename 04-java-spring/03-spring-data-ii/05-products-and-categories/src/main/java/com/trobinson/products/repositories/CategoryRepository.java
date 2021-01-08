package com.trobinson.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trobinson.products.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	// Retrieve all
	List<Category> findAll();

}
