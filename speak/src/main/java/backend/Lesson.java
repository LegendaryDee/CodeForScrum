package backend;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Lesson {
    private String title;
    private String content;
    private UUID id;
    private int duration;
    private UUID lessonID;
    private List<Topic> topics;

    public Lesson(UUID lessonID, String title, String content, int duration) {
        this.title = title;
        this.content = content;
        this.id = UUID.randomUUID();
        this.lessonID = lessonID;
        this.duration = duration;
    }

    public Lesson(String title, String content) {
        this.title = title;
        this.content = content;
    }
    
    public Lesson(UUID uuId, String content) {
        this.id = uuId;
        this.content = content;
    }

    public void startLesson() {
        System.out.println("Starting lesson: " + title);
    }

    public void completeLesson() {
        System.out.println("Completing lesson: " + title);
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<Topic> getTopics() {
        return topics;
    }
    
    
    public void setTopics(List<Topic> topics) {
	    if(this.topics == null) {
	    	this.topics = new ArrayList<Topic>();
	    }
    	this.topics = topics;
	}

	public UUID getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public String getLessonID() {
        return lessonID.toString();
    }

    public String toString() {
        return "Lesson{" +
         "id=" + id + ", title='" + title + '\'' + ", content='" + content + '\'' + ", duration=" + duration + '}';
    }
}
