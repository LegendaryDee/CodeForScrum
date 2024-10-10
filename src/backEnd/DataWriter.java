package backEnd;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class DataWriter {

    // Method to save users to a JSON file
    public static void saveUsers(ArrayList<User> users) {
        JSONArray jsonUsers = new JSONArray();
        
        // Creating JSON objects for each User
        for (User user : users) {
            jsonUsers.add(getUserJSON(user));
        }
        
        // Write JSON to file
        try (FileWriter file = new FileWriter("json/users.json")) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to save courses to a JSON file
    public static void saveCourses(ArrayList<Course> courses) {
        JSONArray jsonCourses = new JSONArray();
        
        // Creating JSON objects for each Course
        for (Course course : courses) {
            jsonCourses.add(getCourseJSON(course));
        }
        
        // Write JSON to file
        try (FileWriter file = new FileWriter("json/courses.json")) {
            file.write(jsonCourses.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to create a JSON object from a User object
    private static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put("userID", user.getUserID().toString());
        userDetails.put("userName", user.getUserName());
        userDetails.put("email", user.getEmail());
        userDetails.put("languagePreference", user.getLanguagePreference().toString());
        userDetails.put("streakCount", user.getStreakCount());
        userDetails.put("progressData", getProgressDataJSON(user.getProgressData()));
        
        return userDetails;
    }

    // Helper method to create a JSON object from a Course object
    private static JSONObject getCourseJSON(Course course) {
        JSONObject courseDetails = new JSONObject();
        courseDetails.put("id", course.getId().toString());
        courseDetails.put("title", course.getTitle());
        courseDetails.put("description", course.getDescription());
        courseDetails.put("topics", getTopicsJSON(course.getTopics()));
        
        return courseDetails;
    }

    // Helper method to create a JSON object for ProgressData
    private static JSONObject getProgressDataJSON(ProgressData progressData) {
        JSONObject progressDetails = new JSONObject();
        progressDetails.put("lessonsCompleted", progressData.getLessonsCompleted());
        progressDetails.put("attempts", progressData.getAttempts());
        progressDetails.put("score", progressData.getScore());
        
        return progressDetails;
    }

    // Helper method to create a JSON array for a list of Topics
    private static JSONArray getTopicsJSON(ArrayList<Topic> topics) {
        JSONArray jsonTopics = new JSONArray();
        
        for (Topic topic : topics) {
            JSONObject topicDetails = new JSONObject();
            topicDetails.put("id", topic.getId().toString());
            topicDetails.put("lessons", getLessonsJSON(topic.getLessons()));
            topicDetails.put("exercises", getExercisesJSON(topic.getExercises()));
            jsonTopics.add(topicDetails);
        }
        
        return jsonTopics;
    }

    // Helper method to create a JSON array for a list of Lessons
    private static JSONArray getLessonsJSON(ArrayList<Lesson> lessons) {
        JSONArray jsonLessons = new JSONArray();
        
        for (Lesson lesson : lessons) {
            JSONObject lessonDetails = new JSONObject();
            lessonDetails.put("id", lesson.getId().toString());
            jsonLessons.add(lessonDetails);
        }
        
        return jsonLessons;
    }

    // Helper method to create a JSON array for a list of Exercises
    private static JSONArray getExercisesJSON(ArrayList<Exercise> exercises) {
        JSONArray jsonExercises = new JSONArray();
        
        for (Exercise exercise : exercises) {
            JSONObject exerciseDetails = new JSONObject();
            exerciseDetails.put("id", exercise.getId().toString());
            jsonExercises.add(exerciseDetails);
        }
        
        return jsonExercises;
    }
}
