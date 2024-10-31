package backend;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import com.narration.Narrator;
@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
            // Step 1: Check if Jim is in users.json
        System.out.println("Checking if Jim Smith is in users.json...");
        User jimUser = UserList.getInstance().getUser("jimsmith");
        if (jimUser == null) {
            System.out.println("Jim Smith is not found in users.json.");
            
            // Step 2: Create new user account
            System.out.println("Creating a new user account for Jim Smith...");
            jimUser = new User(UUID.randomUUID(), "jimsmith", "password123", "jim@gmail.com", LanguagePreference.SPANISH, new ProgressData(UUID.randomUUID().toString()), 1);
            
            // Add modules to the user
            jimUser.addModule(new Module("Module 1"));
            jimUser.addModule(new Module("Module 2"));
            
            UserList.getInstance().addUser(jimUser);
            System.out.println("Account created successfully for Jim Smith.");
            
            // Show updated users.json
            saveData();
        }

        // Step 3: Log out (just to simulate the flow)
        System.out.println("Jim logs out of the system.");
        
        // Step 4: Log in
        System.out.println("Jim logs in to the system...");
        if (jimUser.login("jimsmith", "password123")) {
            System.out.println("Login successful. Welcome, Jim!");
        }

        // Proceeding Through the Course - Modules
        for (Module module : jimUser.getModules()) {
            proceedThroughModule(jimUser, module);
        }

        // Step 5: Jim logs out
        System.out.println("Jim logs out of the system.");
        saveData(); // Save progress before logging out
    }

    private static void proceedThroughModule(User user, Module module) {
        System.out.println("Jim is proceeding to " + module.getName() + "...");
        
        // Simulate learning activities with narrator
        if (module.getName().equals("Module 1")) {
            Narrator.playSound("Welcome to the first module. Today we are going to learn some Spanish words.");
            System.out.println("Jim is reviewing flashcards...");
            Narrator.playSound("Words: Hola (Hello), Adiós (Goodbye), Hasta luego (See you later), Por favor (Please), Gracias (Thank you).");
        } else {
            Narrator.playSound("Welcome to the second module. Today we are going to learn some phrases in Spanish.");
            System.out.println("Jim is reviewing flashcards...");
            Narrator.playSound("Phrases: ¿Cómo estás? (How are you?), Estoy bien (I am fine), Muchas gracias (Thank you very much), Buenas noches (Good night), ¿Qué tal? (How are you?) .");
        }

        // Simulate answering questions
        System.out.println("Jim is answering questions...");

        List<String> correctAnswers;
        List<String> userAnswers;

        if (module.getName().equals("Module 1")) {
            correctAnswers = List.of("Hola", "Adiós", "Por favor", "Gracias", "¿Cómo estás?");
            userAnswers = List.of("Hola", "Adiós", "Por favor", "Incorrect", "¿Cómo estás?");
        } else {
            correctAnswers = List.of("¿Cómo estás?", "Estoy bien", "Muchas gracias", "Buenas noches", "¿Qué tal?");
            userAnswers = List.of("¿Cómo estás?", "Estoy bien", "Incorrect", "Incorrect", "¿Qué tal?");
        }

        int correctCount = 0;
        for (int i = 0; i < userAnswers.size(); i++) {
            if (userAnswers.get(i).equals(correctAnswers.get(i))) {
                correctCount++;
            }
        }

        int score = (correctCount * 100) / userAnswers.size();
        System.out.println("Jim scored " + score + "%.");

        // Update progress
        if (score >= 80 && module.getName().equals("Module 1")) {
            user.getProgressData().setCurrentModule(2); // Advance to next module
            System.out.println("Jim advances to module 2.");
        } else if (score < 80 && module.getName().equals("Module 2")) {
            System.out.println("Jim does not advance to the next module.");
        }
    }

    private static void saveData() {
        // Save users to users.json
        List<User> users = UserList.getInstance().getUsers();
        DataWriter.saveUsers(users);
        System.out.println("Users.json updated successfully.");
        displayUsersJson();
    }

    private static void displayUsersJson() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("users.json"));
            System.out.println("Current contents of users.json:");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading users.json: " + e.getMessage());
        }
    }
}

// Module class definition
class Module {
    private String name;

    public Module(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
