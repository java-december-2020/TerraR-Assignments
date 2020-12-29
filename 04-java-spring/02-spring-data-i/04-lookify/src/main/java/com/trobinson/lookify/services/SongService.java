package com.trobinson.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trobinson.lookify.models.Song;
import com.trobinson.lookify.repositories.SongRepository;

@Service
public class SongService {
    // add the repository as a dependency
   private final SongRepository sRepo;
    
   // Constructor
   public SongService(SongRepository songRepository) {
       this.sRepo = songRepository;
   }
    
    //Methods
    
    // Find All
    public List<Song> findAll() {
        return this.sRepo.findAll();
    }

    // Get Top Ten
    public List<Song> getTopTen() {
        return this.sRepo.findTop10ByOrderByRatingDesc();
    }
    
    // Create new song
    public Song create(Song newSong) {
        return this.sRepo.save(newSong);
    }
    
    // Find by ID
    public Song findById(Long id) {
        return this.sRepo.findById(id).orElse(null);
    }
    
    // Search by Artist
    public List<Song> findByArtistContaining(String artist) {
        return this.sRepo.findByArtistContainingIgnoreCase(artist);
    }
    
    // Delete
    public void delete(Long id) {
        this.sRepo.deleteById(id);
    }
}

