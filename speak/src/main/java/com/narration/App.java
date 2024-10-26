package com.narration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.narration.Narrator;
import java.io.FileReader;
import java.util.Map;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        try {
            // Path to your JSON file
            String jsonFilePath = "json/exercises.json";
            JSONParser parser = new JSONParser();

            // Parse JSON file
            JSONObject json = (JSONObject) parser.parse(new FileReader(jsonFilePath));

            // Get the languages object
            JSONObject languages = (JSONObject) json.get("languages");

            // Iterate through each language
            Set<Map.Entry<String, JSONObject>> languageEntries = languages.entrySet();
            for (Map.Entry<String, JSONObject> languageEntry : languageEntries) {
                String language = languageEntry.getKey();
                System.out.println("Narrating language: " + language);
                Narrator.playSound("Language: " + language);

                // Get the exercises for the current language
                JSONObject languageData = languageEntry.getValue();
                JSONArray exercises = (JSONArray) languageData.get("exercises");

                // Iterate through exercises
                for (Object exerciseObj : exercises) {
                    JSONObject exercise = (JSONObject) exerciseObj;

                    // Narrate the exercise content
                    String exerciseContent = (String) exercise.get("content");
                    System.out.println("Exercise: " + exerciseContent);
                    Narrator.playSound("Exercise: " + exerciseContent);

                    // Get the questions in the exercise
                    JSONArray questions = (JSONArray) exercise.get("questions");
                    for (Object questionObj : questions) {
                        JSONObject question = (JSONObject) questionObj;

                        // Narrate each question's text
                        String questionText = (String) question.get("text");
                        System.out.println("Question: " + questionText);
                        Narrator.playSound("Question: " + questionText);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
