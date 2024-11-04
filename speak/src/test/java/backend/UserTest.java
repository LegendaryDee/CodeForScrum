package backend;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.UUID;

public class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User(
                UUID.randomUUID(),
                "testUser",
                "password123",
                "test@example.com",
                new LanguagePreference("English"),
                new ProgressData("testUser"),
                5);
    }

    @Test
    public void testLoginSuccess() {
        assertTrue(user.login("testUser", "password123"), "Login should succeed with correct username and password.");
    }

    @Test
    public void testLoginFailure() {
        assertFalse(user.login("testUser", "wrongPassword"), "Login should fail with incorrect password.");
    }

    @Test
    public void testUpdateProfile() {
        user.updateProfile("updatedUser", "updated@example.com", new LanguagePreference("Spanish"), 10,
                new ProgressData("updatedUser"));

        assertEquals("updatedUser", user.getUserName(), "Username should be updated.");
        assertEquals("updated@example.com", user.getEmail(), "Email should be updated.");
        assertEquals("Spanish", user.getLanguagePreference().getLanguage(), "Language preference should be updated.");
        assertEquals(10, user.getStreakCount(), "Streak count should be updated.");
    }

    @Test
    public void testAddScore() {
        user.addScore(100);
        user.addScore(50);

        assertEquals(150, user.getTotalScore(), "Total score should be the sum of all scores.");
    }

    @Test
    public void testAddModule() {
        Module module = new Module("Intro to Java");
        user.addModule(module);

        assertTrue(user.getModules().contains(module), "Added module should be in the modules list.");
    }

    @Test
    public void testRecoverPassword() {
        assertDoesNotThrow(() -> user.recoverPassword(), "recoverPassword should not throw an exception.");
    }

    @Test
    public void testSubmitFeedback() {
        assertDoesNotThrow(() -> user.submitFeedBack("Great app!"), "submitFeedBack should not throw an exception.");
    }
}