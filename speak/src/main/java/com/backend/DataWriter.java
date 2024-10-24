package com.backend;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 * The DataWriter class is responsible for writing flashcard data to a JSON file.
 * It takes a list of Flashcard objects and converts them into JSON format before
 * saving them to the file.
 */
public class DataWriter extends DataConstants {
   /** 
    * Path to the JSON file where flashcard data will be written.
    */
   private static final String FILE_PATH_EXERCISES = "exercises.json";
   private static final String FILE_NAME_USERS = "users.json";
   private static final String FILE_NAME_COURSES = "courses.json";

   /**
    * Writes a list of flashcards to the JSON file specified in FILE_PATH.
    * This method converts each Flashcard object into a JSON representation and writes
    * the entire list of flashcards as a JSON array to the file.
    * @param flashcards The list of Flashcard objects to be written to the file.
    */
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
        try (FileWriter file = new FileWriter(FILE_PATH_EXERCISES)) {
            file.write(flashcardList.toJSONString());  // Write JSON data to file
            file.flush();  // Ensure all data is written
            file.close();
        } catch (IOException e) {
            e.printStackTrace();  // Handle errors in writing to the file
        }
   }

   public static boolean saveUsers(List<User> users) {
        // Assume we are writing to a file or database.
        // Replace with actual file writing logic.
    	  // Create a JSON array to hold flashcard data
	    boolean result = true;
	   
        JSONArray usersList = new JSONArray();

        // Convert each Flashcard object to a JSON object
        for (User user : users) {
            JSONObject userDetails = new JSONObject();
            userDetails.put("userID", user.getId());
            userDetails.put("userName", user.getName());
            userDetails.put("password", user.getPassword());
            userDetails.put("email", user.getEmail());
            userDetails.put("streakCount", user.getStreakCount());
            userDetails.put("languagePrefernce", user.getLanguagePreference());
            ProgressData progressData = (ProgressData) user.getProgressData();
	            JSONObject progressDetails = new JSONObject();
	            progressDetails.put("lessonsCompleted", progressData.getLessonsCompleted());
	            progressDetails.put("attempts", progressData.getAttempts());
	            progressDetails.put("score",progressData.getTotalScore());
	            userDetails.put("userID",progressData.getUserId());
	        userDetails.put("progressData",progressDetails);
            // Add the flashcard JSON object to the array
            usersList.add(userDetails);
        }
        
        // Write the JSON array to the file
        try (FileWriter file = new FileWriter(FILE_NAME_USERS)) {
            file.write(usersList.toJSONString());  // Write JSON data to file
            file.flush();  // Ensure all data is written
            file.close();
        } catch (IOException e) {
            e.printStackTrace();  // Handle errors in writing to the file
            result = false;
            
        }
        return result;
   }

    public static boolean saveCourses(List<Course> courses) {
      // Replace with actual file writing logic.
  	  boolean result = true;
  	  // Create a JSON array to hold flashcard data
  	  JSONArray coursesList = new JSONArray();
      // Convert each Flashcard object to a JSON object
      for (Course course : courses) {
          JSONObject courseDetails = new JSONObject();
          courseDetails.put("id", course.getId());
          courseDetails.put("title", course.getTitle());
          //FIXME courseDetails.put("lessons", course.lessons());
          courseDetails.put("topics", course.getTopics());
          courseDetails.put("proficiency", course.getProficiency());
          courseDetails.put("score", course.getScore());
         //FIXME  courseDetails.put("currentLessonIndex", course.getCurrentLessonIndex());
         //FIXME courseDetails.put("selectedLanguage", course.getSelectedLanguage());
         // Add the flashcard JSON object to the array
	      coursesList.add(courseDetails);
      }
      
      // Write the JSON array to the file
      try (FileWriter file = new FileWriter(FILE_NAME_COURSES)) {
          file.write(coursesList.toJSONString());  // Write JSON data to file
          file.flush();  // Ensure all data is written
          file.close();
      } catch (IOException e) {
          e.printStackTrace();  // Handle errors in writing to the file
          result = false;
          
      }
      return result;
    }
}
