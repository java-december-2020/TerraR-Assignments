package com.trobinson.lookify.controllers;

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

import com.trobinson.lookify.models.Song;
import com.trobinson.lookify.services.SongService;

@Controller
public class SongController {
	   @Autowired
	   private SongService sService;
  
	   // Display landing (index) page
	   @GetMapping("/")
	   public String displayLanding() {
	       return "index.jsp";
	   }

	   // Display dashboard
	   @GetMapping("/dashboard")
	   public String displayDashboard(Model viewModel) {
	       viewModel.addAttribute("song", sService.findAll());
	       return "dashboard.jsp";
	   }
	   
	   // Display song details
	   @GetMapping("/songs/{id}")
	   public String getSongDetails(@PathVariable("id") Long id, Model viewModel) {
	       viewModel.addAttribute("song", sService.findById(id));
	       return "details.jsp";
	   }
	   
	   // Display search results
	   @GetMapping("/search/{artistSearched}")
	   public String displayArtist(@PathVariable("artistSearched") String artistSearched, Model viewModel) {
	       List<Song> songs = sService.findByArtistContaining(artistSearched);
		   viewModel.addAttribute("song", songs);
	       return "search.jsp";
	   }
	   
	   // Search for artist
	   @PostMapping("/search")
	   public String searchArtist(@RequestParam(name = "artistSearched") String artistSearched) {
		   return "redirect:/search/"+artistSearched;
	   }
	   
	   // Display Top 10
	   @GetMapping("/search/topTen")
	   public String getTopTen(Model viewModel) {
		   List<Song> songs = sService.getTopTen();
	       viewModel.addAttribute("song", songs);
	       return "topten.jsp";
	   }

	   // Display new page
	   @GetMapping("/songs/new")
	   public String displayAddPage(@ModelAttribute("song") Song song) {
	       return "new.jsp";
	   }
	   
	   // Add new song
	   @PostMapping("/songs/new")
	   public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		   if (result.hasErrors()) {
			   return "new.jsp";
	       } else {
	           sService.create(song);
	           return "redirect:/dashboard";
	       }
	   }	   

	   // Delete song
		@GetMapping("/delete/{id}")
		public String deleteSong(@PathVariable("id") Long id) {
			sService.delete(id);
			return "redirect:/dashboard";
		}
}	

