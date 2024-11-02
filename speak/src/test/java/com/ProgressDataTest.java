package com;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import backend.ProgressData;

import java.util.ArrayList;
import java.util.UUID;

public class ProgressDataTest {

    private ProgressData progressData;

    @BeforeEach
    public void setUp() {
        progressData = new ProgressData("testUserID");
    }

    @Test
    public void testInitialization() {
        assertEquals(0, progressData.getLessonsCompleted(), "Initial lessonsCompleted should be 0");
        assertEquals(0, progressData.getAttempts(), "Initial attempts should be 0");
        assertEquals(0, progressData.getTotalScore(), "Initial totalScore should be 0");
        assertEquals("testUserID", progressData.getUserID(), "UserID should match the initialization value");
    }

    @Test
    public void testUpdateProgress() {
        progressData.updateProgress(5, 10, 200);
        assertEquals(5, progressData.getLessonsCompleted(), "LessonsCompleted should update correctly");
        assertEquals(10, progressData.getAttempts(), "Attempts should update correctly");
        assertEquals(200, progressData.getTotalScore(), "TotalScore should update correctly");
    }

    @Test
    public void testAddScore() {
        progressData.addScore(80);
        assertEquals(80, progressData.getTotalScore(), "TotalScore should update with added score");
        assertEquals(1, progressData.getLessonsCompleted(), "LessonsCompleted should increment with each score added");

        progressData.addScore(90);
        assertEquals(170, progressData.getTotalScore(), "TotalScore should accumulate with multiple scores");
        assertEquals(2, progressData.getLessonsCompleted(), "LessonsCompleted should reflect number of scores added");
    }

    @Test
    public void testGetAverageScore() {
        progressData.addScore(50);
        progressData.addScore(100);
        assertEquals(75, progressData.getAverageScore(), "Average score should be calculated correctly");

        progressData.addScore(150);
        assertEquals(100, progressData.getAverageScore(), "Average score should update with new scores");
    }

    @Test
    public void testCurrentCourseID() {
        String courseID = "course123";
        progressData.setCurrentCourseID(courseID);
        assertEquals(courseID, progressData.getCurrentCourseID(), "CurrentCourseID should set and return correctly");
    }

    @Test
    public void testCourseCompletionPercentage() {
        progressData.setCourseCompletionPercentage(85);
        assertEquals(85, progressData.getCourseCompletionPercentage(), "CourseCompletionPercentage should be set and retrieved correctly");
    }

    @Test
    public void testStrugglingWordsAndPhrases() {
        ArrayList<String> strugglingWords = new ArrayList<>();
        strugglingWords.add("word1");
        strugglingWords.add("word2");
        progressData.getStrugglingWords().addAll(strugglingWords);

        ArrayList<String> strugglingPhrases = new ArrayList<>();
        strugglingPhrases.add("phrase1");
        strugglingPhrases.add("phrase2");
        progressData.getStrugglingPhrases().addAll(strugglingPhrases);

        assertTrue(progressData.getStrugglingWords().contains("word1"), "StrugglingWords should include 'word1'");
        assertTrue(progressData.getStrugglingWords().contains("word2"), "StrugglingWords should include 'word2'");
        assertTrue(progressData.getStrugglingPhrases().contains("phrase1"), "StrugglingPhrases should include 'phrase1'");
        assertTrue(progressData.getStrugglingPhrases().contains("phrase2"), "StrugglingPhrases should include 'phrase2'");
    }

    @Test
    public void testCurrentModule() {
        progressData.setCurrentModule(3);
        assertEquals(3, progressData.getCurrentModule(), "CurrentModule should be set and retrieved correctly");
    }

    @Test
    public void testCurrentLessonID() {
        UUID lessonID = UUID.randomUUID();
        progressData.setCurrentLessonID(lessonID);
        assertEquals(lessonID, progressData.getCurrentLessonID(), "CurrentLessonID should set and retrieve correctly");
    }

    @Test
    public void testToString() {
        String progressString = progressData.toString();
        assertTrue(progressString.contains("userID = 'testUserID'"), "toString should contain userID");
        assertTrue(progressString.contains("lessonsCompleted = 0"), "toString should contain lessonsCompleted");
        assertTrue(progressString.contains("totalScore = 0"), "toString should contain totalScore");
    }
}
