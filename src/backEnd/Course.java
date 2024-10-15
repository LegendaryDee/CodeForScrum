package backEnd;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class Course {
    private UUID id;
    private String title;
    private String description;
    private ArrayList<Lesson> lessons;
    private ArrayList<Topic> topics;
    private Proficiency proficiency;
    private int score;
    private int currentLessonIndex = 0;

    public Course(String title, String lesson, String description, Proficiency proficiency) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.lessons = new ArrayList<>();
        this.description = description;
        this.topics = new ArrayList<>();
        this.proficiency = proficiency;
        this.score = 0;
    }

    public Course(String courseID, List<String> availableLanguages, List<String> availableLanguages2, Object object,
            Object object2) {
        //TODO Auto-generated constructor stub
    }

    public void startLesson() {
        if(currentLessonIndex < topics.size()) {
            System.out.println("Starting lesson: " + topics.get(currentLessonIndex).getTitle());
        }else{
            System.out.println("All lessons completed.");
        }
    }

    public void completeLesson() {
        if(currentLessonIndex < topics.size()) {
            System.out.println("Completing lesson: " + topics.get(currentLessonIndex).getTitle());
            currentLessonIndex++;
        }else{
            System.out.println("No more lessons to complete.");
        }
    }

    public void saveProgress(int userID) {
        System.out.println("Saving progress for user ID " + userID + " at lesson index " + currentLessonIndex);
    }

    public void revisitSavedProgress(int userID) {
        System.out.println("Revisiting saved progress for user ID: " + userID + ", currently at lesson index " + currentLessonIndex);
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<Topic> getTopics() {
        return topics;
    }

    public String getTitle() {
        return title;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public String getDescription() {
        return description;
    }

    public Proficiency getProficiency() {
        return proficiency;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCourseID() {
        return id;
    }
}
