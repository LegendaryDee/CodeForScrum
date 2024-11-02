package com.narration;

import backend.Question;
import backend.StoryExercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StoryExerciseTest {

    private StoryExercise storyExercise;
    private String exerciseID;
    private String type;
    private String difficulty;
    private String content;
    private ArrayList<Question> questions;
    private String storyText;
    private String narrationFilePath;

    @BeforeEach
    public void setUp() {
        exerciseID = "exercise123";
        type = "Story";
        difficulty = "Intermediate";
        content = "Read the following story";
        questions = new ArrayList<>();
        storyText = "Once upon a time, in a faraway land...";
        narrationFilePath = "/path/to/narration.mp3";

        storyExercise = new StoryExercise(exerciseID, type, difficulty, content, questions, storyText, narrationFilePath);
    }

    @Test
    public void testReadStory() {
        storyExercise.readStory();
        System.out.println("Story text read successfully.");
    }

    @Test
    public void testGetStoryText() {
        String retrievedStoryText = storyExercise.getStoryText(storyText);
        assertEquals(storyText, retrievedStoryText);
        System.out.println("Story text retrieved: " + retrievedStoryText);
    }

    @Test
    public void testSetAndGetNarrationFilePath() {
        String newNarrationPath = "/new/path/to/narration.mp3";
        storyExercise.setNarrationFilePath(newNarrationPath);
        assertEquals(newNarrationPath, storyExercise.getNarrationFilePath());
        System.out.println("Narration file path set and retrieved: " + newNarrationPath);
    }

    @Test
    public void testExerciseAttributes() {
        assertEquals(exerciseID, storyExercise.getExerciseID());
        assertEquals(type, storyExercise.getType());
        assertEquals(difficulty, storyExercise.getDifficulty());
        assertEquals(content, storyExercise.getContent());
        assertNotNull(storyExercise.getQuestions());
        System.out.println("Exercise attributes validated.");
    }

    @Test
    public void testSetStoryText() {
        String newStoryText = "A new beginning in a mystical forest...";
        storyExercise.getStoryText(newStoryText);
        assertEquals(newStoryText, storyExercise.getStoryText(newStoryText));
        System.out.println("Story text set and validated: " + newStoryText);
    }
}
