package backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Course {
    private UUID id;
    private String title;
    private String description;
    private List<Lesson> lessons;
    private ArrayList<Topic> topics;
    private Proficiency proficiency;
    private int score;
    private int currentLessonIndex = 0;
    private Language selectedLanguage;
    
    
    public Course(UUID id, Language selectedLanguage, String title, List<Lesson> lessons, String description, Proficiency proficiency) {
        this.id = id;
        this.title = title;
        this.lessons = lessons;
        this.description = description;
        this.topics = new ArrayList<>();
        this.proficiency = proficiency;
        this.selectedLanguage = selectedLanguage;
        this.score = 0;
    }
    
    
    public Course(UUID id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
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

    public List<Lesson> getLessons() {
        return lessons;
    }
    
    public void setLessons(List<Lesson> lessons) {
    	if(this.lessons == null) {
    		this.lessons = new ArrayList<Lesson>();
    	}
		this.lessons = lessons;
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

    public UUID getCourseID() {
        return id;
    }
}
