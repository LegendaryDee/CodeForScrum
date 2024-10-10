package backEnd;
import java.util.List;
public class Assessment {
    private String assessmentID;
    private List<String> proficiencyLevels;  // List of possible proficiency levels
    private List<Question> questions;        // List of questions in the assessment

    // Constructor
    public Assessment(String assessmentID, List<String> proficiencyLevels, List<Question> questions) {
        this.assessmentID = assessmentID;
        this.proficiencyLevels = proficiencyLevels;
        this.questions = questions;
    }

    // Method to give an assessment and return a proficiency level based on user's performance
    public String giveAssessment(String userID) {
        // Logic for giving an assessment
        System.out.println("Giving assessment to user: " + userID);

        // Placeholder logic for determining proficiency level based on the assessment (for now, returning first level)
        return proficiencyLevels.get(0);
    }

    // Getters for assessment properties
    public String getAssessmentID() {
        return assessmentID;
    }

    public List<String> getProficiencyLevels() {
        return proficiencyLevels;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
