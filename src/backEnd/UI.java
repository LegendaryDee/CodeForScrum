package backEnd;

import java.util.List;

/**
 * Name: Hardik Marlapudi
 * Date: 10/14/2024
 */

public class UI {

    // Constructor
    public UI() {
        // Initialize UI components
    }

    // Method to display a list of avaliable languages
    public void displayLanguages(List<String> languages) {
        System.out.println("Avaliable Languages:");
        for (String language : languages) {
            System.out.println("- " + language);
        }
    }

    // Method to display a list of avaliable languages
    public void displayUserProfile(User user) {
        System.out.println("User Profile:");
        System.out.println("Username: " + user.getUserName());
        System.out.println("Language Preference: " + user.getLanguagePreference());
        System.out.println("Proficiency Level: " + user.getProficiencyLevels());
        System.out.println("Streak Count: " + user.getStreakCount());
    }

    // Method to display course details
    public void displayCourseDetails(Course course) {
        System.out.println("Course Details:");
        System.out.println("Title: " + course.getTitle());
        System.out.println("Description:" + course.getDescription());
        System.out.println("Topics:");
        for (Topic topic : course.getTopics()) {
            System.out.println("- " + topic.getTitle());
        }
    }

    // Method to display lesson details
    public void displayLesson(Lesson lesson) {
        System.out.println("Lesson Details:");
        System.out.println("Lesson ID: " + lesson.getLessonID());
        System.out.println("Lesson Title: " + lesson.getTitle());
        // Display more details as needed
    }

    // Method to prompt feedback submission
    public void submitFeedback(String feedbackText) {
        System.out.println("Submitting Feedback: " + feedbackText);
        // Call to backend or other systems to submit feedback
    }

    // Additional methods for handling UI interactions could be added here...
}
