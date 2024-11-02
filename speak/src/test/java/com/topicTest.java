package com;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.Assessment;
import backend.Exercise;
import backend.Lesson;

public class topicTest {
        private UUID id;
    private ArrayList<Lesson> lessons;
    private ArrayList<Exercise> exercises;
    private Assessment assessment;
    private String title;
    private String content;

     public void Topic() {

    }
    @Test
    public void addLesson() {

    }
    @Test
    public void addExercise() {

    }
    @Test
    public void setAssessment() {

    }
    @Test
    public UUID getId() {
        return id;
    }
    @Test
    public ArrayList<Exercise> getExercises() {
        return exercises;
    }
    @Test
    public Assessment getAssessment() {
        return assessment;
    }
    @Test
    public String getTitle() {
        return title;
    }
}
