package backEnd;
import java.util.UUID;
import java.util.List;

/**
 * Name: Hardik Marlapudi
 * Date: 10/14/2024
 */

public class UI {

    // Constructor
    // public UI() {
//         // Initialize UI components
//     }

//     // Method to display a list of avaliable languages
//     public void displayLanguages(List<String> languages) {
//         System.out.println("Avaliable Languages:");
//         for (String language : languages) {
//             System.out.println("- " + language);
//         }
//     }

//     // Method to display a list of avaliable languages
//     public void displayUserProfile(User user) {
//         System.out.println("User Profile:");
//         System.out.println("Username: " + user.getUserName());
//         System.out.println("Language Preference: " + user.getLanguagePreference());
//         System.out.println("Proficiency Level: " + user.getProficiencyLevels());
//         System.out.println("Streak Count: " + user.getStreakCount());
//     }

//     // Method to display course details
//     public void displayCourseDetails(Course course) {
//         System.out.println("Course Details:");
//         System.out.println("Title: " + course.getTitle());
//         System.out.println("Description:" + course.getDescription());
//         System.out.println("Topics:");
//         for (Topic topic : course.getTopics()) {
//             System.out.println("- " + topic.getTitle());
//         }
//     }

//     // Method to display lesson details
//     public void displayLesson(Lesson lesson) {
//         System.out.println("Lesson Details:");
//         System.out.println("Lesson ID: " + lesson.getLessonID());
//         System.out.println("Lesson Title: " + lesson.getTitle());
//         // Display more details as needed
//     }

//     // Method to prompt feedback submission
//     public void submitFeedback(String feedbackText) {
//         System.out.println("Submitting Feedback: " + feedbackText);
//         // Call to backend or other systems to submit feedback
//     }

//     // Additional methods for handling UI interactions could be added here...
// }

private LanguageFacade languageFacade;

public UI() {
    languageFacade = new LanguageFacade(null, null, null, null, null, false);
}

public void run() {
    scenario1();
    scenario2();
}

public void scenario1() {
    System.out.println();

    if(!languageFacade.loginUser("johnDoe", "securePassword")) {
        System.out.println("Sorry, we couldn't log in.");
        return;
    }
    System.out.println("John Doe is now logged in.");

    Course course = languageFacade.getCourseDetails("Spanish101");
    if(course == null) {
        System.out.println("Sorry, we don't have that course.");
        return;
    }
    System.out.println("You have enrolled in: " + course.getTitle());

    languageFacade.completeLesson(UUID.fromString("1e3c65e0-8fa4-4ec1-b7f8-ec6e6d75e4e6"), course.getId().toString());
    System.out.println("You have successfully completed a lesson in " + course.getTitle());
}

public void scenario2() {
    System.out.println();

    // User login
    if (!languageFacade.loginUser("janeDoe", "password456")) {
        System.out.println("Sorry, we couldn't log you in.");
        return;
    }
    System.out.println("Jane Doe is now logged in.");

    // Starting a course
    UUID courseId = UUID.fromString("course_1"); // Replace with a valid course ID
    if (!languageFacade.startCourse(UUID.randomUUID(), courseId)) { // Replace with actual user ID
        System.out.println("Sorry, you couldn't start the course.");
        return;
    }
    System.out.println("You have successfully started the course!");

    // Completing a lesson
    UUID lessonId = UUID.fromString("some-lesson-id"); // Replace with a valid lesson ID
    if (!languageFacade.completeLesson(UUID.randomUUID(), lessonId)) { // Replace with actual user ID
        System.out.println("Sorry, you couldn't complete the lesson.");
        return;
    }
    System.out.println("You have successfully completed the lesson!");
}

public static void main(String[] args) {
    UI languageLearningInterface = new UI();
    languageLearningInterface.run();
}
}
