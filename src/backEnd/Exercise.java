package backEnd;
import java.util.List;
public class Exercise {
    public String exerciseID;
    public String type;
    public String difficulty;
    public String content;
    private List<Question> questions;

    public void completeExercise() {
        // Logic for completing the exercise
    }

    public void trackProgress() {
        // Logic for tracking progress
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }
}
