package com;


import backend.Lesson;
import backend.Topic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class LessonTest {

    private Lesson lessonWithID;
    private Lesson lessonWithoutID;
    private UUID lessonID;
    private String title;
    private String content;
    private int duration;
    private ArrayList<Topic> topics;

    @BeforeEach
    public void setUp() {
        lessonID = UUID.randomUUID();
        title = "Introduction to Java";
        content = "Java is a high-level programming language...";
        duration = 45;
        topics = new ArrayList<>();

        lessonWithID = new Lesson(lessonID, title, content, duration);
        lessonWithoutID = new Lesson("Advanced Java", "Exploring advanced Java concepts...");
    }

    @Test
    public void testStartLesson() {
        lessonWithID.startLesson();
        System.out.println("Lesson started: " + lessonWithID.getTitle());
    }

    @Test
    public void testCompleteLesson() {
        lessonWithID.completeLesson();
        System.out.println("Lesson completed: " + lessonWithID.getTitle());
    }

    @Test
    public void testGetTitle() {
        assertEquals("Introduction to Java", lessonWithID.getTitle());
        assertEquals("Advanced Java", lessonWithoutID.getTitle());
        System.out.println("Lesson titles retrieved successfully.");
    }

    @Test
    public void testGetContent() {
        assertEquals("Java is a high-level programming language...", lessonWithID.getContent());
        assertEquals("Exploring advanced Java concepts...", lessonWithoutID.getContent());
        System.out.println("Lesson contents retrieved successfully.");
    }

    @Test
    public void testGetTopics() {
        assertNull(lessonWithID.getTopics());  // Assuming topics are initialized as null by default
        System.out.println("Topics list retrieved and verified as null.");
    }

    @Test
    public void testGetId() {
        assertNotNull(lessonWithID.getId());
        System.out.println("Lesson ID retrieved: " + lessonWithID.getId());
    }

    @Test
    public void testGetDuration() {
        assertEquals(45, lessonWithID.getDuration());
        System.out.println("Lesson duration retrieved: " + lessonWithID.getDuration());
    }

    @Test
    public void testGetLessonID() {
        assertEquals(lessonID.toString(), lessonWithID.getLessonID());
        System.out.println("Lesson ID retrieved and matched: " + lessonWithID.getLessonID());
    }

    @Test
    public void testToString() {
        String expectedString = "Lesson{id=" + lessonWithID.getId() + ", title='" + title + "', content='" + content + "', duration=" + duration + '}';
        assertEquals(expectedString, lessonWithID.toString());
        System.out.println("Lesson toString output verified.");
    }
}
