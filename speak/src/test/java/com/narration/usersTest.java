package com.narration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Test;

import backend.Course;
import backend.LanguagePreference;
import backend.ProgressData;


public class usersTest {
    private UUID userID;
    private String userName;
    private String password;
    private String email;
    private LanguagePreference languagePreference;
    private ProgressData progressData;
    private int streakCount;
    private ArrayList<Integer> scores;
    @SuppressWarnings("unused")
    private UUID courseID;
    private List<Course> courses;
    private List<Module> modules;
    

    
    public usersTest(UUID userID, String userName, String password, String email, LanguagePreference languagePreference, ProgressData progressData, List<Course> courses, int streakCount) {
        this.userID = UUID.randomUUID();
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.languagePreference = languagePreference;
        this.streakCount = streakCount;
        this.progressData = progressData;
        this.courses = courses;
        this.scores = new ArrayList<>();
        this.modules = new ArrayList<>();
    }

    @Test
    public String getUserName() {
        return this.userName;
    }

    @Test
    public void register() {
        System.out.println(userName + " has been registered.");
    }

    @Test
    public void login() {
        System.out.println(userName + " has logged in.");
    }

    @Test
    public boolean login(String inputUsername, String inputPassword) {
        // Logic to check username and password
        if(inputUsername.equals(this.userName) && inputPassword.equals(this.password)) {
            System.out.println("Login successful.");
            return true;
        }
        System.out.println("Login failed.");
        return false;
    }

    @Test
    public void logout() {
        System.out.println(userName + " has logged out.");
    }

    @Test
    public void updateProfile(String userName, String email, LanguagePreference languagePreference, int streakCount, ProgressData progressData) {
        this.userName = userName;
        this.email = email;
        this.languagePreference = languagePreference;
        this.progressData = new ProgressData(userName);
        this.streakCount = streakCount;
        System.out.println("Profile updated for " + this.userName);
    }
    
    @Test
    public void recoverPassword() {
        System.out.println("Password recovery initiated for " + userName);
    }

    @Test
    public void submitFeedBack(String feedbackText) {
        System.out.println("Feedback submitted: " + feedbackText);
    }

    @Test
    public void addModule(Module module) {
        modules.add(module);
    }

    @Test
    public void addScore(int score) {
        scores.add(score);
    }

    public List<Module> getModules() {
        return modules;
    }

    public int getTotalScore() {
        int total = 0;
        for(int score : scores) {
            total += score;
        }
        return total;
    }

    public UUID getId() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public ProgressData getProgressData() {
        return progressData;
    }

    public LanguagePreference getLanguagePreference() {
        return languagePreference;
    }

    public int getStreakCount() {
        return streakCount;
    }

    public String toString() {
        return "User: " + "userID= " + userID + ", userName= '" + userName + '\'' + ", email= '" + email + '\'' + 
        ", languagePreference= " + languagePreference + ", streakCount=" + streakCount + ", progressData=" + progressData + ", modules=" + modules + '}';
    }

    public String getProficiencyLevels() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getProficiencyLevels'");
    }
}
