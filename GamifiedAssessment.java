import java.util.List;

public class GamifiedAssessment {
    private String assessmentID;
    public List<Question> questions;
    private int score;
    private int currentLevel;
    private int totalLevels;
    private int timeLimit; // in seconds

    // Constructor
    public GamifiedAssessment(String assessmentID, List<Question> questions, int totalLevels, int timeLimit) {
        this.assessmentID = assessmentID;
        this.questions = questions;
        this.score = 0;
        this.currentLevel = 1; // Starting at level 1
        this.totalLevels = totalLevels;
        this.timeLimit = timeLimit; // Example: time limit per level
    }

    // Start the assessment
    public void startAssessment() {
        System.out.println("Assessment " + assessmentID + " started!");
        // Logic to start assessment timer, present questions, etc.
    }

    // Submit an answer to a question and update score
    public boolean submitAnswer(Question question, String answer) {
        if (question.checkAnswer(answer)) {
            this.score += 10; // Assume each correct answer adds 10 points
            return true;
        }
        return false;
    }

    // Move to the next level
    public void nextLevel() {
        if (currentLevel < totalLevels) {
            currentLevel++;
            System.out.println("Level " + currentLevel + " started.");
            // Load the next set of questions or increase difficulty, etc.
        } else {
            System.out.println("You've completed all levels!");
            endAssessment();
        }
    }

    // End the assessment
    public void endAssessment() {
        System.out.println("Assessment completed! Final Score: " + score);
        // Logic for wrapping up assessment, saving results, and giving feedback
    }

    // Get current score
    public int getScore() {
        return score;
    }

    // Get current level
    public int getCurrentLevel() {
        return currentLevel;
    }

    // Get remaining levels
    public int getRemainingLevels() {
        return totalLevels - currentLevel;
    }

    // Get time limit
    public int getTimeLimit() {
        return timeLimit;
    }
}
