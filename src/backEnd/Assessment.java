package backEnd;

import java.util.ArrayList;
import java.util.Random;

public class Assessment {
    private String assessmentID;
    private ArrayList<String> proficiencyLevels;  // List of possible proficiency levels
    private ArrayList<Question> questions;        // List of questions in the assessment
    private String title;
    private int totalScore;

    // Constructor
    public Assessment(String assessmentID, ArrayList<String> proficiencyLevels, ArrayList<Question> questions, String title) {
        this.assessmentID = assessmentID;
        this.proficiencyLevels = proficiencyLevels;
        this.questions = questions;
        this.title = title;
        this.totalScore = generateRandomScore(0, 100);
    }

    private int generateRandomScore(int minimum, int maximum) {
        Random random = new Random();
        return random.nextInt(maximum - minimum + 1) + minimum; // Random value between minimum and maximum
    }

    // Method to give an assessment and return a proficiency level based on user's performance
    public String giveAssessment(String userID) {
        // Logic for giving an assessment
        System.out.println("Giving assessment to user: " + userID);

        // Placeholder logic for determining proficiency level based on the assessment (for now, returning first level)
        return proficiencyLevels.get(0);
    }

    // Getters for assessment properties
    public String getAssessmentID() {
        return assessmentID;
    }

    public ArrayList<String> getProficiencyLevels() {
        return proficiencyLevels;
    }

    public ArrayList<Question> getQuestions() {
        return questions;

    }

    public String getTitle() {
        return title;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
