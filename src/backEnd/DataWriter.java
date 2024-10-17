package backEnd;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



/**
 * The DataWriter class is responsible for writing flashcard data to a JSON file.
 * It takes a list of Flashcard objects and converts them into JSON format before
 * saving them to the file.
 */
public class DataWriter extends DataConstants {

//    /** 
//     * Path to the JSON file where flashcard data will be written.
//     */
//    private static final String FILE_PATH = "data.json";

//    /**
//     * Writes a list of flashcards to the JSON file specified in FILE_PATH.
//     * This method converts each Flashcard object into a JSON representation and writes
//     * the entire list of flashcards as a JSON array to the file.
//     *
//     * @param flashcards The list of Flashcard objects to be written to the file.
//     */
  
// // (@SuppressWarnings("unchecked")) to get rid of the warnings.
// @SuppressWarnings("unchecked")
// public static void writeFlashcards(List<Flashcards> flashcards) {
//         // Create a JSON array to hold flashcard data
//         JSONArray flashcardList = new JSONArray();

//         // Convert each Flashcard object to a JSON object
//         for (Flashcards flashcard : flashcards) {
//             JSONObject flashcardDetails = new JSONObject();

//             flashcardDetails.put("word", flashcard.getWord());
//             flashcardDetails.put("translation", flashcard.getTranslation());
//             flashcardDetails.put("phrase", flashcard.getPhrase());

//             // Add the flashcard JSON object to the array
//             flashcardList.add(flashcardDetails);
//         }

//         // Write the JSON array to the file
//         try (FileWriter file = new FileWriter(FILE_PATH)) {
//             file.write(flashcardList.toJSONString());  // Write JSON data to file
//             file.flush();  // Ensure all data is written
//         } catch (IOException e) {
//             e.printStackTrace();  // Handle errors in writing to the file
//         }
//    }
// }

private static final String USER_FILE_NAME = "users.json";
private static final String COURSE_FILE_NAME = "courses.json";

/**
 * Saves the list of users to a JSON file.
 *
 * @return true if save was successful, false otherwise
 */
public static boolean saveUsers() {
    UserList users = UserList.getInstance();
    List<User> userList = users.getUsers();
    JSONArray jsonUsers = new JSONArray();

    // Creation of JSON objects
    for (User user : userList) {
        jsonUsers.add(getUserJSON(user));
    }

    // Write the JSON file
    try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
        file.write(jsonUsers.toJSONString());
        file.flush();
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}

/**
 * Creates a JSONObject from the given User object.
 *
 * @param user the User object to create the JSONObject from
 * @return the JSONObject created from the User object
 */
private static JSONObject getUserJSON(User user) {
    JSONObject userDetails = new JSONObject();
    userDetails.put("userID", user.getId().toString());
    userDetails.put("userName", user.getName());
    userDetails.put("email", user.getEmail());
    userDetails.put("languagePreference", user.getLanguagePreference().toString());
    userDetails.put("streakCount", user.getStreakCount());
    // Add more user fields as necessary
    return userDetails;
}

/**
 * Saves the list of courses to a JSON file.
 *
 * @return true if save was successful, false otherwise
 */
public static boolean saveCourses() {
    CourseList courses = CourseList.getInstance();
    ArrayList<Course> courseList = (ArrayList<Course>) courses.getAllCourses();
    JSONArray jsonCourses = new JSONArray();

    // Creation of JSON objects
    for (Course course : courseList) {
        jsonCourses.add(getCourseJSON(course));
    }

    // Write the JSON file
    try (FileWriter file = new FileWriter(COURSE_FILE_NAME)) {
        file.write(jsonCourses.toJSONString());
        file.flush();
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}

/**
 * Creates a JSONObject from the given Course object.
 *
 * @param course the Course object to create the JSONObject from
 * @return the JSONObject created from the Course object
 */
private static JSONObject getCourseJSON(Course course) {
    JSONObject courseDetails = new JSONObject();
    courseDetails.put("courseID", course.getId().toString());
    courseDetails.put("title", course.getTitle());
    courseDetails.put("description", course.getDescription());
    courseDetails.put("language", course.getLanguage().toString());
    // Add more course fields as necessary
    return courseDetails;
}
}