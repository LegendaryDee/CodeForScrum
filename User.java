import java.util.UUID;

public class User {
    private UUID userID;
    private String userName;
    private String password; // In production, passwords should be hashed!
<<<<<<< HEAD
    private String email;
    private LanguagePreference languagePreference;
    private ProgressData progressData;
    private int streakCount;
=======
    public String email;
    public Language languagePreference;
    public ProgressData progressData;
    public int streakCount;
>>>>>>> 95323397a1ac27d1b198df0b8cce3dbe72b6d40e

    // Constructor
    public User(UUID userID, String userName, String password, String email, LanguagePreference languagePreference, ProgressData progressData, int streakCount) {
        this.userID = UUID.randomUUID();
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.languagePreference = languagePreference;
        this.streakCount = 0;
        this.progressData = new ProgressData();
    }

    // Method to get the username
    public String getUserName() {
        return this.userName;
    }

    public void register() {
        // Registration logic
    }

    public boolean login(String inputUsername, String inputPassword) {
        // Logic to check username and password
        return this.userName.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public void logout() {
        // Logic to log the user out
    }

    public void updateProfile(String userName, String email, LanguagePreference languagePreference, ProgressData progressData, int streakCount) {
        this.userName = userName;
        this.email = email;
        this.languagePreference = languagePreference;
        this.progressData = progressData;
        this.streakCount = streakCount;
    }

    public void recoverPassword() {
        // Password recovery logic
    }
}
