package com.backend;
import java.util.List;
import java.util.UUID;
import com.narration.Narrator;
public class Main2 {
    public static void main(String[] args) {
                // Step 1: Check if Jim is in users.json
        System.out.println("Checking if Jim Smith is in users.json...");
        User jimUser = UserList.getInstance().getUser("jimsmith");
        if (jimUser == null) {
            System.out.println("Jim Smith is not found in users.json.");
            
            // Step 2: Create new user account
            System.out.println("Creating a new user account for Jim Smith...");
            jimUser = new User(UUID.randomUUID(), "jimsmith", "password123", "jim@example.com", LanguagePreference.SPANISH, new ProgressData(UUID.randomUUID().toString()), 1);
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
            System.out.println("Jim is reading a story and reviewing flashcards...");
            Narrator.playSound("Words: Hola (Hello), Adiós (Goodbye), Por favor (Please), Gracias (Thank you).");
        } else {
            Narrator.playSound("Welcome to the second module. Today we are going to learn some phrases in Spanish.");
            System.out.println("Jim is reading a story and reviewing flashcards...");
            Narrator.playSound("Phrases: ¿Cómo estás? (How are you?), Estoy bien (I am fine), Muchas gracias (Thank you very much), Buenas noches (Good night), ¿Qué tal? (How are you?) .");
        }

        // Simulate answering questions
               List<Question> questions;
        if (moduleNumber == 1) {
            questions = List.of(
                new Question("What does 'Hola' mean?", List.of("Hello", "Goodbye", "Please"), 0, QuestionType.MULTIPLE_CHOICE),
                new Question("Translate 'Por favor':", List.of("Please", "Thank you", "Hello"), 0, QuestionType.FILL_IN_THE_BLANK),
                new Question("True or False: 'Adiós' means 'Goodbye'.", List.of("True", "False"), 0, QuestionType.TRUE_FALSE)
            );
        } else {
            questions = List.of(
                new Question("What does '¿Cómo estás?' mean?", List.of("How are you?", "I am fine", "Thank you"), 0, QuestionType.MULTIPLE_CHOICE),
                new Question("Translate 'Buenas noches':", List.of("Good morning", "Good night", "Hello"), 1, QuestionType.FILL_IN_THE_BLANK),
                new Question("True or False: 'Estoy bien' means 'I am sad'.", List.of("True", "False"), 1, QuestionType.TRUE_FALSE)
            );
        }

        // Simulate answering questions
        int correctCount = 0;
        for (Question question : questions) {
            String userAnswer = getUserAnswer(question); // Simulate getting user answer
            if (question.checkAnswer(userAnswer)) {
                correctCount++;
            }
        }

        // Calculate score
        int score = (correctCount * 100) / questions.size();
        System.out.println("Jim scored " + score + "%.");

        // Update progress
        if (score >= 80 && moduleNumber == 1) {
            user.getProgressData().setCurrentModule(2); // Advance to next module
            System.out.println("Jim advances to module 2.");
        } else if (score < 80 && moduleNumber == 2) {
            System.out.println("Jim does not advance to the next module.");
        }
    }

    private static String getUserAnswer(Question question) {
        // Simulated answers based on the question type
        if (question.getQuestionType() == Question.MULTIPLE_CHOICE) {
            return question.getCorrectAnswer(); // Always return the correct answer for simulation
        } else if (question.getQuestionType() == Question.FILL_IN_THE_BLANK) {
            return question.getCorrectAnswer(); // Always return the correct answer for simulation
        } else { // TRUE_FALSE
            return "True"; // Simulate true answer for this question
        }
    }

    private static void saveData() {
        // Save users to users.json
        List<User> users = UserList.getInstance().getUsers();
        DataWriter.saveUsers(users);
        System.out.println("Users.json updated successfully.");
    }
}
