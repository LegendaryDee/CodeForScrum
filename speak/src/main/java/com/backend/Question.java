package com.backend;

import java.util.List;
import java.util.UUID;

import org.json.simple.JSONArray;

/**
 * Represents a question in a language learning course.
 */
public class Question {
    private UUID questionID;
    private String questionText;
    private List<String> answers;
    private List<String> choices;
    private int correctAnswerIndex;
    private QuestionType questionType;

    // Enum to define the types of questions
    public enum QuestionType {
        MULTIPLE_CHOICE,
        FILL_IN_THE_BLANK,
        TRUE_FALSE,
        PRONUNCIATION
    }

    // Constructor
    public Question(String questionText, List<String> answers, int correctAnswerIndex, com.backend.QuestionType fillInTheBlank) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public Question(UUID randomUUID, String questionFromJson, JSONArray flashcardList, int i) {
       
    }

    // Getter for questionID
    public UUID getQuestionID() {
        return questionID;
    }

    // Getter for questionText
    public String getQuestionText() {
        return questionText;
    }

    // Getter for choices
    public List<String> getChoices() {
        return choices;
    }

    public List<String> getAnswers() {
        return answers;
    }

    // Getter for correctAnswerIndex
    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    // Getter for questionType
    public QuestionType getQuestionType() {
        return questionType;
    }

    public String getCorrectAnswer() {
        return answers.get(correctAnswerIndex);
    }

    // Check if the provided answer is correct
    public boolean checkAnswer(String answer) {
        // Compare the provided answer to the correct answer using the index
        if (correctAnswerIndex >= 0 && correctAnswerIndex < choices.size()) {
            String correctAnswer = choices.get(correctAnswerIndex);
            return correctAnswer.equalsIgnoreCase(answer);
        }
        return false;
    }
}

