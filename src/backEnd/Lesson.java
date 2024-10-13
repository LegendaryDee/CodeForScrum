package backEnd;
import java.util.UUID;

public class Lesson {
    private String title;
    private String content;
    private UUID id;

    public Lesson(String title, String content) {
        this.title = title;
        this.content = content;
        this.id = UUID.randomUUID();
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
}
