package com.example.musicstorecatalog.repository;


import com.example.musicstorecatalog.models.Label;
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
public class LabelRepositoryTest {
    @Autowired
    private LabelRepository repo;
    @Before
    public void setUp()throws Exception{
        repo.deleteAll();

    }
    @Test
    public void shouldInteractWithDatabase(){
        Label label =new Label("this label","www.greatlabel.com");
        Label expectedLabel =new Label("this label","www.greatlabel.com");
        repo.save(label);
        expectedLabel.setId(label.getId());
        assertEquals(expectedLabel, label);

        // Act
        List<Label> allTheLabel = repo.findAll();

        // Assert
        assertEquals(1, allTheLabel.size());

        // Act
        repo.deleteById(label.getId());

        allTheLabel = repo.findAll();
        assertEquals(0, allTheLabel.size());
    }

}