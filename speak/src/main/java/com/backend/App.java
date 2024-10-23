package com.backend;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.narration.Narrator;


public class App {

    public static void main(String[] args) {

    	final String FILE_NAME_COURSES = "json/courses.json";
    	try {
            // Adjusted path to your JSON file in the json folder
            // String jsonFilePath = "json/courses.json";
            //String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

            FileReader reader = new FileReader(FILE_NAME_COURSES);
            
            JSONParser jsonParser = new JSONParser();
            // Parse the JSON array from the file
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject  = (JSONObject) obj;
            
            // Read and narrate prompts
            JSONArray prompts = (JSONArray) jsonObject.get("prompts");
            for (int i = 0; i < prompts.size(); i++) {
                String prompt = prompts.get(i).toString();
                System.out.println("Narrating prompt: " + prompt);
                Narrator.playSound(prompt);  // Use your existing Narrator class
            }

            // Read and narrate lessons
            JSONArray lessons = (JSONArray)jsonObject.get("lessons");
            for (int i = 0; i < lessons.size(); i++) {
                String lesson = lessons.get(i).toString();
                System.out.println("Narrating lesson: " + lesson);
                Narrator.playSound(lesson);  // Use your existing Narrator class
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
