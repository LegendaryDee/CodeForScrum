package backEnd;
public class ProgressData {
    public int lessonsCompleted;
    public int attempts;
    public int score;
    public String userID;

    public void PogressData(String userID) {// use arrayList of progressData objects
        this.userID = userID;
        this.lessonsCompleted = 0;
        this.attempts = 0;
        this.score = 0;
    }

    public ProgressData getCurrentProgress(String userID) {
        System.out.println("Retrieving current progress for user ID: " + userID);
        return this;
    }

    public void updateProgress(int lessonsCompleted, int attempts, int score) {
        this.lessonsCompleted += lessonsCompleted;
        this.attempts += attempts;
        this.score += score;
        System.out.println("Progress updated for user ID: " + userID);
    }

    public void trackProgress() {
        System.out.println("Tracking progress for user ID: " + userID);
    }

    public void saveProgress() {
        System.out.println("Progress saved for user ID: " + userID);
    }

    public int getLessonsCompleted() {
        return lessonsCompleted;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getScore() {
        return score;
    }

    public String getUserID() {
        return userID;
    }

    public String toString() {
        return String.format("ProgressData{userID = '%s', lessonsCompleted = %d, attempts = %d, score = %d}", userID, lessonsCompleted, attempts, score);
    }
}
