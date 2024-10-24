package com.backend;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriterTest {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("name", "Alice");
        obj.put("age", 30);
        try (FileWriter file = new FileWriter("Test.json")) {
            file.write(obj.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
  }
}
