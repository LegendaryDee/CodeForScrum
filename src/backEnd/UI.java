package backEnd;
import java.util.UUID;

public class UI {
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
    UUID courseId = UUID.fromString("2e3c65e0-5fa4-4ec1-b7f8-ec6e6d75e4e5"); // Replace with a valid course ID
    if (!languageFacade.startCourse(UUID.randomUUID(), courseId)) { // Replace with actual user ID
        System.out.println("Sorry, you couldn't start the course.");
        return;
    }
    System.out.println("You have successfully started the course!");

    // Completing a lesson
    UUID lessonId = UUID.fromString("1e3c75e0-5fa4-4ec1-b7f5-ec6e6d75e4e7"); // Replace with a valid lesson ID
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
