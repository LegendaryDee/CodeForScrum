package com.backend;

import java.util.List;
import java.util.UUID;

/**
 * Represents a question in a language learning course.
 */
public class Question {
    private UUID questionID;
    private String questionText;
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
    public Question(UUID questionID, String questionText, List<String> choices, int correctAnswerIndex) {
        this.questionID = questionID;
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswerIndex = correctAnswerIndex;
        
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

    // Getter for correctAnswerIndex
    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    // Getter for questionType
    public QuestionType getQuestionType() {
        return questionType;
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

    public char[] getText() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getText'");
    }
}

