package backEnd;
import java.util.UUID;
import java.util.List;
public class Exercise {
    public String exerciseID;
    public String difficultyLevel;
    private List<Question> questions;
    private String description;
    private UUID id;
    private boolean isCompleted;

    public Exercise(String description, String difficultyLevel, String difficulty, String content, List<Question> questions2) {
        this.description = description;
        this.difficultyLevel = difficultyLevel;
        this.id = UUID.randomUUID();
        this.isCompleted = false;
    }

    public void completeExercise() {
        this.isCompleted = true;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public String getExercise() {
        return String.format("Description: %s, Difficulty Level: %d, Completed: %s", description, difficultyLevel, isCompleted ? "Yes" : "No");
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
