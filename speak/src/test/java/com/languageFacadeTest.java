package com;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.Assessment;
import backend.Course;
import backend.Language;
import backend.LanguageFacade;
import backend.Lesson;
import backend.Notification;
import backend.Proficiency;
import backend.ProgressData;
import backend.User;
public class languageFacadeTest {

    private User user;
    private List<String> availableLanguages;
    private ArrayList<Assessment> assessments;
    private List<Course> courses;
    private static LanguageFacade instance;
    private ProgressData progressData;
    private User currentUser;
    private Course currentCourse;
    private List<String> topicVocabulary;
    private boolean notificationsIsUrgent;
    
    @Test
    public void LanguageFacade() {

    }
    @Test
    public void getInstance() {

    }
    @Test
    public User getCurrentUser() {
        return currentUser;
    }
    @Test
    public void setCurrentUser(User user) {

    }
    @Test
    public Course getCurrentCourse() {
        return currentCourse;
    }
    @Test
    public void setCurrentCourse(Course course) {

    }
    @Test
    public void registerUser(HashMap<String, String> userDetails) {

    }
    @Test
    public boolean loginUser(String username, String password) {
        System.out.println("User logged in: " + username);
        return true;
    }
    @Test
    public void updateUserProfile(UUID userID, HashMap<String, String> updatedDetails) {

    }
    @Test
    public void recoverPassword(String email) {

    }
    @Test
    public boolean startCourse(UUID userID, UUID courseId) {
        System.out.println("User ID: " + userID + " started course ID: " + courseId);
        return true;
    }
    @Test
    public boolean completeLesson(UUID userID, String lessonID) {
        System.out.println("User ID: " + userID + " completed lesson ID: " + lessonID);
        return true;
    }
    @Test
    public Course getCourseDetails(String courseID) {
        System.out.println("Retrieving details for course ID: " + courseID);
        Lesson lessonOne = new Lesson(UUID.randomUUID(), "CourseID1");
        Lesson lessonTwo = new Lesson(UUID.randomUUID(), "CourseID1");
        List<Lesson> lessons = new ArrayList<>();
        lessons.add(lessonOne);
        lessons.add(lessonTwo);
        return new Course(UUID.randomUUID(), Language.FRENCH, "title",lessons, "description", Proficiency.EXPERT);
    }
    @Test
    public ProgressData getUserProgress(String userID) {
        System.out.println("Retrieving progress for user ID: " + userID);
        return new ProgressData(userID);
    }
    @Test
    public void saveProgress(UUID userID, ProgressData progressData) {

    }
    @Test
    public void completeExercise(UUID userID, String exerciseID) {

    }
    @Test
    public String takeAssessment(UUID userID, String assessmentID) {
        System.out.println("User ID: " + userID + " taking assessment ID: " + assessmentID);
        return "Assessment result";
    }
    @Test
    public void submitFeedback(UUID userID, String feedbackText) {

    }
    @Test
    public List<Notification> getNotifications(UUID userID) {
        System.out.println("Retrieving notifications for user ID: " + userID);
        return new ArrayList<>();
    }
    @Test
    public void markNotificationAsRead(int notificationID) {

    }
    @Test
    public String lookupWordInDictionary(String word) {
        System.out.println("Looking up word: " + word);
        return "Definition of " + word;

    }
    @Test
    private Assessment getAssessmentById(UUID assessmentId) {
        for(Assessment assessment : assessments) {
            if(assessment.getId().equals(assessmentId)) {
                return assessment;
            }
        }
        return null;
    }
    
    @Test
    public boolean completeLesson(UUID userID, UUID lessonId) {
        System.out.println("User ID: " + userID + " completed lesson ID: " + lessonId);
        return true;
    }
}
