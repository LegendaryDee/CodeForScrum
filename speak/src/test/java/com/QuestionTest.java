package com;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QuestionTest {

    private Question question;
    private List<String> answers;
    private List<String> choices;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Starting QuestionTest...");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Finished QuestionTest.");
    }

    @Before
    public void setUp() {
        answers = new ArrayList<>();
        answers.add("Answer 1");
        answers.add("Answer 2");

        choices = new ArrayList<>();
        choices.add("Choice A");
        choices.add("Choice B");
        choices.add("Choice C");
        choices.add("Choice D");

        question = new Question("What is the correct answer?", answers, 1, Question.QuestionType.MULTIPLE_CHOICE);
        question.choices = choices; // Set choices directly for testing
    }

    @After
    public void tearDown() {
        question = null;
        answers = null;
        choices = null;
    }

    @Test
    public void testGetQuestionID() {
        assertNotNull(question.getQuestionID(), "Question ID should not be null.");
    }

    @Test
    public void testGetQuestionText() {
        assertEquals("What is the correct answer?", question.getQuestionText());
    }

    @Test
    public void testGetChoices() {
        assertEquals(choices, question.getChoices());
    }

    @Test
    public void testGetAnswers() {
        assertEquals(answers, question.getAnswers());
    }

    @Test
    public void testGetCorrectAnswerIndex() {
        assertEquals(1, question.getCorrectAnswerIndex());
    }

    @Test
    public void testGetCorrectAnswer() {
        assertEquals("Answer 2", question.getCorrectAnswer());
    }

    @Test
    public void testCheckAnswerCorrect() {
        assertTrue(question.checkAnswer("Choice B"));
    }

    @Test
    public void testCheckAnswerIncorrect() {
        assertFalse(question.checkAnswer("Choice A"));
    }

    @Test
    public void testGetQuestionType() {
        assertEquals(Question.QuestionType.MULTIPLE_CHOICE, question.getQuestionType());
    }
}
