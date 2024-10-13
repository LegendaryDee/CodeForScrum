package backEnd;
import java.util.ArrayList;
import java.util.UUID;
public class Course {
    private UUID id;
    private String title;
    private String description;
    private ArrayList<Topic> topics;
    private int currentLessonIndex = 0;

    public Course(String title, String description) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.topics = new ArrayList<>();
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

    public ArrayList<Topic> getTopics() {
        return topics;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCourseID() {
        return id;
    }
}
