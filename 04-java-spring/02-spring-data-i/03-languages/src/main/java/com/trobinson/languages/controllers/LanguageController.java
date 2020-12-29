package com.trobinson.languages.controllers;

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

import com.trobinson.languages.models.Language;
import com.trobinson.languages.services.LanguageService;

@Controller
public class LanguageController {
	   @Autowired
	   private LanguageService lService;
  
	   // Lists All Languages
	   @GetMapping("/languages")
	   public String displayDashboard(Model viewModel, @ModelAttribute("language") Language language) {
	       List<Language> languages = this.lService.findAll();
	       viewModel.addAttribute("languages", languages);
	       return "index.jsp";
	   }
	       	    
	   // Adds a new language
	   @PostMapping("/languages")
	   public String createLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		   if (result.hasErrors()) {
	       } else {
	           lService.create(language);
	       }
           return "redirect:/languages";
	   }
	   
	   // Gets a language by ID
	   @GetMapping("/languages/{id}")
	   public String findLanguage(@PathVariable("id") String idPath, Model viewModel) {
		   Long id = Long.valueOf(idPath);
		   Language language = lService.findById(id);
	       viewModel.addAttribute("language", language);
	       return "details.jsp";
	   }
	   
	   // Displays a language to be updated
	   @GetMapping("/languages/edit/{id}")
	   public String displayLanguage(@PathVariable("id") String idPath, Model viewModel) {
		   Long id = Long.valueOf(idPath);
		   Language language = lService.findById(id);
	       viewModel.addAttribute("language", language);
	       return "edit.jsp";
	   }
	   
	   // Updates a language
	   @PostMapping("/languages/update/{id}")
	   public String updateLanguage(@Valid @ModelAttribute("language") Language updatedLanguage, BindingResult result) {
//		   if (result.hasErrors()) {
//	           return "edit.jsp";
//			} else {
				lService.update(updatedLanguage);
				return "redirect:/languages";
//			}
	   }
	   
	   // Deletes a language
		@GetMapping("/languages/delete/{id}")
		public String deleteLanguage(@PathVariable("id") String idPath) {
			Long id = Long.valueOf(idPath);
			lService.deleteById(id);
			return "redirect:/languages";
		}
}
