package backend;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProgressDataTest {

    private ProgressData progressData;
    private String userID = "user123";

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Starting ProgressDataTest...");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Finished ProgressDataTest.");
    }

    @Before
    public void setUp() {
        progressData = new ProgressData(userID);
    }

    @After
    public void tearDown() {
        progressData = null;
    }

    @Test
    public void testGetCurrentProgress() {
        assertEquals(progressData, progressData.getCurrentProgress(userID));
    }

    @Test
    public void testUpdateProgress() {
        progressData.updateProgress(5, 3, 50);
        assertEquals(5, progressData.getLessonsCompleted());
        assertEquals(3, progressData.getAttempts());
        assertEquals(50, progressData.getTotalScore());
    }

    @Test
    public void testAddScore() {
        progressData.addScore(30);
        assertEquals(30, progressData.getTotalScore());
        assertEquals(1, progressData.getLessonsCompleted());
    }

    @Test
    public void testGetAverageScore() {
        progressData.addScore(50);
        progressData.addScore(30);
        assertEquals(40.0, progressData.getAverageScore(), 0.01);
    }

    @Test
    public void testSetAndGetCourseCompletionPercentage() {
        progressData.setCourseCompletionPercentage(75);
        assertEquals(75, progressData.getCourseCompletionPercentage());
    }

    @Test
    public void testSetAndGetCurrentCourseID() {
        String courseID = "courseABC";
        progressData.setCurrentCourseID(courseID);
        assertEquals(courseID, progressData.getCurrentCourseID());
    }

    @Test
    public void testSetAndGetCurrentModule() {
        progressData.setCurrentModule(3);
        assertEquals(3, progressData.getCurrentModule());
    }

    @Test
    public void testSetAndGetCurrentLessonID() {
        UUID lessonID = UUID.randomUUID();
        progressData.setCurrentLessonID(lessonID);
        assertEquals(lessonID, progressData.getCurrentLessonID());
    }

    @Test
    public void testStrugglingWordsAndPhrases() {
        List<String> words = new ArrayList<>();
        words.add("difficult");
        List<String> phrases = new ArrayList<>();
        phrases.add("hard phrase");

        progressData.getStrugglingWords().addAll(words);
        progressData.getStrugglingPhrases().addAll(phrases);

        assertEquals(words, progressData.getStrugglingWords());
        assertEquals(phrases, progressData.getStrugglingPhrases());
    }

    @Test
    public void testToString() {
        String expected = "ProgressData{userID = 'user123', lessonsCompleted = 0, attempts = 0, totalScore = 0}";
        assertEquals(expected, progressData.toString());
    }
}
