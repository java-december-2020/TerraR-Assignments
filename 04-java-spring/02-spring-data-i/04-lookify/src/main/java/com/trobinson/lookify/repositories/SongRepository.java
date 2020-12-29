package com.trobinson.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trobinson.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>  {
	// list all records
	List<Song> findAll();

    // search for an artist
	List<Song> findByArtistContainingIgnoreCase(String artist);
    
    // find top ten songs
    List<Song> findTop10ByOrderByRatingDesc();
}
