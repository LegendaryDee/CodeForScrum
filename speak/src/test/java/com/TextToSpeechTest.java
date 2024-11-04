package com;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.Audio;
import backend.TextToSpeech;

public class TextToSpeechTest {

    private TextToSpeech tts;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Starting TextToSpeechTest...");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Finished TextToSpeechTest.");
    }

    @Before
    public void setUp() {
        tts = new TextToSpeech();
        tts.text = "Hello, this is a test.";
    }

    @After
    public void tearDown() {
        tts = null;
    }

    @Test
    public void testConvertTextToAudio() {
        Audio audio = tts.convertTextToAudio(tts.text);
        assertNotNull(audio, "Audio object should not be null after conversion.");
    }

    @Test
    public void testSetSpeed() {
        tts.setSpeed(1.5f);
        assertEquals(1.5f, tts.speed, "Speed should be set to 1.5f");
    }

    @Test
    public void testTextProperty() {
        assertEquals("Hello, this is a test.", tts.text);
        tts.text = "New test text.";
        assertEquals("New test text.", tts.text);
    }
}
