import static org.junit.jupiter.api.Assertions.*;
import com.narration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Test;

public class assessmentTest {
    
    @Test
    public Assessment(String assessmentID, String title, String description) {

    }
    @Test
    private int generateRandomScore(int minimum, int maximum) {
        Random random = new Random();
        return random.nextInt(maximum - minimum + 1) + minimum;
    }
    @Test
    public int giveAssessment(String userID) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Starting Assessment: " + title);
        System.out.println("Description: " + description);
        System.out.println("Answer the following questions:\n");

        for (Question question : exercises) {
            System.out.println(question.getQuestionText());
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (question.checkAnswer(userAnswer)) {
                score++;
            }
        }

        System.out.println("\nAssessment complete! Your score: " + score + "/" + exercises.size());
        return score;
    }
    @Test
    public String getAssessmentID() {
        return assessmentID;
    }
    @Test
    public ArrayList<Question> getExercises() {

    }
    @Test
    public ArrayList<Proficiency> getProficiencyLevels() {

    }
    @Test
    public ArrayList<Question> getQuestions() {

    }
    @Test
    public UUID getId() {

    }
    @Test
    public String getTitle() {
        return title;
    }
    @Test
    public int getTotalScore() {
        return totalScore;
    }
}
