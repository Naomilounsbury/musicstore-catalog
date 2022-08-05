package com.example.musicstorecatalog.repository;

import com.example.musicstorecatalog.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Integer> {

}
