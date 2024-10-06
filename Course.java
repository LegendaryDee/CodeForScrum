import java.util.List;

public class Course {
    public String courseID;
    public List<String> topicVocabulary;
    public List<String> topicSentenceMaking;
    public List<Audio> listeningSection;
    public GamifiedAssessment gamifiedAssessmentOption;

    // Constructor
    public Course(String courseID, List<String> topicVocabulary, List<String> topicSentenceMaking, List<Audio> listeningSection, GamifiedAssessment gamifiedAssessmentOption) {
        this.courseID = courseID;
        this.topicVocabulary = topicVocabulary;
        this.topicSentenceMaking = topicSentenceMaking;
        this.listeningSection = listeningSection;
        this.gamifiedAssessmentOption = gamifiedAssessmentOption;
    }

    // Method to get the course ID
    public String getCourseID() {
        return this.courseID;
    }

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
}
