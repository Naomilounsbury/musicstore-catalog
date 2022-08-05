package com.example.musicstorecatalog.repository;

import static org.junit.Assert.*;


import static org.junit.Assert.*;



import com.example.musicstorecatalog.models.Track;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TrackRepositoryTest {
    @Autowired
    private TrackRepository repo;
    @Before
    public void setUp()throws Exception{

    }
    @Test
    public void shouldInteractWithDatabase(){
        Track track =new Track(1,"tracktrack", 200);
        Track expectedTrack =new Track(1,"tracktrack", 200);
        repo.save(track);
        expectedTrack.setId(track.getId());
        assertEquals(expectedTrack, track);

        // Act
        List<Track> allTheTrack = repo.findAll();

        // Assert
        assertEquals(1, allTheTrack.size());

        // Act
        repo.deleteById(track.getId());

        allTheTrack = repo.findAll();
        assertEquals(0, allTheTrack.size());
    }

}