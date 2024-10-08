import java.util.List;
public class Course {
    public String courseID;
    public List<String> topicVocabulary;
    public List<String> topicSentenceMaking;
    public List<Audio> listeningSection;
    public GamifiedAssessment gamifiedAssessmentOption;

    public Course(String courseID, List<String> topicVocabulary, List<String> topicSentenceMaking, List<Audio> listeningSection, GamifiedAssessment gamifiedAssessmentOption) {
        this.courseID = courseID;
        this.topicVocabulary = topicVocabulary;
        this.topicSentenceMaking = topicSentenceMaking;
        this.listeningSection = listeningSection;
        this.gamifiedAssessmentOption = gamifiedAssessmentOption;
    }

    public String getCourseID() {
        return this.courseID;
    }

    public void startLesson() {
        System.out.println("Lesson has startd.");
    }

    public void completeLesson() {
        System.out.println("Lesson has been completed.");
    }

    public void saveProgress(int userID) {
        System.out.println("Progress saved for user ID: " + userID);
    }

    public void revisitSavedProgress(int userID) {
        System.out.println("Revisiting saved progress for user ID: " + userID);
    }

    public List<String> getTopicVocabulary() {
        return topicVocabulary;
    }

    public void setTopicVocabulary(List<String> topicVocabulary) {
        this.topicVocabulary = topicVocabulary;
    }

    public List<String> getTopicSentenceMaking() {
        return topicSentenceMaking;
    }

    public void setTopicSentenceMaking(List<String> topicSentenceMaking) {
        this.topicSentenceMaking = topicSentenceMaking;
    }

    public List<Audio> getListeningSection() {
        return listeningSection;
    }

    public void setListeningSection(List<Audio> listeningSection) {
        this.listeningSection = listeningSection;
    }

    public GamifiedAssessment getGamifiedAssessmentOption() {
        return gamifiedAssessmentOption;
    }

    public void setGamifiedAssessmentOption(GamifiedAssessment gamifiedAssessmentOption) {
        this.gamifiedAssessmentOption = gamifiedAssessmentOption;
    }
}
