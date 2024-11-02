package com;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

import backend.Proficiency;
import backend.Question;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class assessmentTest {
    
    private String assessmentID;
    private UUID id;
    private String description;
    @SuppressWarnings("unused")
    private ArrayList<Proficiency> proficiencyLevels;  // List of possible proficiency levels
    private ArrayList<Question> exercises;        // List of questions in the assessment
    private String title;
    private int totalScore;

    @Test
    public void Assessment(String assessmentID, String title, String description) {

    }
    @Test
    private int generateRandomScore(int minimum, int maximum) {
        Random random = new Random();
        return random.nextInt(maximum - minimum + 1) + minimum;
    }
    @Test
    public int giveAssessment(String userID) {
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
    @Test
    public String getAssessmentID() {
        return assessmentID;
    }
    @Test
    public ArrayList<Question> getExercises() {
        return exercises;
    }
    @Test
    public ArrayList<Proficiency> getProficiencyLevels() {
        return (ArrayList<Proficiency>) List.of(Proficiency.values());
    }
    @Test
    public ArrayList<Question> getQuestions() {
        return new ArrayList<>(exercises);

    }
    @Test
    public UUID getId() {
        return id;
    }
    @Test
    public String getTitle() {
        return title;
    }
    @Test
    public int getTotalScore() {
        return totalScore;
    }
}
