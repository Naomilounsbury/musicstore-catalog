package com.example.musicstorecatalog.repository;

import com.example.musicstorecatalog.models.Album;
import com.example.musicstorecatalog.models.Artist;
import com.example.musicstorecatalog.models.Label;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AlbumRepositoryTest {

    @Autowired
    private AlbumRepository repo;
    @Autowired
    private LabelRepository labelRepo;
    @Autowired
    private ArtistRepository artistRepo;

    @Before
    public void setUp()throws Exception{

        Label label1 =new Label("label","label@i.com");
        Label expectedLabel =new Label(1,"label","label@i.com");
        labelRepo.save(label1);
        Artist artist1 =new Artist("Artist", "intsa","twit");
        Artist expectedArtist =new Artist(1,"Artist", "intsa","twit");
        artistRepo.save(artist1);


    }
    @Test
    public void shouldInteractWithDatabase(){
//
        Album album =new Album("this artist",1, LocalDate.of(2022,12,20),1, new BigDecimal(10.99));
        Album expectedAlbum =new Album(1,"this artist",1, LocalDate.of(2022,12,20),1, new BigDecimal(10.99));
        repo.save(album);
        expectedAlbum.setId(album.getId());
        assertEquals(expectedAlbum, album);

        // Act
        List<Album> allTheAlbum = repo.findAll();

        // Assert
        assertEquals(1, allTheAlbum.size());

        // Act
        repo.deleteById(album.getId());

        allTheAlbum = repo.findAll();
        assertEquals(0, allTheAlbum.size());
    }



}