package com.backend;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Assessment {
    private String assessmentID;
    private UUID id;
    private String description;
    @SuppressWarnings("unused")
    private ArrayList<Proficiency> proficiencyLevels;  // List of possible proficiency levels
    private ArrayList<Question> exercises;        // List of questions in the assessment
    private String title;
    private int totalScore;

    public enum Proficiency {
        NOVICE,
        BEGINNER,
        COMPETENT,
        PROFICIENT,
        EXPERT
    }

    // Constructor
    public Assessment(String assessmentID, String title, String description) {
        this.assessmentID = assessmentID;
        this.proficiencyLevels = new ArrayList<>();
        this.exercises = new ArrayList<>();
        this.title = title;
        this.description = description;
        this.id = UUID.randomUUID();
        this.totalScore = generateRandomScore(0, 100);
    }

    private int generateRandomScore(int minimum, int maximum) {
        Random random = new Random();
        return random.nextInt(maximum - minimum + 1) + minimum; // Random value between minimum and maximum
    }

    // Method to give an assessment and return a proficiency level based on user's performance
    public int giveAssessment(String userID) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Starting Assessment: " + title);
        System.out.println("Description: " + description);
        System.out.println("Answer the following questions:\n");

        for (Question question : exercises) {
            System.out.println(question.getQuestionText());
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (question.checkAnswer(userAnswer)) {
                score++;
            }
        }

        System.out.println("\nAssessment complete! Your score: " + score + "/" + exercises.size());
        return score;
    }

    // Getters for assessment properties
    public String getAssessmentID() {
        return assessmentID;
    }

    public ArrayList<Question> getExercises() {
        return exercises;
    }

    public ArrayList<Proficiency> getProficiencyLevels() {
        return (ArrayList<Proficiency>) List.of(Proficiency.values());
    }

    public ArrayList<Question> getQuestions() {
        return new ArrayList<>(exercises);

    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
