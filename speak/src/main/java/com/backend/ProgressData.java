package com.backend;

import java.util.ArrayList;
import java.util.Locale.Category;
import java.util.UUID;

public class ProgressData {
    public int lessonsCompleted;
    public int attempts;
    public int totalScore;
    private ArrayList<Integer> individualScores;
    public String userId;

    
    public ProgressData() {// use arrayList of progressData objects
        this.lessonsCompleted = 0;
        this.attempts = 0;
        this.totalScore = 0;
        this.individualScores = new ArrayList<>();
    }
    
    public ProgressData(String userId, int lessonsCompleted, int attempts, int score) {// use arrayList of progressData objects
        this.userId = userId;
        this.lessonsCompleted = lessonsCompleted;
        this.attempts = attempts;
        this.totalScore = score;
        this.individualScores = new ArrayList<>();
    }
    
    public ProgressData(String userID) {// use arrayList of progressData objects
        this.userId = userID;
        this.lessonsCompleted = 0;
        this.attempts = 0;
        this.totalScore = 0;
        this.individualScores = new ArrayList<>();
    }

    public ProgressData getCurrentProgress(String userID) {
        System.out.println("Retrieving current progress for user ID: " + userID);
        return this;
    }

    public void updateProgress(int lessonsCompleted, int attempts, int totalScore) {
        this.lessonsCompleted += lessonsCompleted;
        this.attempts += attempts;
        this.totalScore += totalScore;
        System.out.println("Progress updated for user ID: " + userId);
    }

    public void trackProgress() {
        System.out.println("Tracking progress for user ID: " + userId);
    }

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void saveProgress() {
        System.out.println("Progress saved for user ID: " + userId);
    }

    public void addScore(int score) {
        individualScores.add(score);
        totalScore += score;
        lessonsCompleted++;
    }

    public int getLessonsCompleted() {
        return lessonsCompleted;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public double getAverageScore() {
        return lessonsCompleted > 0 ? (double) totalScore / lessonsCompleted : 0;
    }
    

    public String toString() {
        return String.format("ProgressData{userID = '%s', lessonsCompleted = %d, attempts = %d, totalScore = %d}", userId, lessonsCompleted, attempts, totalScore);
    }

    public void setTotalQuestionsAnswered(int totalQuestionsAnswered) {
    }

    public void setNumCorrectAnswers(int numCorrectAnswers) {
    }

    public void setCurrentCategory(Category currentCategory) {
    }

    public void setProgressInCategory(int progressInCategory) {
    }

    public void setMissedWords(ArrayList<String> result) {
    }

    public void setCurrentCourseID(UUID courseID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCurrentCourseID'");
    }
}
