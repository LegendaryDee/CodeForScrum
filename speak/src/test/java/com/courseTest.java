package com;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.Language;
import backend.Lesson;
import backend.Proficiency;
import backend.Topic;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

public class courseTest {

    private UUID id;
    private String title;
    private String description;
    private ArrayList<Lesson> lessons;
    private ArrayList<Topic> topics;
    private Proficiency proficiency;
    private int score;
    private int currentLessonIndex = 0;
    private Language selectedLanguage;

    @Test
    public void Course(UUID id, Language selectedLanguage, String title, String lesson, String description, Proficiency proficiency) {

    }
    @Test
    public void Course(UUID id, String title, String description) {

    }
    @Test
    public void startLesson() {

    }
    @Test
    public void completeLesson() {

    }
    @Test
    public void saveProgress(int userID) {

    }
    @Test
    public void revisitSavedProgress(int userID) {

    }
    @Test
    public void addTopic(Topic topic) {

    }
    @Test
    public void setScore(int score) {

    }
    @Test
    public int getScore() {
        return score;
    }
    @Test
    public ArrayList<Topic> getTopics() {
        return topics;
    }
    @Test
    public String getTitle() {
        return title;

    }
    @Test
    public void addLesson(Lesson lesson) {

    }
    @Test
    public ArrayList<Lesson> getLessons() {
        return lessons;
    }
    @Test
    public String getCoursesJson() {
        StringBuilder json = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader("courses.json"))) {
            String line;
            while((line = reader.readLine()) != null) {
                json.append(line);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        return json.toString();
    }       
            @Test
            public Lesson getSpotInCourse(UUID lessonId) {
                for(Lesson lesson: lessons) {
                    if(lesson.getId().equals(lessonId)) {
                        return lesson;
                    }
                }
                return null;
            }
    
    @Test
    public String getDescription() {
        return description;

    }
    @Test
    public Language getLanguage() {
        return selectedLanguage;
    }
    @Test
    public Proficiency getProficiency() {
        return proficiency;
    }
    @Test
    public UUID getId() {
        return id;
    }
    @Test
    public UUID getCourseID() {
        return id;
    }
}
