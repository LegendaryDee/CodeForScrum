package com.backend;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

<<<<<<< HEAD:src/backEnd/DataWriter.java
/**
 * The DataWriter class is responsible for writing flashcard data to a JSON file.
 * It takes a list of Flashcard objects and converts them into JSON format before
 * saving them to the file.
 */
public class DataWriter extends DataConstants {
=======
public class DataWriter extends DataConstants{
>>>>>>> ca64af1f5106eac0f9c3c16572fbcf39205710df:speak/src/main/java/com/backend/DataWriter.java

   /** 
    * Path to the JSON file where flashcard data will be written.
    */
   private static final String FILE_PATH = "data.json";

<<<<<<< HEAD:src/backEnd/DataWriter.java
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
=======
    public boolean saveUsers(List<User> users) {
        // Assume we are writing to a file or database.
        // Replace with actual file writing logic.
        try {
            // FileWriter or database operation
            return true;  // return true if successful
        } catch (Exception e) {
            e.printStackTrace();
            return false;  // return false if something goes wrong
        }
    }

    public boolean saveCourses(List<Course> courses) {
        // Similar to saveUsers, this would write course data.
        try {
            // FileWriter or database operation
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
>>>>>>> ca64af1f5106eac0f9c3c16572fbcf39205710df:speak/src/main/java/com/backend/DataWriter.java

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
            e.printStackTrace();  // Handle errors in writing to the file
        }
   }
}
