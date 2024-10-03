import java.util.List;

public class Course {
    private List<String> topicVocabulary;
    private List<String> topicSentenceMaking;
    public List<Audio> listeningSection;
    private GamifiedAssessment gamifiedAssessmentOption;

    public void startLesson() {
        // Logic to start lesson
    }

    public void completeLesson() {
        // Logic to complete lesson
    }

    public void saveProgress(int userID) {
        // Logic to save progress
    }

    public void revisitSavedProgress(int userID) {
        // Logic to revisit saved progress
    }

    public Object getCourseID() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCourseID'");
    }
}
