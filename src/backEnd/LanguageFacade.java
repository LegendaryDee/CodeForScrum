package backEnd;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public class LanguageFacade {

    // Attributes
    @SuppressWarnings("unused")
    private User user;
    private List<String> availableLanguages;
    @SuppressWarnings("unused")
    private List<Course> courses;
    @SuppressWarnings("unused")
    private ProgressData progressData;
    @SuppressWarnings("unused")
    private List<String> topicVocabulary;
    private boolean notificationsIsUrgent;

    // Constructor
    public LanguageFacade(User user, List<String> availableLanguages, List<Course> courses, ProgressData progressData, List<String> topicVocabulary, boolean notificationIsUrgent) {
        this.user = user;
        this.availableLanguages = availableLanguages;
        this.courses = courses;
        this.progressData = progressData;
        this.topicVocabulary = topicVocabulary;
        this.notificationsIsUrgent = notificationsIsUrgent;
    }

    // Methods from the UML diagram

    public void registerUser(Map<String, String> userDetails) {
        System.out.println("User registered: " + userDetails.get("username"));
    }

    public boolean loginUser(String username, String password) {
        System.out.println("User logged in: " + username);
        return true;
    }

    public void updateUserProfile(UUID userID, Map<String, String> updatedDetails) {
        System.out.println("User profile updated for ID: " + userID);
    }

    public void recoverPassword(String email) {
        System.out.println("Password recovery initiated for: " + email);
    }

    public void startCourse(UUID userID, String courseID) {
        System.out.println("User ID: " + userID + " started course ID: " + courseID);
    }

    public void completeLesson(UUID userID, String lessonID) {
        System.out.println("User ID: " + userID + " completed lesson ID: " + lessonID);
    }

    public Course getCourseDetails(String courseID) {
        System.out.println("Retrieving details for course ID: " + courseID);
        return new Course(courseID, availableLanguages, availableLanguages, null, null);
    }

    public ProgressData getUserProgress(UUID userID) {
        System.out.println("Retrieving progress for user ID: " + userID);
        return new ProgressData();
    }

    public void saveProgress(UUID userID, ProgressData progressData) {
        System.out.println("Progress saved for user ID: " + userID);
    }

    public void completeExercise(UUID userID, String exerciseID) {
        System.out.println("User ID: " + userID + " completed exercise ID: " + exerciseID);
    }

    public String takeAssessment(UUID userID, String assessmentID) {
        System.out.println("User ID: " + userID + " taking assessment ID: " + assessmentID);
        return "Assessment result";
    }

    public void submitFeedback(UUID userID, String feedbackText) {
        System.out.println("Feedback submitted by user ID: " + userID + ": " + feedbackText);
    }

    public List<Notification> getNotifications(UUID userID) {
        System.out.println("Retrieving notifications for user ID: " + userID);
        return new ArrayList<>();
    }

    public void markNotificationAsRead(int notificationID) {
        System.out.println("Notification ID: " + notificationID + " marked as read.");
    }

    public String lookupWordInDictionary(String word) {
        System.out.println("Looking up word: " + word);
        return "Definition of " + word;
    }
}
