package com.example.musicstorecatalog.repository;

import com.example.musicstorecatalog.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Integer> {

}
