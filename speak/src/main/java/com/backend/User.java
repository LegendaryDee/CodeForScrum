package com.backend;

import java.util.UUID;
import java.util.ArrayList;

public class User {
    private UUID userID;
    private String userName;
    private String password;
    private String email;
    private LanguagePreference languagePreference;
    private ProgressData progressData;
    private int streakCount;
    private ArrayList<Integer> scores;
    private UUID courseID;
    
    public User(String userID2, String userName2, String password2, String email2, String languagePreference2, int lessonsCompleted, int attempts, int score, int streakCount2){

    }

    // Constructor
    public User(UUID userID, String userName, String password, String email, LanguagePreference languagePreference, ProgressData progressData, int streakCount) {
        this.userID = UUID.randomUUID();
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.languagePreference = languagePreference;
        this.streakCount = streakCount;
        this.progressData = progressData;
        this.scores = new ArrayList<>();
    }

    public User(UUID randomUUID, String guestName, String string, String string2, String string3) {
        //TODO Auto-generated constructor stub
    }

    public String getUserName() {
        return this.userName;
    }

    public void register() {
        System.out.println(userName + " has been registered.");
    }

    public void login() {
        System.out.println(userName + " has logged in.");
    }

    public boolean login(String inputUsername, String inputPassword) {
        // Logic to check username and password
        if(inputUsername.equals(this.userName) && inputPassword.equals(this.password)) {
            System.out.println("Login successful.");
            return true;
        }
        System.out.println("Login failed.");
        return false;
    }

    public void logout() {
        System.out.println(userName + " has logged out.");
    }

    public void updateProfile(String userName, String email, LanguagePreference languagePreference, int streakCount, ProgressData progressData) {
        this.userName = userName;
        this.email = email;
        this.languagePreference = languagePreference;
        this.progressData = new ProgressData(userName);
        this.streakCount = streakCount;
        System.out.println("Profile updated for " + this.userName);
    }

    public void recoverPassword() {
        System.out.println("Password recovery initiated for " + userName);
    }

    public void submitFeedBack(String feedbackText) {
        System.out.println("Feedback submitted: " + feedbackText);
    }

    public void addScore(int score) {
        scores.add(score);
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
        ", languagePreference= " + languagePreference + ", streakCount=" + streakCount + ", progressData=" + progressData + '}';
    }

    public String getProficiencyLevels() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProficiencyLevels'");
    }
}

enum LanguagePreference {
    ENGLISH, SPANISH, FRENCH, GERMAN
}
