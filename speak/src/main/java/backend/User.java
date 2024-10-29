package backend;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

public class User {
    private UUID userID;
    private String userName;
    private String password;
    private String email;
    private LanguagePreference languagePreference;
    private ProgressData progressData;
    private int streakCount;
    private ArrayList<Integer> scores;
    @SuppressWarnings("unused")
    private UUID courseID;
    private List<Course> courses;
    private List<Module> modules;
    
   
    // Constructor
    public User(UUID userID, String userName, String password, String email, LanguagePreference languagePreference, ProgressData progressData, List<Course> courses, int streakCount) {
        this.userID = UUID.randomUUID();
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.languagePreference = languagePreference;
        this.streakCount = streakCount;
        this.progressData = progressData;
        this.courses = courses;
        this.scores = new ArrayList<>();
        this.modules = new ArrayList<>();
    }

    public String getUserName() {
        return this.userName;
    }

    public void register() {
        System.out.println(userName + " has been registered.");
    }

    public void login() {
        System.out.println(userName + " has logged in.");
    }

    public boolean login(String inputUsername, String inputPassword) {
        // Logic to check username and password
        if(inputUsername.equals(this.userName) && inputPassword.equals(this.password)) {
            System.out.println("Login successful.");
            return true;
        }
        System.out.println("Login failed.");
        return false;
    }

    public void logout() {
        System.out.println(userName + " has logged out.");
    }

    public void updateProfile(String userName, String email, LanguagePreference languagePreference, int streakCount, ProgressData progressData) {
        this.userName = userName;
        this.email = email;
        this.languagePreference = languagePreference;
        this.progressData = new ProgressData(userName);
        this.streakCount = streakCount;
        System.out.println("Profile updated for " + this.userName);
    }

    public void recoverPassword() {
        System.out.println("Password recovery initiated for " + userName);
    }

    public void submitFeedBack(String feedbackText) {
        System.out.println("Feedback submitted: " + feedbackText);
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public void addScore(int score) {
        scores.add(score);
    }

    public List<Module> getModules() {
        return modules;
    }

    public int getTotalScore() {
        int total = 0;
        for(int score : scores) {
            total += score;
        }
        return total;
    }

    public UUID getId() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public ProgressData getProgressData() {
        return progressData;
    }

    public LanguagePreference getLanguagePreference() {
        return languagePreference;
    }

    public int getStreakCount() {
        return streakCount;
    }

    public String toString() {
        return "User: " + "userID= " + userID + ", userName= '" + userName + '\'' + ", email= '" + email + '\'' + 
        ", languagePreference= " + languagePreference + ", streakCount=" + streakCount + ", progressData=" + progressData + ", modules=" + modules + '}';
    }

    public String getProficiencyLevels() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getProficiencyLevels'");
    }
}

enum LanguagePreference {
    ENGLISH, SPANISH, FRENCH, GERMAN
}
