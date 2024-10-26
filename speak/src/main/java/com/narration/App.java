package com.narration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.narration.Narrator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class App {
    private static final String USER_FILE = "json/users.json"; 

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Ask for the user's username
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            // Load user record from users.json
            JSONObject currentUser = loadUser(username);
            if (currentUser == null) {
                System.out.println("User not found. Please check your username.");
                return;
            }

            // Extract progress data
            JSONObject progressData = (JSONObject) currentUser.getOrDefault("progressData", new JSONObject());

            // Initialize progress fields if not already set
            int lessonsCompleted = ((Long) progressData.getOrDefault("lessonsCompleted", 0L)).intValue();
            int attempts = ((Long) progressData.getOrDefault("attempts", 0L)).intValue();
            int score = ((Long) progressData.getOrDefault("score", 0L)).intValue();

            // Path to your JSON file
            String jsonFilePath = "json/exercises.json";
            JSONParser parser = new JSONParser();

            // Parse JSON file
            JSONObject json = (JSONObject) parser.parse(new FileReader(jsonFilePath));

            // Get the languages object
            JSONObject languages = (JSONObject) json.get("languages");

            // Display available languages and prompt user to choose one
            System.out.println("Available languages:");
            Set<String> languageKeys = languages.keySet();
            int index = 1;
            for (String language : languageKeys) {
                System.out.println(index + ". " + language);
                index++;
            }

            System.out.print("Choose a language (enter the number): ");
            int languageChoice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            // Get the selected language based on user input
            String selectedLanguage = languageKeys.toArray(new String[0])[languageChoice - 1];
            JSONObject languageData = (JSONObject) languages.get(selectedLanguage);

            System.out.println("You selected: " + selectedLanguage);
            Narrator.playSound("You selected " + selectedLanguage);

            // Get the modules for the selected language
            JSONArray modules = (JSONArray) languageData.get("modules");

            // Retrieve or initialize the current module and question index
            int currentModuleIndex = ((Long) progressData.getOrDefault("currentModule", 0L)).intValue();
            int currentQuestionIndex = ((Long) progressData.getOrDefault("currentQuestionIndex", 0L)).intValue();

            for (int moduleIndex = currentModuleIndex; moduleIndex < modules.size(); moduleIndex++) {
                JSONObject module = (JSONObject) modules.get(moduleIndex);
                String moduleTitle = (String) module.get("title");
                JSONArray exercises = (JSONArray) module.get("exercises");

                System.out.println("Starting " + moduleTitle);
                Narrator.playSound("Starting " + moduleTitle);

                int correctAnswers = 0;
                int totalQuestions = 0;

                // Iterate through exercises
                for (Object exerciseObj : exercises) {
                    JSONObject exercise = (JSONObject) exerciseObj;
                    String exerciseContent = (String) exercise.get("content");
                    JSONArray questions = (JSONArray) exercise.get("questions");

                    System.out.println("Exercise: " + exerciseContent);
                    Narrator.playSound(exerciseContent);

                    // Iterate through questions
                    for (int questionIndex = currentQuestionIndex; questionIndex < questions.size(); questionIndex++) {
                        JSONObject question = (JSONObject) questions.get(questionIndex);
                        String questionText = (String) question.get("text");
                        String correctAnswer = (String) question.get("correctAnswer");
                        JSONObject questionType = (JSONObject) question.get("questionType");
                        String typeID = (String) questionType.get("typeID");

                        System.out.println("Question: " + questionText);
                        Narrator.playSound(questionText);

                        // Display options for multiple-choice questions
                        if (typeID.equals("mcq")) {
                            JSONArray options = (JSONArray) question.get("options");
                            for (int i = 0; i < options.size(); i++) {
                                System.out.println((char) ('A' + i) + ". " + options.get(i));
                            }
                        }

                        // Wait for user input to answer
                        System.out.print("Your answer: ");
                        String userAnswer = scanner.nextLine();

                        // Check if the user's answer is correct
                        totalQuestions++;
                        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                            System.out.println("Correct!");
                            Narrator.playSound("Correct!");
                            correctAnswers++;
                        } else {
                            System.out.println("Incorrect. The correct answer is: " + correctAnswer);
                            Narrator.playSound("Incorrect. The correct answer is " + correctAnswer);
                        }

                        // Update question index in progress data
                        progressData.put("currentQuestionIndex", questionIndex + 1);
                        saveUserProgress(username, progressData);
                    }

                    // Reset question index for the next exercise
                    currentQuestionIndex = 0;
                }

                // Update module index in progress data
                progressData.put("currentModule", moduleIndex + 1);

                // Calculate and display score for the module
                double percentage = (double) correctAnswers / totalQuestions * 100;
                System.out.printf("You got %.2f%% correct in %s.\n", percentage, moduleTitle);
                Narrator.playSound("You got " + (int) percentage + " percent correct in " + moduleTitle);

                // Update overall score and progress
                score = (score * lessonsCompleted + (int) percentage) / (lessonsCompleted + 1); // Update the cumulative score
                lessonsCompleted++;
                attempts += totalQuestions;

                // Save updated progress data
                progressData.put("lessonsCompleted", lessonsCompleted);
                progressData.put("attempts", attempts);
                progressData.put("score", score);
                saveUserProgress(username, progressData);

                // Ask if the user wants to proceed to the next module
                if (moduleIndex < modules.size() - 1) {
                    System.out.print("Do you want to proceed to the next module? (yes/no): ");
                    String proceed = scanner.nextLine();
                    if (!proceed.equalsIgnoreCase("yes")) {
                        break;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Load a specific user record from users.json
    private static JSONObject loadUser(String username) {
        try (FileReader reader = new FileReader(USER_FILE)) {
            JSONParser parser = new JSONParser();
            JSONArray usersArray = (JSONArray) parser.parse(reader);

            System.out.println("Loaded users from file: " + usersArray.toJSONString());  // Debugging statement

            for (Object userObj : usersArray) {
                JSONObject user = (JSONObject) userObj;
                System.out.println("Checking user: " + user.get("userName"));  // Debugging statement

                if (user.get("userName").equals(username)) {
                    System.out.println("User found: " + user.get("userName"));  // Debugging statement
                    return user;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        System.out.println("User not found: " + username);  // Debugging statement
        return null;
    }

    // Save progress for a specific user to users.json
    private static void saveUserProgress(String username, JSONObject progressData) {
        try (FileReader reader = new FileReader(USER_FILE)) {
            JSONParser parser = new JSONParser();
            JSONArray usersArray = (JSONArray) parser.parse(reader);

            for (Object userObj : usersArray) {
                JSONObject user = (JSONObject) userObj;
                if (user.get("userName").equals(username)) {
                    user.put("progressData", progressData);
                    break;
                }
            }

            // Create Gson instance with pretty printing
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String prettyJson = gson.toJson(usersArray);

            // Write updated data back to users.json
            try (FileWriter writer = new FileWriter(USER_FILE)) {
                writer.write(prettyJson);
                writer.flush();
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
