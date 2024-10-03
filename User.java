import java.util.UUID;

public class User {
    private UUID userID;
    private String userName;
    private String password;
    private String email;
    private Language languagePreference;
    private ProgressData progressData;
    private int streakCount;

    public void register() {
        // Registration logic
    }

    public void login() {
        // Login logic
    }

    public void logout() {
        // Logout logic
    }

    public void updateProfile(String userName, String email, Language languagePreference, ProgressData progressData, int streakCount) {
        // Update profile logic
    }

    public void recoverPassword() {
        // Password recovery logic
    }
}
