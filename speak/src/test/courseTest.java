import static org.junit.jupiter.api.Assertions.*;
import com.narration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Test;

public class courseTest {
    @Test
    public Course(UUID id, Language selectedLanguage, String title, String lesson, String description, Proficiency proficiency) {

    }
    @Test
    public Course(UUID id, String title, String description) {

    }
    @Test
    public void startLesson() {

    }
    @Test
    public void completeLesson() {

    }
    @Test
    public void saveProgress(int userID) {

    }
    @Test
    public void revisitSavedProgress(int userID) {

    }
    @Test
    public void addTopic(Topic topic) {

    }
    @Test
    public void setScore(int score) {

    }
    @Test
    public int getScore() {
        return score;
    }
    @Test
    public ArrayList<Topic> getTopics() {

    }
    @Test
    public String getTitle() {
        return title;

    }
    @Test
    public void addLesson(Lesson lesson) {

    }
    @Test
    public ArrayList<Lesson> getLessons() {

    }
    @Test
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
            @Test
            public Lesson getSpotInCourse(UUID lessonId) {

    }
    @Test
    public String getDescription() {
        return description;

    }
    @Test
    public Language getLanguage() {

    }
    @Test
    public Proficiency getProficiency() {

    }
    @Test
    public UUID getId() {

    }
    @Test
    public UUID getCourseID() {

    }
}
