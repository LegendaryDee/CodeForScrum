package com.narration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App {

    public static void main(String[] args) {
        StringBuilder jsonContent = new StringBuilder();
        String jsonFilePath = "json/courses.json";
    
            try(BufferedReader br = new BufferedReader(new FileReader(jsonFilePath))) {
                String line;
                while((line = br.readLine()) != null) {
                    jsonContent.append(line);
                }

                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(jsonContent.toString());


                JSONArray prompts = (JSONArray) json.get("prompts");
                for(Object obj : prompts) {
                    String prompt = (String) obj;
                    System.out.println("Narrating prompt: " + prompt);
                    Narrator.playSound(prompt);
                }

                JSONArray lessons = (JSONArray) json.get("lessons");
                for(Object obj : lessons) {
                    String lesson = (String) obj;
                    System.out.println("Narrating lesson: " + lesson);
                    Narrator.playSound(lesson);
                }

        } catch (IOException e) {
            e.printStackTrace();
        }catch (ParseException e) {
            System.out.println("Failed to parse JSON: " + e.getMessage());
        }
    }
}
