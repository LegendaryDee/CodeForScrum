package backEnd;

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
 * The DataWriter class is responsible for writing flashcard data to a JSON file.
 * It takes a list of Flashcard objects and converts them into JSON format before
 * saving them to the file.
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
   public static void writeFlashcards(List<Flashcards> flashcards) {
        // Create a JSON array to hold flashcard data
        JSONArray flashcardList = new JSONArray();

        // Convert each Flashcard object to a JSON object
        for (Flashcards flashcard : flashcards) {
            JSONObject flashcardDetails = new JSONObject();

            flashcardDetails.put("id", flashcard.getId());
            flashcardDetails.put("word", flashcard.getWord());
            flashcardDetails.put("definition", flashcard.getDefinition());
            flashcardDetails.put("language", flashcard.getLanguage());
            flashcardDetails.put("category", flashcard.getCategory());

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
