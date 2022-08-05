package com.example.musicstorecatalog.repository;

import com.example.musicstorecatalog.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist,Integer> {

}
