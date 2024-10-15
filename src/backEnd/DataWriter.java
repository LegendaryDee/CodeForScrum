package backEnd;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Author: Hardik Marlapudi
 * Date: 10/6/2024
 */

/**
 * The DataWriter class is responsible for writing data (flashcards, questions, etc.) to JSON files.
 */
public class DataWriter extends DataConstants {

   /** 
    * Path to the JSON file where flashcard data will be written.
    */
   private static final String FILE_PATH = "data.json";

   /**
    * Writes a list of flashcards to the JSON file specified in FILE_PATH.
    * This method converts each Flashcard object into a JSON representation and writes
    * the entire list of flashcards as a JSON array to the file.
    *
    * @param flashcards The list of Flashcard objects to be written to the file.
    */
  
// (@SuppressWarnings("unchecked")) to get rid of the warnings.
@SuppressWarnings("unchecked")
public static void writeFlashcards(List<Flashcards> flashcards) {
        // Create a JSON array to hold flashcard data
        JSONArray flashcardList = new JSONArray();

        // Convert each Flashcard object to a JSON object
        for (Flashcards flashcard : flashcards) {
            JSONObject flashcardDetails = new JSONObject();

            flashcardDetails.put("word", flashcard.getWord());
            flashcardDetails.put("translation", flashcard.getTranslation());
            flashcardDetails.put("phrase", flashcard.getPhrase());

            // Add the flashcard JSON object to the array
            flashcardList.add(flashcardDetails);
        }

        // Write the JSON array to the file
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(flashcardList.toJSONString());  // Write JSON data to file
            file.flush();  // Ensure all data is written
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to create a JSON object from a User object
    @SuppressWarnings({ "unchecked", "unused" })
    private static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put("userID", user.getId().toString());
        userDetails.put("userName", user.getUserName());
        userDetails.put("email", user.getEmail());
        userDetails.put("languagePreference", user.getLanguagePreference().toString());
        userDetails.put("streakCount", user.getStreakCount());
        userDetails.put("progressData", getProgressDataJSON(user.getProgressData()));
        
        return userDetails;
    }

    // Helper method to create a JSON object from a Course object
    @SuppressWarnings({ "unchecked", "unused" })
    private static JSONObject getCourseJSON(Course course) {
        JSONObject courseDetails = new JSONObject();
        courseDetails.put("id", course.getCourseID().toString());
        courseDetails.put("title", course.getTitle());
        courseDetails.put("description", course.getDescription());
        courseDetails.put("topics", getTopicsJSON(course.getTopics()));
        
        return courseDetails;
    }

    // Helper method to create a JSON object for ProgressData
    @SuppressWarnings("unchecked")
    private static JSONObject getProgressDataJSON(ProgressData progressData) {
        JSONObject progressDetails = new JSONObject();
        progressDetails.put("lessonsCompleted", progressData.getLessonsCompleted());
        progressDetails.put("attempts", progressData.getAttempts());
        progressDetails.put("score", progressData.getScore());
        
        return progressDetails;
    }

    // Helper method to create a JSON array for a list of Topics
    @SuppressWarnings("unchecked")
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
    @SuppressWarnings("unchecked")
    private static JSONArray getLessonsJSON(ArrayList<Lesson> arrayList) {
        JSONArray jsonLessons = new JSONArray();
        
        for (Lesson lesson : arrayList) {
            JSONObject lessonDetails = new JSONObject();
            lessonDetails.put("id", lesson.getId().toString());
            jsonLessons.add(lessonDetails);
        }
        
        return jsonLessons;
    }

    // Helper method to create a JSON array for a list of Exercises
    @SuppressWarnings("unchecked")
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
