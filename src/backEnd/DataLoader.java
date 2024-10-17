package backEnd;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Author: Hardik Marlapudi
 * Date: 10/6/2024
 */

/**
 * The DataLoader class is responsible for loading flashcard data from a JSON file.
 * It parses the JSON data and converts it into a list of Flashcard objects.
 */
public class DataLoader {

   /** 
    * Path to the JSON file where flashcard data is stored. 
    */
   private static final String FILE_PATH = "data.json";

   /**
    * Loads the flashcards from the JSON file specified in the FILE_PATH.
    * This method reads the JSON file, parses the flashcard data, and converts
    * each JSON object into a Flashcard object.
    *
    * @return A list of Flashcard objects parsed from the JSON file.
    */
    public static List<Flashcards> loadFlashcards() {
        List<Flashcards> flashcards = new ArrayList<>();

        // Try to read and parse the JSON file
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONParser jsonParser = new JSONParser();
            
            // Parse the JSON array from the file
            Object obj = jsonParser.parse(reader);
            JSONArray flashcardList = (JSONArray) obj;

            // Iterate through each JSON object in the array and convert it to a Flashcard
            for (Object flashcardObject : flashcardList) {
                JSONObject flashcardJSON = (JSONObject) flashcardObject;

                String id = (String) flashcardJSON.get("id");
                String word = (String) flashcardJSON.get("word");
                String definition = (String) flashcardJSON.get("definition");
                String language = (String) flashcardJSON.get("language");
                String category = (String) flashcardJSON.get("category");
                
                // Create a new Flashcard object and add it to the list
                Flashcards flashcard = new Flashcards(id, word, definition, language, category);
                flashcards.add(flashcard);
            }
        }  catch (IOException | ParseException e) {
            e.printStackTrace();  // Handle errors in reading or parsing the file
        }

        return flashcards;  // Return the list of flashcards
    }
}
