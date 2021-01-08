package com.trobinson.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trobinson.relationships.models.License;
import com.trobinson.relationships.repositories.LicenseRepository;

import antlr.StringUtils;

@Service
public class LicenseService {

	// add the repository as a dependency
	private final LicenseRepository lRepo;

	public LicenseService(LicenseRepository lRepo) {
		this.lRepo = lRepo;
	}
	
    // Retrieve All
    public List<License> getAllLicenses() {
        return this.lRepo.findAll();
    }     
    // Create License
    public License createLicense(License newLicense) {
    	newLicense.setNumber(this.createLicenseNum());
        return this.lRepo.save(newLicense);
    }
    
    // Create License Number
    public String createLicenseNum() {
    	License lastLicense = lRepo.findTopByOrderByNumberDesc();
    	int numPlaces = 6;
    	
    	String numString = "";
    	if(lastLicense == null) {
    		numString = "0";
    	} else {
    		String lastNumber = lastLicense.getNumber();
    		numString = StringUtils.stripFront(lastNumber, "0");
    	}
 
    	int idLength = numString.length();
    	int num = Integer.parseInt(numString);
    	
    	String leadingZeros = "";
    	int numZeros = numPlaces - idLength;
    		for (int i = 0; i < numZeros; i++) {
    			leadingZeros = leadingZeros + "0"; 
    		}

    	Integer numPlus = num + 1;
    	String numOut = numPlus.toString();
   		return leadingZeros.concat(numOut); 
    }
    
    
    // Read
    public License getSingleLicense(Long id) {
        return this.lRepo.findById(id).orElse(null);
    }
    
    // Update
    public License updateLicense(License updatedLicense) {
        return this.lRepo.save(updatedLicense);
    }

    // Delete
    public void deleteLicense(Long id) {
        this.lRepo.deleteById(id);
    }

	
}
