package backEnd;


import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * The DataLoader class loads the data from the JSON files and converts them into
 * corresponding objects (User, Course, etc.).
 */
public class DataLoader extends DataConstants {
    
    /**
     * Loads the users from the JSON file and returns an ArrayList of User objects.
     * @return An ArrayList of User objects loaded from the JSON file.
     */
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray) parser.parse(reader);

            for (Object obj : usersJSON) {
                JSONObject userJSON = (JSONObject) obj;
                UUID userId = UUID.fromString((String) userJSON.get("userID"));
                String userName = (String) userJSON.get("userName");
                String password = (String) userJSON.get("password");
                String email = (String) userJSON.get("email");
                String languagePreferenceString = (String) userJSON.get("languagePreference");
                int streakCount = Integer.parseInt(userJSON.get("streakCount").toString());

                // Convert the language preference string to an enum value
                LanguagePreference languagePreference = LanguagePreference.valueOf(languagePreferenceString.toUpperCase());
                // Assuming a default ProgressData object for simplicity (adjust as needed)
                ProgressData progressData = new ProgressData(userId.toString());

                User user = new User(userId, userName, password, email, languagePreference, progressData, streakCount);
                users.add(user);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return users;
    }

    /**
     * Loads the courses from the JSON file and returns an ArrayList of Course objects.
     * @return An ArrayList of Course objects loaded from the JSON file.
     */
    public static ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        
        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray coursesJSON = (JSONArray) parser.parse(reader);

            for (Object obj : coursesJSON) {
                JSONObject courseJSON = (JSONObject) obj;
                UUID courseId = UUID.fromString((String) courseJSON.get("courseID"));
                String title = (String) courseJSON.get("title");
                String description = (String) courseJSON.get("description");
                String languageString = (String) courseJSON.get("language");
                Language language = Language.valueOf(languageString.toUpperCase());
                UUID teacherId = UUID.fromString((String) courseJSON.get("teacherID"));

                // Get the teacher from the UserList instance
                UserList userList = UserList.getInstance();
                Teacher teacher = (Teacher) userList.getUserByUUID(teacherId);

                // Load topics
                ArrayList<Topic> topics = new ArrayList<>();
                JSONArray topicsJSON = (JSONArray) courseJSON.get("topics");
                for (Object topicObj : topicsJSON) {
                    JSONObject topicJSON = (JSONObject) topicObj;
                    UUID topicId = UUID.fromString((String) topicJSON.get("topicID"));
                    String topicTitle = (String) topicJSON.get("title");
                    String topicDescription = (String) topicJSON.get("description");

                    // Load lessons
                    ArrayList<Lesson> lessons = new ArrayList<>();
                    JSONArray lessonsJSON = (JSONArray) topicJSON.get("lessons");
                    for (Object lessonObj : lessonsJSON) {
                        JSONObject lessonJSON = (JSONObject) lessonObj;
                        UUID lessonId = UUID.fromString((String) lessonJSON.get("lessonID"));
                        String lessonTitle = (String) lessonJSON.get("title");
                        String lessonContent = (String) lessonJSON.get("content");

                        // Load comments for the lesson
                        ArrayList<Comment> lessonComments = new ArrayList<>();
                        JSONArray lessonCommentsJSON = (JSONArray) lessonJSON.get("comments");
                        commentRecursionJSON(lessonCommentsJSON, lessonComments);

                        lessons.add(new Lesson(lessonId, lessonTitle, lessonContent, lessonComments));
                    }

                    // Load the quiz for the topic
                    JSONObject quizJSON = (JSONObject) topicJSON.get("quiz");
                    UUID quizId = UUID.fromString((String) quizJSON.get("quizID"));
                    String quizTitle = (String) quizJSON.get("title");
                    String quizDescription = (String) quizJSON.get("description");
                    ArrayList<Question> questions = new ArrayList<>();
                    JSONArray questionsJSON = (JSONArray) quizJSON.get("questions");
                    for (Object questionObj : questionsJSON) {
                        JSONObject questionJSON = (JSONObject) questionObj;
                        UUID questionId = UUID.fromString((String) questionJSON.get("questionID"));
                        String questionText = (String) questionJSON.get("text");
                        ArrayList<String> choices = (ArrayList<String>) questionJSON.get("choices");
                        int correctAnswerIndex = ((Number) questionJSON.get("correctAnswerIndex")).intValue();

                        questions.add(new Question(questionId, questionText, choices, correctAnswerIndex));
                    }
                    Quiz quiz = new Quiz(quizId, quizTitle, quizDescription, questions);

                    // Load comments for the topic
                    ArrayList<Comment> topicComments = new ArrayList<>();
                    JSONArray topicCommentsJSON = (JSONArray) topicJSON.get("comments");
                    commentRecursionJSON(topicCommentsJSON, topicComments);

                    topics.add(new Topic(topicId, topicTitle, topicDescription, quiz, lessons, topicComments));
                }

                // Load comments and reviews for the course
                ArrayList<Comment> courseComments = new ArrayList<>();
                JSONArray commentsJSON = (JSONArray) courseJSON.get("comments");
                commentRecursionJSON(commentsJSON, courseComments);

                ArrayList<Review> reviews = new ArrayList<>();
                JSONArray reviewsJSON = (JSONArray) courseJSON.get("reviews");
                for (Object reviewObj : reviewsJSON) {
                    JSONObject reviewJSON = (JSONObject) reviewObj;
                    UUID reviewId = UUID.fromString((String) reviewJSON.get("reviewID"));
                    UUID studentId = UUID.fromString((String) reviewJSON.get("studentID"));
                    LocalDate date = LocalDate.parse((String) reviewJSON.get("date"));
                    int rating = ((Number) reviewJSON.get("rating")).intValue();
                    String content = (String) reviewJSON.get("content");

                    Student student = (Student) userList.getUserByUUID(studentId);
                    reviews.add(new Review(reviewId, student, date, rating, content));
                }

                courses.add(new Course(courseId, title, language, description, teacher, topics, reviews, courseComments, new ArrayList<>()));
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return courses;
    }

    /**
     * Recursively parses a JSONArray of comment JSONObjects and populates an ArrayList of Comment objects.
     * @param commentsJSON the JSONArray of comment JSONObjects to parse
     * @param comments the ArrayList of Comment objects to populate
     */
    public static void commentRecursionJSON(JSONArray commentsJSON, ArrayList<Comment> comments) {
        for (Object obj : commentsJSON) {
            JSONObject commentJSON = (JSONObject) obj;
            UUID commentId = UUID.fromString((String) commentJSON.get("commentID"));
            UUID userId = UUID.fromString((String) commentJSON.get("userID"));
            String content = (String) commentJSON.get("content");
            LocalDate date = LocalDate.parse((String) commentJSON.get("date"));

            ArrayList<Comment> replies = new ArrayList<>();
            JSONArray repliesJSON = (JSONArray) commentJSON.get("replies");
            if (repliesJSON != null && !repliesJSON.isEmpty()) {
                commentRecursionJSON(repliesJSON, replies);
            }

            UserList userList = UserList.getInstance();
            User user = userList.getUserByUUID(userId);
            comments.add(new Comment(commentId, user, date, content, replies));
        }
    }
}
