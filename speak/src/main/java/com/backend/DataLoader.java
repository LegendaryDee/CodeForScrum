package com.backend;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataLoader extends DataConstants{

	   /** 
	    * Path to the JSON file where flashcard data is stored. 
	    */
	   private static final String FILE_NAME_FLASHCARDS = "exercises.json";
	   private static final String FILE_NAME_QUESTIONS = "exercises.json";
	   private static final String FILE_NAME_PROGRESS = "progressData.json";
	   private static final String FILE_NAME_COURSES = "courses.json";
	   private static final String FILE_NAME_USERS = "users.json";

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



    public static List<Course> getCourses() {
      
    	 List<Course> courseList = new ArrayList<>();
         // Try to read and parse the JSON file
         try (FileReader reader = new FileReader(FILE_NAME_COURSES)) {
             JSONParser jsonParser = new JSONParser();
             
             // Parse the JSON array from the file
             Object obj = jsonParser.parse(reader);
             JSONArray courseArray = (JSONArray) obj;

             // Iterate through each JSON object in the array and convert it to a Flashcard
             for (Object courseObject : courseArray) {
                 JSONObject courseJSON = (JSONObject) courseObject;

                 String courseId = (String) courseJSON.get("courseID");
                 String vocabulary = (String) courseJSON.get("topicVocabulary");
                 String sentence = (String) courseJSON.get("topicSentenceMaking");
                 String[] listeningSection = (String[]) courseJSON.get("listeningSection");
                 Object gamifiedAssessmentOption = (Object)courseJSON.get("gamifiedAssessmentOption");
                 //FIXME
                 //Course course = new Course (UUID.fromString(courseId), Language selectedLanguage, String title, String lesson, String description, Proficiency proficiency);
                 //courseList.add(course);
             }
         }  catch (IOException | ParseException e) {
             e.printStackTrace();  // Handle errors in reading or parsing the file
         }

         return courseList;  // Return the list of flashcards
    }

    public static List<User> getUsers() {
        List<User> usersList = new ArrayList<>();

        // Try to read and parse the JSON file
        try (FileReader reader = new FileReader(FILE_NAME_USERS)) {
            JSONParser jsonParser = new JSONParser();
            
            // Parse the JSON array from the file
            Object obj = jsonParser.parse(reader);
            JSONArray userArray = (JSONArray) obj;

            // Iterate through each JSON object in the array and convert it to a User
            for (Object user : userArray) {
                JSONObject userJSON = (JSONObject) user;

                UUID userID = (UUID) userJSON.get("userID");
                String userName = (String) userJSON.get("userName");
                String password = (String) userJSON.get("password");
                String email = (String) userJSON.get("email");
                String languagePreference = (String) userJSON.get("languagePreference");
                JSONObject progressDataJSON = (JSONObject) userJSON.get("progressData");
                int lessonsCompleted = (Integer) progressDataJSON.get("lesssonsCompleted");
                int attempts = (Integer) progressDataJSON.get("attempts");
                int score = (Integer) progressDataJSON.get("score");
                int streakCount = (Integer) progressDataJSON.get("streakCount");
                // Create a new ProgressDat  object and add it to the list
                ProgressData progressData = new ProgressData(userID.toString(), lessonsCompleted, attempts, score);
                
				/*
				 * User(UUID userID, String userName, String password, String email,
				 * LanguagePreference languagePreference, ProgressData progressData, int
				 * streakCount)
				 */
                User userData = new User (userID, userName, password, email,
                						 LanguagePreference.valueOf(languagePreference), 
                						  progressData, streakCount);
                usersList.add(userData);
            }
        }  catch (IOException | ParseException e) {
            e.printStackTrace();  // Handle errors in reading or parsing the file
        }

        return usersList;  // Return the list of flashcards
    }



    public static List<ProgressData> getProgressData() {
    	 List<ProgressData> progressDataList = new ArrayList<>();

         // Try to read and parse the JSON file
         try (FileReader reader = new FileReader(FILE_NAME_PROGRESS)) {
             JSONParser jsonParser = new JSONParser();
             
             // Parse the JSON array from the file
             Object obj = jsonParser.parse(reader);
             JSONArray progressDataArr = (JSONArray) obj;

             // Iterate through each JSON object in the array and convert it to a Flashcard
             for (Object progress : progressDataArr) {
                 JSONObject progressJSON = (JSONObject) progress;

                 String userId = (String) progressJSON.get("userID");
                 int lessonsCompleted = (Integer) progressJSON.get("lessonsCompleted");
                 int attempts = (Integer) progressJSON.get("attempts");
                 int score = (Integer) progressJSON.get("score");
                 
                 // Create a new Flashcard object and add it to the list
                 ProgressData progressData = new ProgressData(userId, lessonsCompleted, attempts, score );
                 progressDataList.add(progressData);
             }
         }  catch (IOException | ParseException e) {
             e.printStackTrace();  // Handle errors in reading or parsing the file
         }

         return progressDataList;  // Return the list of flashcards
    }
        
}
