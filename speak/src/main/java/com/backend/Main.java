package com.backend;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import com.narration.Narrator;
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

        // Proceeding Through the Course - Module 1
        proceedThroughModule(jimUser, 1);

        // Proceeding Through the Course - Module 2
        proceedThroughModule(jimUser, 2);

        // Step 5: Jim logs out
        System.out.println("Jim logs out of the system.");
        saveData(); // Save progress before logging out
    }

    private static void proceedThroughModule(User user, int moduleNumber) {
        System.out.println("Jim is proceeding to module " + moduleNumber + "...");
        
        // Simulate learning activities with narrator

        if (moduleNumber == 1) {
            Narrator.playSound("Welcome to the first module. Today we are going to learn some Spanish words.");
            System.out.println("Jim is reviewing flashcards...");
            Narrator.playSound("Words: Hola (Hello), Adiós (Goodbye), Hasta luego (See you later), Por favor (Please), Gracias (Thank you).");
            Narrator.playSound(" Question 1. Fill in the blank: ___ means hello.\n Question 2. What does 'goodbye' mean in Spanish? A.hola B.estoy C.adiós\n Question 3. True or false 'thank you' in Spanish means gracias.\n Question 4. True or false 'see you later' means por favor in Spanish.\n Question 5. Fill in the blank: ___ ___ means please in Spanish.");
        } else {
            Narrator.playSound("Welcome to the second module. Today we are going to learn some phrases in Spanish.");
            System.out.println("Jim is reviewing flashcards...");
            Narrator.playSound("Phrases: ¿Cómo estás? (How are you?), Estoy bien (I am fine), Muchas gracias (Thank you very much), Buenas noches (Good night), ¿Qué tal? (How are you?) .");
            Narrator.playSound(" Question 1. Fill in the blank: ___ means how are you in Spanish.\n Question 2. What does I am fine mean in Spanish? A.grande B.estoy bien C.bien\n Question 3. True or false 'how are you' in Spanish means ¿Qué tal?.\n Question 4. True or false thank you very much in Spanish means estoy bien.\n Question 5. Fill in the blank: ___ ___ means good night in Spanish.");
        }

        // Simulate answering questions
        System.out.println("Jim is answering questions...");

        // Predefined answers based on the module number
        List<String> correctAnswers;
        List<String> userAnswers;

        if (moduleNumber == 1) {
            // Module 1 answers: 4 correct, 1 incorrect
            correctAnswers = List.of("Hola", "Adiós", "Por favor", "Gracias", "¿Cómo estás?");
            userAnswers = List.of("Hola", "Adiós", "Por favor", "Incorrect", "¿Cómo estás?");
        } else {
            // Module 2 answers: 3 correct, 2 incorrect
            correctAnswers = List.of("¿Cómo estás?", "Estoy bien", "Muchas gracias", "Buenas noches", "¿Qué tal?");
            userAnswers = List.of("¿Cómo estás?", "Estoy bien", "Incorrect", "Incorrect", "¿Qué tal?");
        }

        // Count correct answers
        int correctCount = 0;
        for (int i = 0; i < userAnswers.size(); i++) {
            if (userAnswers.get(i).equals(correctAnswers.get(i))) {
                correctCount++;
            }
        }

        // Calculate score
        int score = (correctCount * 100) / userAnswers.size();
        System.out.println("Jim scored " + score + "%.");

        // Update progress
        if (score >= 80 && moduleNumber == 1) {
            user.getProgressData().setCurrentModule(2); // Advance to next module
            System.out.println("Jim advances to module 2.");

        } else if (score < 80 && moduleNumber == 2) {
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
