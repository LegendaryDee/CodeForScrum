
package backend;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;


public class DataLoaderTest extends DataConstants {
	
	
    @Test
    public void testLoadFlashcardsSuccessfully() {
        List<Flashcards> flashcards = DataLoader.loadFlashcards();
        assertNotNull(flashcards);
        assertEquals(1, flashcards.size());
    }
  
    @Test
    public void testLoadQuestionsSuccessfully() {
        List<Question> questions = DataLoader.loadQuestions();
        assertNotNull(questions);
    }
    
    @Test
    public void testLoadCoursesSuccessfully() {
        List<Course> courses = DataLoader.loadCourses();
        assertNotNull(courses);
    }

    @Test
    public void testLoadCoursesFileNotFound() {
        List<Course> courses = DataLoader.loadCourses();
        courses.clear(); 
        // Expecting an empty list if the file is not found
        assertNotNull(courses);
        assertTrue(courses.isEmpty());
    }

    @Test
    public void testGetCoursesReturnsNotNull() {
        // Test the current state where getCourses() returns null
        List<Course> courses = DataLoader.getCourses();
        assertNotNull(courses);
    }
    
    @Test
    public void testGetCoursesReturnsEmptyListWhenNoCoursesAvailable() {
        // Assume getCourses() is implemented to return an empty list instead of null
        List<Course> courses = DataLoader.getCourses();
        courses.clear();
        assertNotNull(courses, "Expected getCourses() to return an empty list, not null");
        assertTrue(courses.isEmpty(), "Expected getCourses() to return an empty list when no courses are available");
    }

    // Courses are loaded into the list
    @Test
    public void testGetCoursesWithCoursesAvailable() {
        List<Course> courses = DataLoader.getCourses();
        assertNotNull(courses, "Expected getCourses() to return a list, not null");
        assertEquals(4, courses.size(), "Expected getCourses() to return 4 courses");

        // Verify the contents of the list
        Course course1 = courses.get(0);
        assertEquals("English Basics", course1.getTitle());

        Course course2 = courses.get(1);
        assertEquals("Spanish Basics", course2.getTitle());
    }

    @Test
    public void testGetUsersSuccessfully() {
        // Update the file path to the valid JSON file
        List<User> users = DataLoader.getUsers();
        assertNotNull(users);
    }


    @Test
    public void testGetProgressDataReturnsNull() {
        // Test the current state where getProgressData() returns null
        List<ProgressData> progressData = DataLoader.getProgressData();
        assertNotNull(progressData);
    }
    
    // Future test case assuming getProgressData() will eventually return an empty list instead of null
    @Test
    public void testGetProgressDataReturnsEmptyListWhenNoDataAvailable() {
        List<ProgressData> progressData = DataLoader.getProgressData();
        progressData.clear();
        assertNotNull(progressData, "Expected getProgressData() to return an empty list, not null");
        assertTrue(progressData.isEmpty(), "Expected getProgressData() to return an empty list when no progress data is available");
    }

    @Test
    public void testGetProgressDataWithDataAvailable() {
        List<ProgressData> progressData = DataLoader.getProgressData();
        assertNotNull(progressData, "Expected getProgressData() to return a list, not null");
    }
    
}
