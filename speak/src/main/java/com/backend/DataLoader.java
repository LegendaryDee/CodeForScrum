package com.backend;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

<<<<<<< HEAD:src/backEnd/DataLoader.java
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * The DataLoader class is responsible for loading flashcard data from a JSON file.
 * It parses the JSON data and converts it into a list of Flashcard objects.
 */
public class DataLoader {
=======
public class DataLoader extends DataConstants{
>>>>>>> ca64af1f5106eac0f9c3c16572fbcf39205710df:speak/src/main/java/com/backend/DataLoader.java

   /** 
    * Path to the JSON file where flashcard data is stored. 
    */
   private static final String FILE_NAME_FLASHCARDS = "data.json";
   private static final String FILE_NAME_QUESTIONS = "question.json";
   private static final String FILE_NAME_PROGRESS = "progress.json";
   private static final String FILE_NAME_CATEGORY_SYSTEM = "categorysystem.json";

   /**
    * Loads the flashcards from the JSON file specified in the FILE_NAME.
    * This method reads the JSON file, parses the flashcard data, and converts
    * each JSON object into a Flashcard pojo object.
    *
    * @return A list of Flashcard objects parsed from the JSON file.
    */

    public static List<Flashcards> loadFlashcards() {
        List<Flashcards> flashcards = new ArrayList<>();

        // Try to read and parse the JSON file
        try (FileReader reader = new FileReader(FILE_NAME_FLASHCARDS)) {
            JSONParser jsonParser = new JSONParser();
            
            // Parse the JSON array from the file
            Object obj = jsonParser.parse(reader);
            JSONArray flashcardList = (JSONArray) obj;

            // Iterate through each JSON object in the array and convert it to a Flashcard
            for (Object flashcardObject : flashcardList) {
                JSONObject flashcardJSON = (JSONObject) flashcardObject;

                String word = (String) flashcardJSON.get("word");
                String translation = (String) flashcardJSON.get("translation");
                String phrase = (String) flashcardJSON.get("phrase");
                
                // Create a new Flashcard object and add it to the list
                Flashcards flashcard = new Flashcards(word, translation, phrase);
                flashcards.add(flashcard);
            }
        }  catch (IOException | ParseException e) {
            e.printStackTrace();  // Handle errors in reading or parsing the file
        }

        return flashcards;  // Return the list of flashcards
    }

    

    public static List<Question> loadQuestions() {
        List<Question> questionsList = new ArrayList<>();

        // Try to read and parse the JSON file
        try (FileReader reader = new FileReader(FILE_NAME_QUESTIONS)) {
            JSONParser jsonParser = new JSONParser();
            
            // Parse the JSON array from the file
            Object obj = jsonParser.parse(reader);
            JSONArray flashcardList = (JSONArray) obj;

            // Iterate through each JSON object in the array and convert it to a Flashcard
            for (Object flashcardObject : flashcardList) {
                JSONObject flashcardJSON = (JSONObject) flashcardObject;

                String questionFromJson = (String) flashcardJSON.get("Question");
                
                
                // Create a new Flashcard object and add it to the list

                Question question = new Question(questionFromJson, questionFromJson, null, questionFromJson);

                questionsList.add(question);
            }
        }  catch (IOException | ParseException e) {
            e.printStackTrace();  // Handle errors in reading or parsing the file
        }

        return questionsList;  // Return the list of questions
    }

    
/**
 * Loads the progress data for the user from a JSON file and returns it as a list of Progress objects.
 * This method reads the JSON file, parses the data, and converts it into a list of Progress objects
 * representing the user's progress in different categories.
 *
 * @return A list of Progress objects parsed from the JSON file.
 */
public static List<ProgressData> loadProgress() {
    List<ProgressData> progressList = new ArrayList<>();

    // Try to read and parse the JSON file
    try (FileReader reader = new FileReader(FILE_NAME_PROGRESS)) {
        JSONParser jsonParser = new JSONParser();
        
        // Parse the JSON array from the file
        Object obj = jsonParser.parse(reader);
        JSONArray flashcardList = (JSONArray) obj;

        // Iterate through each JSON object in the array and convert it to a Progress object
        for (Object flashcardObject : flashcardList) {
            JSONObject flashcardJSON = (JSONObject) flashcardObject;

            // Extract progress data from the JSON object
            int totalQuestionsAnswered = (Integer) flashcardJSON.get("TotalQuestionAnswered");
            int numCorrectAnswers = (Integer) flashcardJSON.get("NumCorrectAnswers");
            Category currentCategory = (Category) flashcardJSON.get("CurrentCategory");
            int progressInCategory = (Integer) flashcardJSON.get("ProgressinCategory");
            JSONArray missedWords = (JSONArray) flashcardJSON.get("MissedWords");

            // Convert the missed words JSON array into an ArrayList of Strings
            ArrayList<String> result = convertJsonArrayToStringArray(missedWords);

            // Create a new Progress object and populate its fields
            ProgressData progress = new ProgressData();
            progress.setTotalQuestionsAnswered(totalQuestionsAnswered);
            progress.setNumCorrectAnswers(numCorrectAnswers);
            progress.setCurrentCategory(currentCategory);
            progress.setProgressInCategory(progressInCategory);
            progress.setMissedWords(result);

            // Add the Progress object to the progress list
            progressList.add(progress);
        }

    } catch (IOException | ParseException e) {
        e.printStackTrace();  // Handle errors in reading or parsing the file
    }

    return progressList;  // Return the list of Progress objects
}


    public static List<Flashcards> loadCategorySystem() {
        List<Flashcards> flashcards = new ArrayList<>();

        // Try to read and parse the JSON file
        try (FileReader reader = new FileReader(FILE_NAME_CATEGORY_SYSTEM)) {
            JSONParser jsonParser = new JSONParser();
            
            // Parse the JSON array from the file
            Object obj = jsonParser.parse(reader);
            JSONArray flashcardList = (JSONArray) obj;

            // Iterate through each JSON object in the array and convert it to a Flashcard
            for (Object flashcardObject : flashcardList) {
                JSONObject flashcardJSON = (JSONObject) flashcardObject;

                String word = (String) flashcardJSON.get("word");
                String translation = (String) flashcardJSON.get("translation");
                String phrase = (String) flashcardJSON.get("phrase");
                
                // Create a new Flashcard object and add it to the list
                Flashcards flashcard = new Flashcards(word, translation, phrase);
                flashcards.add(flashcard);
            }
        }  catch (IOException | ParseException e) {
            e.printStackTrace();  // Handle errors in reading or parsing the file
        }

        return flashcards;  // Return the list of flashcards
    }

    // Method to convert JSONArray to a String array
     private static ArrayList<String> convertJsonArrayToStringArray(JSONArray jsonArray) {
        // Create a String array with the same size as the JSONArray
        ArrayList<String> missedWords = new ArrayList<>();

        // Loop through the JSONArray and extract each element as a String
        for (int i = 0; i < jsonArray.size(); i++) {
            missedWords.add((String) jsonArray.get(i)); // Cast each object to a String
        }

        // Return the String array
        return missedWords;
    }



    public static ArrayList<Course> getCourses() {
        return null;
    }



    public static ArrayList<User> getUsers() {
        return null;
    }



    public static ArrayList<ProgressData> getProgressData() {
        return null;
    }
        
}
