package com.trobinson.dojo.controllers;

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

import com.trobinson.dojo.models.Dojo;
import com.trobinson.dojo.models.Ninja;
import com.trobinson.dojo.services.DojoService;
import com.trobinson.dojo.services.NinjaService;

@Controller
public class HomeController {

	@Autowired
	private DojoService dService;
	
	@Autowired
	private NinjaService nService;
	
	
	// Landing
	@GetMapping("/")
	public String landing(Model viewModel) {
		List<Dojo> dojos = dService.findAllDojos();
		viewModel.addAttribute("dojo", dojos);
		return "index.jsp";
	}

	
	// Display add new dojo page
	@GetMapping("/dojos/new")
	public String displayAddNewDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "new_dojo.jsp";
	}
	
	// Add new dojo
	@PostMapping("/dojos/new")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "/new_dojo.jsp";
		} else {
			dService.createDojo(dojo);
			return "redirect:/";
		}
	}	
	
	
	// Display add new ninja page
	@GetMapping("/ninjas/new")
	public String displayAddNewNinja(@ModelAttribute("ninja") Ninja ninja, @ModelAttribute("dojo") Dojo dojo, Model viewModel) {
		List<Dojo> dojos = dService.findAllDojos();
		viewModel.addAttribute("dojo", dojos);
		return "/new_ninja.jsp";
	}
	
	// Add new ninja
	@PostMapping("/ninjas/new")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
		return "/new_ninja.jsp";
	} else {
		nService.createNinja(ninja);
		return "redirect:/";
		}
	}
	
	// Display details
	@GetMapping("/dojos/{id}")
	public String getDetails(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("dojo", dService.findOneDojo(id));
		return "/details.jsp";
	}	
	
	
	
	
	
	
	
}
