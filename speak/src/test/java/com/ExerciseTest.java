package com;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.Exercise;
import backend.Question;

import java.util.ArrayList;
import java.util.UUID;

public class ExerciseTest {

    private Exercise exercise;
    private ArrayList<Question> questions;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Starting ExerciseTest...");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Finished ExerciseTest.");
    }

    @Before
    public void setUp() {
        questions = new ArrayList<>();
        questions.add(new Question("Sample Question 1", null, 0, null));
        exercise = new Exercise("Sample Description", "Medium", "Medium", "Sample Content", questions);
    }

    @After
    public void tearDown() {
        exercise = null;
        questions = null;
    }

    @Test
    public void testGetDifficultyLevel() {
        assertEquals("Medium", exercise.getDifficultyLevel());
    }

    @Test
    public void testCompleteExercise() {
        exercise.completeExercise();
        assertTrue(exercise.isCompleted());
    }

    @Test
    public void testAddQuestion() {
        Question newQuestion = new Question("New Sample Question", null, 0, null);
        exercise.addQuestion(newQuestion);
        assertTrue(exercise.getQuestions().contains(newQuestion));
    }

    @Test
    public void testGetExercise() {
        String expectedOutput = String.format("Description: %s, Difficulty Level: %s, Completed: %s",
                exercise.getDescription(), exercise.getDifficultyLevel(), "No");
        assertEquals(expectedOutput, exercise.getExercise());
    }

    @Test
    public void testGetId() {
        assertNotNull(exercise.getId());
        assertTrue(exercise.getId() instanceof UUID);
    }

    @Test
    public void testGetDescription() {
        assertEquals("Sample Description", exercise.getDescription());
    }
}
