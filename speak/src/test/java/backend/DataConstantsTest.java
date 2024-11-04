package backend;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DataConstantsTest {

    @Test
    public void testFilePaths() {
        assertEquals("path/to/users.json", DataConstants.USER_FILE_NAME,
                "USER_FILE_NAME constant should match expected value.");
        assertEquals("path/to/courses.json", DataConstants.COURSE_FILE_NAME,
                "COURSE_FILE_NAME constant should match expected value.");
        assertEquals("path/to/progressData.json", DataConstants.PROGRESS_DATA_FILE_NAME,
                "PROGRESS_DATA_FILE_NAME constant should match expected value.");

        // Verify resource file paths
        assertEquals("src/main/resources/exercises.json", DataConstants.FILE_NAME_FLASHCARDS,
                "FILE_NAME_FLASHCARDS should match expected path.");
        assertEquals("src/main/resources/exercises.json", DataConstants.FILE_NAME_QUESTIONS,
                "FILE_NAME_QUESTIONS should match expected path.");
        assertEquals("src/main/resources/progressData.json", DataConstants.FILE_NAME_PROGRESS,
                "FILE_NAME_PROGRESS should match expected path.");
        assertEquals("src/main/resources/courses.json", DataConstants.FILE_NAME_COURSES,
                "FILE_NAME_COURSES should match expected path.");
        assertEquals("src/main/resources/users.json", DataConstants.FILE_NAME_USERS,
                "FILE_NAME_USERS should match expected path.");
    }

    @Test
    public void testUserAttributes() {
        assertEquals("userID", DataConstants.USER_ID, "USER_ID constant should match expected value.");
        assertEquals("userName", DataConstants.USER_NAME, "USER_NAME constant should match expected value.");
        assertEquals("password", DataConstants.USER_PASSWORD, "USER_PASSWORD constant should match expected value.");
        assertEquals("email", DataConstants.USER_EMAIL, "USER_EMAIL constant should match expected value.");
        assertEquals("languagePreference", DataConstants.USER_LANGUAGE_PREFERENCE,
                "USER_LANGUAGE_PREFERENCE constant should match expected value.");
        assertEquals("streakCount", DataConstants.USER_STREAK_COUNT,
                "USER_STREAK_COUNT constant should match expected value.");
        assertEquals("progressData", DataConstants.USER_PROGRESS_DATA,
                "USER_PROGRESS_DATA constant should match expected value.");
        assertEquals("lessonsCompleted", DataConstants.USER_LESSONS_COMPLETED,
                "USER_LESSONS_COMPLETED constant should match expected value.");
        assertEquals("attempts", DataConstants.USER_ATTEMPTS, "USER_ATTEMPTS constant should match expected value.");
        assertEquals("score", DataConstants.USER_SCORE, "USER_SCORE constant should match expected value.");
    }

    @Test
    public void testCourseAttributes() {
        assertEquals("courseID", DataConstants.COURSE_ID, "COURSE_ID constant should match expected value.");
        assertEquals("topicVocabulary", DataConstants.COURSE_TOPIC_VOCABULARY,
                "COURSE_TOPIC_VOCABULARY constant should match expected value.");
        assertEquals("listeningSection", DataConstants.COURSE_LISTENING_SECTION,
                "COURSE_LISTENING_SECTION constant should match expected value.");
        assertEquals("gamifiedAssessment", DataConstants.COURSE_GAMIFIED_ASSESSMENT,
                "COURSE_GAMIFIED_ASSESSMENT constant should match expected value.");
    }

    @Test
    public void testProgressAttributes() {
        assertEquals("userID", DataConstants.PROGRESS_USER_ID,
                "PROGRESS_USER_ID constant should match expected value.");
        assertEquals("lessonsCompleted", DataConstants.PROGRESS_LESSONS_COMPLETED,
                "PROGRESS_LESSONS_COMPLETED constant should match expected value.");
        assertEquals("attempts", DataConstants.PROGRESS_ATTEMPTS,
                "PROGRESS_ATTEMPTS constant should match expected value.");
        assertEquals("score", DataConstants.PROGRESS_SCORE, "PROGRESS_SCORE constant should match expected value.");
    }

    @Test
    public void testOtherFileNames() {
        assertEquals("users.json", DataConstants.USERS_FILE, "USERS_FILE constant should match expected value.");
        assertEquals("courses.json", DataConstants.COURSES_FILE, "COURSES_FILE constant should match expected value.");
        assertEquals("assessments.json", DataConstants.ASSESSMENTS_FILE,
                "ASSESSMENTS_FILE constant should match expected value.");
        assertEquals("dictionary.json", DataConstants.DICTIONARY_FILE,
                "DICTIONARY_FILE constant should match expected value.");
        assertEquals("exercises.json", DataConstants.EXERCISES_FILE,
                "EXERCISES_FILE constant should match expected value.");
        assertEquals("feedback.json", DataConstants.FEEDBACK_FILE,
                "FEEDBACK_FILE constant should match expected value.");
        assertEquals("languages.json", DataConstants.LANGUAGES_FILE,
                "LANGUAGES_FILE constant should match expected value.");
        assertEquals("notifications.json", DataConstants.NOTIFICATIONS_FILE,
                "NOTIFICATIONS_FILE constant should match expected value.");
        assertEquals("progressData.json", DataConstants.PROGRESS_DATA_FILE,
                "PROGRESS_DATA_FILE constant should match expected value.");
        assertEquals("textToSpeech.json", DataConstants.TEXT_TO_SPEECH_FILE,
                "TEXT_TO_SPEECH_FILE constant should match expected value.");
        assertEquals("userList.json", DataConstants.USER_LIST_FILE,
                "USER_LIST_FILE constant should match expected value.");
    }
}
