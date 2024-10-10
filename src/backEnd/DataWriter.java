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
 * The DataWriter class is responsible for writing data (flashcards, questions, etc.) to JSON files.
 */
public class DataWriter extends DataConstants {

   private static final String FILE_PATH_FLASHCARDS = "data.json";
   private static final String FILE_PATH_QUESTIONS = "question.json";

   // Method to write flashcards to the JSON file
   @SuppressWarnings("unchecked")
   public static void writeFlashcards(List<Flashcards> flashcards) {
       JSONArray flashcardList = new JSONArray();

       for (Flashcards flashcard : flashcards) {
           JSONObject flashcardDetails = new JSONObject();
           flashcardDetails.put("word", flashcard.getWord());
           flashcardDetails.put("translation", flashcard.getTranslation());
           flashcardDetails.put("phrase", flashcard.getPhrase());
           flashcardList.add(flashcardDetails);
       }

       try (FileWriter file = new FileWriter(FILE_PATH_FLASHCARDS)) {
           file.write(flashcardList.toJSONString());
           file.flush();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   // New: Method to write questions to the JSON file
   @SuppressWarnings("unchecked")
   public static void writeQuestions(List<Question> questions) {
       JSONArray questionList = new JSONArray();

       for (Question question : questions) {
           JSONObject questionDetails = new JSONObject();
           questionDetails.put("Question", question.getText());
           questionList.add(questionDetails);
       }

       try (FileWriter file = new FileWriter(FILE_PATH_QUESTIONS)) {
           file.write(questionList.toJSONString());
           file.flush();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
