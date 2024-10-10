package backEnd;
import java.util.UUID;

public class User {
    private UUID userID;
    private String userName;
    private String password;
    private String email;
    private LanguagePreference languagePreference;
    private ProgressData progressData;
    private int streakCount;

    // Constructor
    public User(UUID userID, String userName, String password, String email, LanguagePreference languagePreference, ProgressData progressData, int streakCount) {
        this.userID = UUID.randomUUID();
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.languagePreference = languagePreference;
        this.streakCount = streakCount;
        this.progressData = progressData;
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
        return this.userName.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public void logout() {
        System.out.println(userName + " has logged out.");
    }

    public void updateProfile(String userName, String email, LanguagePreference languagePreference, ProgressData progressData, int streakCount) {
        this.userName = userName;
        this.email = email;
        this.languagePreference = languagePreference;
        this.progressData = progressData;
        this.streakCount = streakCount;
        System.out.println("Profile updated for " + this.userName);
    }

    public void recoverPassword() {
        System.out.println("Password recovery initiated for " + userName);
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
        ", languagePreference= " + languagePreference + ", streakCount=" + streakCount + ", progressData=" + progressData + '}';
    }
    }

    enum LanguagePreference {
        ENGLISH, SPANISH, FRENCH, GERMAN
    }
