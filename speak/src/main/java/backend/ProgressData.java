package backend;

import java.util.ArrayList;
import java.util.Locale.Category;
import java.util.UUID;
import java.util.List;


public class ProgressData {
    public int lessonsCompleted;
    public int attempts;
    public int totalScore;
    private ArrayList<Integer> individualScores;
    private String userID;
    private int currentModule;
    private String currentCourseID;
    private UUID currentLessonID;
    private int CourseCompletionPercentage;
    private List<String> strugglingWords;
    private List<String> strugglingPhrases;

    public ProgressData(String userID) {// use arrayList of progressData objects
        this.userID = userID;
        this.lessonsCompleted = 0;
        this.attempts = 0;
        this.totalScore = 0;
        this.individualScores = new ArrayList<>();
        this.currentModule = 1;
        this.currentCourseID = currentCourseID;
        this.currentLessonID = null;
        this.CourseCompletionPercentage = 0;
        this.strugglingWords = new ArrayList<>();
        this.strugglingPhrases = new ArrayList<>();
    }

    public ProgressData getCurrentProgress(String userID) {
        System.out.println("Retrieving current progress for user ID: " + userID);
        return this;
    }

   

    
    public void updateProgress(int lessonsCompleted, int attempts, int totalScore) {
        this.lessonsCompleted += lessonsCompleted;
        this.attempts += attempts;
        this.totalScore += totalScore;
        System.out.println("Progress updated for user ID: " + userID);
    }

    public void trackProgress() {
        System.out.println("Tracking progress for user ID: " + userID);
    }

    public void saveProgress() {
        System.out.println("Progress saved for user ID: " + userID);
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

    public String getUserID() {
        return userID;
    }

   

    public String toString() {
        return String.format("ProgressData{userID = '%s', lessonsCompleted = %d, attempts = %d, totalScore = %d}", userID, lessonsCompleted, attempts, totalScore);
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

    // Getter for currentCourseID
    public String getCurrentCourseID() {
        return currentCourseID;
    }

    // Setter for currentCourseID
    public void setCurrentCourseID(String currentCourseID) {
        this.currentCourseID = currentCourseID;
    }

    public int getCurrentModule() {
        return currentModule;
    }

    public void setCurrentModule(int currentModule) {
        this.currentModule = currentModule;
    }

    public void currentCourseID(String currentCourseID) {
        this.currentCourseID = currentCourseID;
    }

    // Other getters and setters...
    
    public UUID getCurrentLessonID() {
        return currentLessonID;
    }

    public void setCurrentLessonID(UUID lessonID) {
        this.currentLessonID = lessonID;
    }

    public int getCourseCompletionPercentage() {
        return CourseCompletionPercentage;
    }

    public void setCourseCompletionPercentage(int percentage) {
        this.CourseCompletionPercentage = percentage;
    }

    public List<String> getStrugglingWords() {
        return strugglingWords;
    }

    public List<String> getStrugglingPhrases() {
        return strugglingPhrases;
    }
}

