package com;

import backend.Question;
import backend.VocabExercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class VocabExerciseTest {

    private VocabExercise vocabExercise;
    private String exerciseId;
    private String type;
    private String difficulty;
    private String content;
    private ArrayList<Question> questions;
    private ArrayList<String> vocabularyList;
    private ArrayList<String> definitions;

    @BeforeEach
    public void setUp() {
        exerciseId = "vocab001";
        type = "Vocabulary";
        difficulty = "Easy";
        content = "Match the words with their meanings";
        questions = new ArrayList<>();

        vocabularyList = new ArrayList<>();
        vocabularyList.add("Loquacious");
        vocabularyList.add("Ephemeral");

        definitions = new ArrayList<>();
        definitions.add("Talkative");
        definitions.add("Short-lived");

        vocabExercise = new VocabExercise(exerciseId, type, difficulty, content, questions, vocabularyList, definitions);
    }

    @Test
    public void testDisplayVocabulary() {
        System.out.println("Displaying vocabulary and definitions:");
        vocabExercise.displayVocabulary();
        System.out.println("Vocabulary displayed successfully.");
    }

    @Test
    public void testGetVocabularyList() {
        assertEquals(vocabularyList, vocabExercise.getVocabularyList());
        System.out.println("Vocabulary list retrieved and validated.");
    }

    @Test
    public void testSetVocabularyList() {
        ArrayList<String> newVocabularyList = new ArrayList<>();
        newVocabularyList.add("Serendipity");
        vocabExercise.setVocabularyList(newVocabularyList);
        assertEquals(newVocabularyList, vocabExercise.getVocabularyList());
        System.out.println("Vocabulary list set and validated.");
    }

    @Test
    public void testGetDefinitions() {
        assertEquals(definitions, vocabExercise.getDefinitions());
        System.out.println("Definitions list retrieved and validated.");
    }

    @Test
    public void testSetDefinitions() {
        ArrayList<String> newDefinitions = new ArrayList<>();
        newDefinitions.add("Finding something good without looking for it");
        vocabExercise.setDefinitions(newDefinitions);
        assertEquals(newDefinitions, vocabExercise.getDefinitions());
        System.out.println("Definitions list set and validated.");
    }

    @Test
    public void testExerciseAttributes() {
        
    }
}
