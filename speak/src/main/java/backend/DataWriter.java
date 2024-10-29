package backend;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
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
   private static final String FILE_PATH = "exercises.json";
   private static final String COURSE_FILE_PATH = "courses.json";

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
            e.printStackTrace();  // Handle errors in writing to the file
        }
   }

   /**
    * Saves a list of users to a JSON file
    * This method converts each User object into a JSON representation 
    * and writes the entire list of users as a JSON array to the file
    */

    @SuppressWarnings("unchecked")
    public static void saveUsers(List<User> users) {
        JSONArray userList = new JSONArray();

        for(User user: users) {
            JSONObject userDetails = new JSONObject();
            userDetails.put("id", user.getId().toString());
            userDetails.put("name", user.getName());
            userDetails.put("email", user.getEmail());
            userDetails.put("language", user.getLanguagePreference());
            userDetails.put("module", user.getModules());
            userList.add(userDetails);
        }

        String userFilePath = "users.json";
        try(FileWriter file = new FileWriter(userFilePath)) {
            file.write(userList.toJSONString());
            file.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void saveCourses(List<Course> courses) {
        JSONArray courseList = new JSONArray();

        for(Course course : courses) {
            JSONObject courseDetails = new JSONObject();
            courseDetails.put("id", course.getId().toString());
            courseDetails.put("title", course.getTitle());
            courseDetails.put("description", course.getDescription());
            courseDetails.put("selectedLanguage", course.getLanguage().toString());
            courseDetails.put("proficiency", course.getProficiency().toString());

            JSONArray lessonList = new JSONArray();
            for(Lesson lesson : course.getLessons()) {
                JSONObject lessonDetails = new JSONObject();
                lessonDetails.put("id", lesson.getId().toString());
                lessonDetails.put("title", lesson.getTitle());

                JSONArray topicList = new JSONArray();
                for(Topic topic : lesson.getTopics()) {
                    JSONObject topicDetails = new JSONObject();
                    topicDetails.put("title", topic.getTitle());
                    topicDetails.put("assessment", topic.getContent());
                    topicList.add(topicDetails);
                }
                lessonDetails.put("topics", topicList);
                lessonList.add(lessonDetails);
            }

            courseDetails.put("lessons", lessonList);
            courseList.add(courseDetails);
        }

        try (FileWriter file = new FileWriter(COURSE_FILE_PATH)) {
            file.write(courseList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
