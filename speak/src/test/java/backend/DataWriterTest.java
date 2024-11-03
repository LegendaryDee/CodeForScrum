package backend;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;


public class DataWriterTest {

    @Test
    public void testWriteFlashcardsSuccessfully() throws IOException, ParseException {
        // Prepare test data
        List<Flashcards> flashcards = new ArrayList<>();
        flashcards.add(new Flashcards("Hello", "Hola", "Hello, how are you?"));
        flashcards.add(new Flashcards("Goodbye", "Adiós", "Goodbye, see you later!"));

        // Call the method to write flashcards
        DataWriter.writeFlashcards(flashcards);

        // Read back the file to verify content
        JSONParser parser = new JSONParser();
        JSONArray flashcardsArray = (JSONArray) parser.parse(new FileReader(DataConstants.FILE_NAME_FLASHCARDS));

        assertEquals(2, flashcardsArray.size(), "Expected 2 flashcards in the JSON file");

        // Verify the content of each flashcard
        var flashcard1 = (org.json.simple.JSONObject) flashcardsArray.get(0);
        assertEquals("Hello", flashcard1.get("word"));
        assertEquals("Hola", flashcard1.get("translation"));
        assertEquals("Hello, how are you?", flashcard1.get("phrase"));

        var flashcard2 = (org.json.simple.JSONObject) flashcardsArray.get(1);
        assertEquals("Goodbye", flashcard2.get("word"));
        assertEquals("Adiós", flashcard2.get("translation"));
        assertEquals("Goodbye, see you later!", flashcard2.get("phrase"));
    }

    @Test
    public void testWriteFlashcardsEmptyList() throws IOException, ParseException {
        // Prepare an empty list
        List<Flashcards> flashcards = new ArrayList<>();

        // Call the method to write flashcards
        DataWriter.writeFlashcards(flashcards);

        // Read back the file to verify content
        JSONParser parser = new JSONParser();
        JSONArray flashcardsArray = (JSONArray) parser.parse(new FileReader(DataWriter.FILE_NAME_FLASHCARDS));

        assertEquals(0, flashcardsArray.size(), "Expected an empty JSON array in the file");
    }

    @Test
    public void testSaveUsersSuccessfully() throws IOException, ParseException {
        // Prepare test data
        List<User> users = new ArrayList<>();
        users.add(new User(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"), "Jonn_Doe","password" ,"Jonn_Doe@mail.com",LanguagePreference.ENGLISH, new ProgressData("123e4567-e89b-12d3-a456-426614174000"), 4));
        users.add(new User(UUID.fromString("123e4567-e89b-12d3-a456-426614174001"), "Mary_Doe","password" ,"Mary_Doe@mail.com", LanguagePreference.SPANISH, new ProgressData("123e4567-e89b-12d3-a456-426614174001"), 2));

        // Call the method to save users
        DataWriter.saveUsers(users);

        // Read back the file to verify content
        JSONParser parser = new JSONParser();
        JSONArray userArray = (JSONArray) parser.parse(new FileReader(DataWriter.FILE_NAME_USERS));

        assertEquals(2, userArray.size(), "Expected 2 users in the JSON file");

        // Verify the content of each user
        JSONObject user1 = (JSONObject) userArray.get(0);
        assertEquals("123e4567-e89b-12d3-a456-426614174000", user1.get("id"));
        assertEquals("Alice", user1.get("name"));
        assertEquals("Jonn_Doe@mail.com", user1.get("email"));
        assertEquals("ENGLISH", user1.get("language"));
        assertEquals(4, user1.get("streakCount"));

        JSONObject user2 = (JSONObject) userArray.get(1);
        assertEquals("123e4567-e89b-12d3-a456-426614174001", user2.get("id"));
        assertEquals("Bob", user2.get("name"));
        assertEquals("Mary_Doe@mail.com", user2.get("email"));
        assertEquals("SPANISH", user2.get("language"));
        assertEquals(2,user2.get("streakCount"));
    }

    @Test
    public void testSaveUsersEmptyList() throws IOException, ParseException {
        // Prepare an empty list
        List<User> users = new ArrayList<>();
        // Call the method to save users
        DataWriter.saveUsers(users);
        // Read back the file to verify content
        JSONParser parser = new JSONParser();
        JSONArray userArray = (JSONArray) parser.parse(new FileReader(DataWriter.FILE_NAME_USERS));
        assertEquals(0, userArray.size(), "Expected an empty JSON array in the file");
    }

    //saveCourses():
    @Test
    public void testSaveCoursesSuccessfully() throws IOException, ParseException {
        // Prepare test data
        List<Course> courses = new ArrayList<>();
        List<Lesson> lessons = new ArrayList<Lesson>();
        Lesson lessons1 = new Lesson(UUID.fromString("111e4567-e89b-12d3-a456-426614174000"), "Lesson 1", "3", 5);
        Lesson lessons2 = new Lesson(UUID.fromString("111e4567-e89b-12d3-a456-426614174001"), "Lesson 2", "2", 4);
        Lesson lessons3 = new Lesson(UUID.fromString("111e4567-e89b-12d3-a456-426614174001"), "Lesson 3", "3", 3);
        Lesson lessons4 = new Lesson(UUID.fromString("111e4567-e89b-12d3-a456-426614174001"), "Lesson 4", "4", 4);
        lessons.add(lessons1);
        lessons.add(lessons2);
        Course course1 = new Course(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"), Language.ENGLISH , "Intro to Java",
        		lessons , "desc1", Proficiency.BEGINNER);
        
        lessons.add(lessons3);
        lessons.add(lessons4);
        Course course2 = new Course(UUID.fromString("123e4567-e89b-12d3-a456-426614174002"), Language.SPANISH , "Intro to Python",
        		lessons, "desc12", Proficiency.BEGINNER);
              
        
        // Call the method to save courses
        DataWriter.saveCourses(courses);

        // Read back the file to verify content
        JSONParser parser = new JSONParser();
        JSONArray courseArray = (JSONArray) parser.parse(new FileReader(DataWriter.FILE_NAME_COURSES));

        assertEquals(1, courseArray.size(), "Expected 1 course in the JSON file");

        // Verify course details
        JSONObject returnCourse = (JSONObject) courseArray.get(0);
        assertEquals("123e4567-e89b-12d3-a456-426614174000", returnCourse.get("id"));
        assertEquals("Java Basics", returnCourse.get("title"));
        assertEquals("Intro to Java", returnCourse.get("description"));
        assertEquals("ENGLISH", returnCourse.get("selectedLanguage"));
        assertEquals("BEGINNER", returnCourse.get("proficiency"));

     }

    @Test
    public void testSaveCoursesEmptyList() throws IOException, ParseException {
        // Prepare an empty list
        List<Course> courses = new ArrayList<>();
        // Call the method to save courses
        DataWriter.saveCourses(courses);
        courses = DataLoader.loadCourses();
        assertEquals(0, courses.size(), "Expected an empty JSON array in the file");
    }

    @Test
    public void testSaveCoursesIOException() {
        // Prepare test data
    	List<Course> courses = new ArrayList<>();
        List<Lesson> lessons = new ArrayList<>();
        Course course = new Course(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"), Language.ENGLISH , "Intro to Java",lessons, "desc1", Proficiency.BEGINNER);
        courses.add(course);
        // Attempt to save courses and capture any exceptions
        assertDoesNotThrow(() -> DataWriter.saveCourses(courses), "IOException should be handled gracefully");
    }
}
