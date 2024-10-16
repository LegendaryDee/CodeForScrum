package backEnd;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UserList userList = new UserList();
        CourseList courseList = new CourseList();

        // Sample Spanish courses with proficiency levels
        Course Spanish = new Course(UUID.randomUUID(), "Basic Spanish", "Learn the fundamentals of Spanish.", "The user is going to be learning about grammar, vocabulary, pronunciation, and basic converstion skills.", Proficiency.BEGINNER);
        Spanish.addLesson(new Lesson("Introduction to Spanish", "Introductory content.", 30)); // 30 minutes
        courseList.addCourse(Spanish);

        // Create and register a new user
        User user = new User(UUID.randomUUID(), "johnAdams", "securePassword", "JohnAdams@gmail.com", LanguagePreference.ENGLISH, null, 1);
        userList.addUser(user);

        // Simulate user login
        if (user.login("johnAdams", "securePassword")) {
            System.out.println(user);

            // Start a course
            System.out.println("Starting course: " + Spanish.getTitle());

            // Complete a lesson
            if (!Spanish.getLessons().isEmpty()) {
                Lesson lesson = Spanish.getLessons().get(0);
                lesson.startLesson();
                lesson.completeLesson();

                // Assume the user scored 85 on the lesson
                int lessonScore = 85; 
                Spanish.setScore(lessonScore);
                user.addScore(lessonScore);

                // Print out course and lesson details
                System.out.println("Course: " + Spanish.getTitle());
                System.out.println("Lesson: " + lesson.getTitle());
                System.out.println("Duration: " + lesson.getDuration() + " minutes");
                System.out.println("Score for this lesson: " + Spanish.getScore());
                System.out.println("Total score of the user: " + user.getTotalScore());
                System.out.println("Proficiency Level: " + Spanish.getProficiency());
            }

            // Submit feedback directly
            System.out.println("Feedback submitted: This course is excellent so far!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
