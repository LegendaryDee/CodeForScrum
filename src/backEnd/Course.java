package backEnd;

import java.util.ArrayList;
import java.util.UUID;
import java.io.BufferedReader;
import java.io.FileReader;

public class Course {
    private UUID id;
    private UUID courseId;
    private String title;
    private String description;
    private ArrayList<Lesson> lessons;
    private ArrayList<Topic> topics;
    private Proficiency proficiency;
    private int score;
    private int currentLessonIndex = 0;
    private Language selectedLanguage;

    public Course(UUID courseId, Language selectedLanguage, String title, String lesson, String description, Proficiency proficiency) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.lessons = new ArrayList<>();
        this.description = description;
        this.topics = new ArrayList<>();
        this.proficiency = proficiency;
        this.selectedLanguage = selectedLanguage;
        this.score = 0;
        this.courseId = courseId;
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

    public String getCoursesJson() {
        StringBuilder json = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader("courses.json"))) {
            String line;
            while((line = reader.readLine()) != null) {
                json.append(line);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        return json.toString();
    }       
            
            public Lesson getSpotInCourse(UUID lessonId) {
                for(Lesson lesson: lessons) {
                    if(lesson.getId().equals(lessonId)) {
                        return lesson;
                    }
                }
                return null;
            }
        
    

    public String getDescription() {
        return description;
    }

    public Language getLanguage() {
        return selectedLanguage;
    }

    public Proficiency getProficiency() {
        return proficiency;
    }

    public UUID getId() {
        return id;
    }

    public String getCourseID() {
        return courseId.toString();
    }
}
