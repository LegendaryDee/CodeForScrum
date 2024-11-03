package backend;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * The DataLoader class is responsible for loading flashcard data from a JSON file.
 * It parses the JSON data and converts it into a list of Flashcard objects.
 */
@SuppressWarnings("unused")
public class DataLoader extends DataConstants {
   /**
    * Loads the flashcards from the JSON file specified in the FILE_NAME.
    * This method reads the JSON file, parses the flashcard data, and converts
    * each JSON object into a Flashcard pojo object.
    *
    * @return A list of Flashcard objects parsed from the JSON file.
    */

    @SuppressWarnings("unchecked")
	public static List<Flashcards> loadFlashcards() {
    	  List<Flashcards> flashcards = new ArrayList<>();

          // Try to read and parse the JSON file
          try (FileReader reader = new FileReader(FILE_NAME_FLASHCARDS)) {
              JSONParser jsonParser = new JSONParser();
              
              // Parse the JSON array from the file
              Object obj = jsonParser.parse(reader);
              JSONArray flashcardList = new JSONArray();
              flashcardList.add(obj);

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

    

    @SuppressWarnings("unchecked")
	public static List<Question> loadQuestions() {
        List<Question> questionsList = new ArrayList<>();

        // Try to read and parse the JSON file
        try (FileReader reader = new FileReader(FILE_NAME_QUESTIONS)) {
            JSONParser jsonParser = new JSONParser();
            
            // Parse the JSON array from the file
            Object obj = jsonParser.parse(reader);
            JSONArray questionList = new JSONArray();
            questionList.add(obj);
            // Iterate through each JSON object in the array and convert it to a Flashcard
            for (Object questionObject : questionList) {
                JSONObject questionJSON = (JSONObject) questionObject;
                String questionFromJson = (String) questionJSON.get("Question");
                
                // Create a new Flashcard object and add it to the list

                Question question = new Question(UUID.randomUUID(), questionFromJson, questionList, 0);
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
 
    public static List<Course> loadCourses() {
        List<Course> courses = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(FILE_NAME_COURSES)) {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONArray courseArray = (JSONArray) jsonObject.get("courses");

            for (Object obj : courseArray) {
                JSONObject courseJson = (JSONObject) obj;

                // Extract course details
                String id = (String) courseJson.get("id");
                String title = (String) courseJson.get("title");
                String description = (String) courseJson.get("description");

                // Create a new Course object
                Course course = new Course(UUID.fromString(id), title, description);
                List<Lesson> lessons = null;
                // Load lessons
                JSONArray lessonsArray = (JSONArray) courseJson.get("lessons");
                for (Object lessonObj : lessonsArray) {
                	lessons = new ArrayList<>();
                    JSONObject lessonJson = (JSONObject) lessonObj;
                    String lessonTitle = (String) lessonJson.get("title");
                    String lessonContent = (String) lessonJson.get("content");
                    lessons.add(new Lesson(lessonTitle, lessonContent));
                    course.setLessons(lessons); // Assuming you have a Lesson class
                }

                // Add the course to the list
                courses.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return courses;
    }


    // Method to convert JSONArray to a String array
     @SuppressWarnings("unused")
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

    //This method is not used
     public static List<Course> getCourses() {
         List<Course> courseList = new ArrayList<>();
           // Try to read and parse the JSON file
           try (FileReader reader = new FileReader(FILE_NAME_COURSES)) {
               JSONParser parser = new JSONParser();
          	 Object obj = parser.parse(reader);
          	 JSONArray courseArray = null;
          	 JSONObject jsonObject = null;
               if (obj instanceof JSONArray) {
              	  // Parse the JSON array from the file
                   courseArray = (JSONArray) obj;
               } else if (obj instanceof JSONObject) {
                   jsonObject = (JSONObject) obj;
               }
               
               if(jsonObject != null) {
              	 courseArray = (JSONArray) jsonObject.get("courses");
               }
               
          	 
               // Iterate through each JSON object in the array and convert it to a Flashcards
               if(courseArray != null) {
              	 for (Object courseObject : courseArray) {
                       JSONObject courseJson = (JSONObject) courseObject;

                     // Extract course details
                     UUID id = UUID.fromString(String.valueOf(courseJson.get("id")));
                     String selectedLanguage = (String) courseJson.get("selectedLanguage");
                     String title = (String) courseJson.get("title");
                     String description = (String) courseJson.get("description");
                     String proficiency = (String) courseJson.get("proficiency");
                     Course course = new Course(id, Language.valueOf(selectedLanguage.toUpperCase()),title,
                    		 					null,description, Proficiency.valueOf(proficiency));
                     // Load lessons
                     List <Lesson> lessons = new ArrayList<>();
                     JSONArray lessonsArray = (JSONArray) courseJson.get("lessons");
                     for (Object lessonObj : lessonsArray) {
                    	
                         JSONObject lessonJson = (JSONObject) lessonObj;
                         UUID lessonID = UUID.fromString(String.valueOf(lessonJson.get("id")));
                         String lessonTitle = (String) lessonJson.get("title");
                         Lesson lesson = new Lesson(lessonID, lessonTitle );
                         
                         //Topics
                         List <Topic> topics  = new ArrayList<>();
                         JSONArray topicsArray = (JSONArray) lessonJson.get("topics");
                         for (Object topicObj : topicsArray) {
                        	 JSONObject topicJson = (JSONObject) topicObj;
                        	 String topicTitle = (String) topicJson.get("title");
                        	 String topicContent = (String) topicJson.get("content");
                        	 Topic topic = new Topic(topicTitle, topicContent);
                        	 topics.add(topic);
                         }
                         lesson.setTopics(topics);
                         lessons.add(lesson);
                         course.setLessons(lessons); // Assuming you have a Lesson class
                     }
                     // Add the course to the list
                     courseList.add(course);
                 }
             }
            
         }  catch (IOException | ParseException e) {
             e.printStackTrace();  // Handle errors in reading or parsing the file
         }
         return courseList;  // Return the list of courses
    }



    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();

        try {

            FileReader reader = new FileReader(DataConstants.FILE_NAME_USERS);

            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray) parser.parse(reader);

            for (Object obj : usersJSON) {
                JSONObject userJSON = (JSONObject) obj;
                UUID id = UUID.fromString((String) userJSON.get("userID"));
                String userName = (String) userJSON.get("userName");
                String password = (String) userJSON.get("password");
                String email = (String) userJSON.get("email");
                String languagePreferenceString = (String) userJSON.get("languagePreference");
                LanguagePreference languagePreference = LanguagePreference.valueOf(languagePreferenceString.toUpperCase());

                // Create a new User object and add it to the list
                User user = new User(id, userName, password, email, languagePreference, new ProgressData(id.toString()), 0);
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
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
                UUID userID = UUID.fromString(userId);
//                int lessonsCompleted = (Integer) progressJSON.get("lessonsCompleted");
//                int attempts = (Integer) progressJSON.get("attempts");
//                int score = (Integer) progressJSON.get("score");
                
                // Create a new Flashcard object and add it to the list
                ProgressData progressData = new ProgressData(userID);
                progressDataList.add(progressData);
            }
        }  catch (IOException | ParseException e) {
            e.printStackTrace();  // Handle errors in reading or parsing the file
        }

        return progressDataList;  // Return the list of flashcards
   }
    
}
