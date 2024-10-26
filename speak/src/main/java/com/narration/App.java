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

            // Get the exercises for the selected language
            JSONArray exercises = (JSONArray) languageData.get("exercises");

            // Iterate through exercises
            for (Object exerciseObj : exercises) {
                JSONObject exercise = (JSONObject) exerciseObj;

                // Narrate the exercise content
                String exerciseContent = (String) exercise.get("content");
                System.out.println("Exercise: " + exerciseContent);
                Narrator.playSound(exerciseContent);

                // Get the questions in the exercise
                JSONArray questions = (JSONArray) exercise.get("questions");
                for (Object questionObj : questions) {
                    JSONObject question = (JSONObject) questionObj;

                    // Narrate each question's text
                    String questionText = (String) question.get("text");
                    String correctAnswer = (String) question.get("correctAnswer");

                    System.out.println("Question: " + questionText);
                    Narrator.playSound(questionText);

                    // Wait for user input to answer
                    System.out.print("Your answer: ");
                    String userAnswer = scanner.nextLine();

                    // Check if the user's answer is correct
                    if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                        System.out.println("Correct!");
                        Narrator.playSound("Correct!");
                    } else {
                        System.out.println("Incorrect. The correct answer is: " + correctAnswer);
                        Narrator.playSound("Incorrect. The correct answer is " + correctAnswer);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
