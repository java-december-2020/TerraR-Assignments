package com.trobinson.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trobinson.relationships.models.License;
import com.trobinson.relationships.models.Person;
import com.trobinson.relationships.services.LicenseService;
import com.trobinson.relationships.services.PersonService;

@Controller
public class HomeController {

	@Autowired
	private PersonService pService;
	
	@Autowired
	private LicenseService lService;

	// Landing page
	@GetMapping("/")
	public String landing(Model viewModel) {
		List<Person> persons = pService.getAllPersons();
		viewModel.addAttribute("person", persons);
		return "index.jsp";
	}
	
	// Go to display page
	@PostMapping("/{id}")
	public String goToDisplay(@RequestParam("name = id") Long id) {
		System.out.println("This is the id:" + id);
		return "redirect:/persons/" + id;
		}
	
	// New person form
	@GetMapping("/persons/new")
	public String addNewPerson(@ModelAttribute("person") Person person) {
		return "new_person.jsp";
	}
	   
	// Add new person
	@PostMapping("/persons/new")
	public String addPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "new_person.jsp";
		} else {
			pService.createPerson(person);
			return "redirect:/";
		}
	}  
   
	// New license form
	@GetMapping("/licenses/new")
	public String addNewLicense(@ModelAttribute("license") License license, @ModelAttribute("person") Person person, Model viewModel) {
		List<Person> persons = pService.getUnlicensedPeople();
		viewModel.addAttribute("person", persons);
		return "new_license.jsp";
	}
	
	// Add new license
	@PostMapping("/licenses/new")
	public String addLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
		return "new_license.jsp";
	} else {
		lService.createLicense(license);
		return "redirect:/";
		}
	}
	
	// Details
	@GetMapping("/persons/{id}")
	public String getDetails(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("person", pService.getSinglePerson(id));
		viewModel.addAttribute("license", lService.getSingleLicense(id));
		return "details.jsp";
	}
	
	
}
