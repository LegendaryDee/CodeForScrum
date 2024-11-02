package com;

import backend.PictureExercise;
import backend.Question;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

public class PictureExerciseTest {
    private String exerciseID;
    private String type;
    private String difficulty;
    private String content;
    private ArrayList<Question> questions;
    private String imagePath;
    private String description;
    private PictureExercise pictureExercise;

    public PictureExerciseTest() {
        this.exerciseID = UUID.randomUUID().toString();
        this.type = "Visual";
        this.difficulty = "Intermediate";
        this.content = "Identify objects in the image.";
        this.questions = new ArrayList<>();
        this.imagePath = "/images/sample.jpg";
        this.description = "A sample image with various objects.";
        this.pictureExercise = new PictureExercise(exerciseID, type, difficulty, content, questions, imagePath, description);
    }

    @Test
    public void testGetExerciseID() {
     
    }

    @Test
    public void testGetType() {
        
    }

    @Test
    public void testGetDifficulty() {
      
    }

    @Test
    public void testGetContent() {
       
    }

    @Test
    public void testGetImagePath() {
        assertEquals(imagePath, pictureExercise.getImagePath());
    }

    @Test
    public void testSetImagePath() {
        String newPath = "/images/new_image.jpg";
        pictureExercise.setImagePath(newPath);
        assertEquals(newPath, pictureExercise.getImagePath());
    }

    @Test
    public void testGetDescription() {
        assertEquals(description, pictureExercise.getDescription());
    }

    @Test
    public void testSetDescription() {
        String newDescription = "A new image description.";
        pictureExercise.setDescription(newDescription);
        assertEquals(newDescription, pictureExercise.getDescription());
    }

    @Test
    public void testDisplayImage() {
        pictureExercise.displayImage();
        // Verifying display is simulated by checking console output (if required).
    }

    @Test
    public void testShowDescription() {
        pictureExercise.showDescription();
        // Verifying description display is simulated by checking console output (if required).
    }

    @Test
    public void testAddQuestion() {
        
    }

    @Test
    public void testToString() {
        String expected = String.format(
                "PictureExercise{exerciseID='%s', type='%s', difficulty='%s', content='%s', imagePath='%s', description='%s'}",
                exerciseID, type, difficulty, content, imagePath, description);
        assertEquals(expected, pictureExercise.toString());
    }
}
