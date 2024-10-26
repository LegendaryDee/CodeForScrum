package com.narration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.narration.Narrator;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        try {
            // Path to your JSON file
            String jsonFilePath = "json/exercises.json";
            JSONParser parser = new JSONParser();
            Scanner scanner = new Scanner(System.in);

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

            // Run through each module
            for (int moduleIndex = 0; moduleIndex < modules.size(); moduleIndex++) {
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
                    for (Object questionObj : questions) {
                        JSONObject question = (JSONObject) questionObj;
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
                    }
                }

                // Calculate and display score for the module
                double percentage = (double) correctAnswers / totalQuestions * 100;
                System.out.printf("You got %.2f%% correct in %s.\n", percentage, moduleTitle);
                Narrator.playSound("You got " + (int) percentage + " percent correct in " + moduleTitle);

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
}
