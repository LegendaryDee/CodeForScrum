import java.util.ArrayList;
import java.util.UUID;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;


public class DataLoader {
    
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray) parser.parse(reader);

            for(Object obj : usersJSON) {
                JSONObject userJSON = (JSONObject) obj;
                UUID id = UUID.fromString((String) userJSON.get(USER_ID));
                String userName = (String) userJSON.get(USER_NAME);
                String password = (String) userJSON.get(USER_PASSWORD);
                String email = (String) userJSON.get(USER_EMAIL);
                String languagePreference = (String) userJSON.get(USER_LANGUAGE_PREFERENCE);
                int streakCount = ((Long) userJSON.get(USER_STREAK_COUNT)).intValue();

                JSONObject progressJSON = (JSONObject) userJSON.get(USER_PROGRESS_DATA);
                ProgressData progressData = new ProgressData();
                progressData.setLessonsCompleted(((Long) progressJSON.get("lessonsCompleted"))
                progressData.setAttempts(((Long) progressJSON.get("attempts")).intValue());
                progressData.setScore(((Long) progressJSON.get("score")).intValue());

                User user = new User(id, userName, password, email, languagePreference, streakCount, progressData, users.add(user))
            }
            return users;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<>();

        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray coursesJSON = (JSONArray) parser.parse(reader);

            for(Object obj : coursesJSON) {
                JSONObject courseJSON = (JSONObject) obj;
                UUID id = UUID.fromString((String) courseJSON.get(COURSE_ID));
                String title = (String) courseJSON.get(COURSE_DESCRIPTION);
                Language language = Language.valueOf((String) courseJSON.get(COURSE_LANGUAGE));

                Course course = new Course(id, title, description, language);
                courses.add(course);
            }
            return courses;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<ProgressData> getProgressData() {
        ArrayList<ProgressData> progressDataList = new ArrayList<>();

        try{
            FileReader reader = new FileReader(PROGRESS_DATA_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray progressDataJSON = (JSONArray) parser.parse(reader);

            for(Object obj : progressDataJSON) {
                JSONObject progressJSON = (JSONObject) obj;
                UUID userID = UUID.fromString((String) progressJSON.get(USER_ID));
                int lessonsCompleted = ((Long) progressJSON.get("lessonsCompleted")).intValue();
                int attempts = ((Long) progressJSON.get("attempts")).intValue();
                int score = ((Long) progressJSON.get("score")).intValue();

                ProgressData progress = new ProgressData(userID, lessonsCompleted, attempts, score);
                progressDataList.add(progress);
            }
            return progressDataList;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    }
}
