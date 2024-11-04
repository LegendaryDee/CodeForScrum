package com;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.Flashcards;

public class FlashcardsTest {

    private Flashcards flashcard;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Starting FlashcardsTest...");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Finished FlashcardsTest.");
    }

    @Before
    public void setUp() {
        flashcard = new Flashcards("Bonjour", "Hello", "Bonjour! Je m'appelle Pierre.");
    }

    @After
    public void tearDown() {
        flashcard = null;
    }

    @Test
    public void testGetWord() {
        assertEquals("Bonjour", flashcard.getWord());
    }

    @Test
    public void testSetWord() {
        flashcard.setWord("Salut");
        assertEquals("Salut", flashcard.getWord());
    }

    @Test
    public void testGetTranslation() {
        assertEquals("Hello", flashcard.getTranslation());
    }

    @Test
    public void testSetTranslation() {
        flashcard.setTranslation("Hi");
        assertEquals("Hi", flashcard.getTranslation());
    }

    @Test
    public void testGetPhrase() {
        assertEquals("Bonjour! Je m'appelle Pierre.", flashcard.getPhrase());
    }

    @Test
    public void testSetPhrase() {
        flashcard.setPhrase("Salut! Je m'appelle Pierre.");
        assertEquals("Salut! Je m'appelle Pierre.", flashcard.getPhrase());
    }

    @Test
    public void testToString() {
        String expected = "Flashcard{Word='Bonjour', Translation='Hello', Example Phrase='Bonjour! Je m'appelle Pierre.'}";
        assertEquals(expected, flashcard.toString());
    }

    @Test
    public void testShowFlashcard() {
        flashcard.showFlashcard();
        // Verify output manually or assume successful if no exceptions are thrown.
    }
}
