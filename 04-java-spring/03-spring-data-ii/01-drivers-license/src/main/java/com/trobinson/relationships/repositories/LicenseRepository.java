package com.trobinson.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trobinson.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {

    // this method retrieves all the records
    List<License> findAll();
    public License findTopByOrderByNumberDesc();
}
