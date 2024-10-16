package backEnd;

import java.util.UUID;

public class Lesson {
    private String title;
    private String content;
    private UUID id;
    private int duration;

    public Lesson(String title, String content, int duration) {
        this.title = title;
        this.content = content;
        this.id = UUID.randomUUID();
        this.duration = duration;
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

    public UUID getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public String getLessonID() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLessonID'");
    }
}
