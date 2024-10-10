package backEnd;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class UserList {
    
    private ArrayList<User> users;

    public UserList() {
        this.users = new ArrayList<>();
        loadUsersFromFIle("path/to/userList.json");
    }

    private void loadUsersFromFIle(String filePath) {
        try(FileReader reader = new FileReader(filePath)) {
            JSONParser parser = new JSONParser();
            JSONArray usersArray = (JSONArray) parser.parse(reader);

            for(Object obj : usersArray) {
                JSONObject userJson = (JSONObject) obj;
                UUID userId = UUID.fromString((String) userJson.get("userID"));
                String userName = (String) userJson.get("userName");
                String password = (String) userJson.get("password");
                String email = (String) userJson.get("email");
                LanguagePreference languagePreference = LanguagePreference.fromString((String) userJson.get("languagePreference"));
                int streakCount = Integer.parseInt(userJson.get("streakCount").toString());
                String progressData = (String) userJson.get("progressData");

                User user = new User(userId, userName, password, email, languagePreference, streakCount, progressData);
                users.add(user);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        users.add(user);
        saveUsersToFile("path/to/userList.json");
    }

    public void removeUser(User user) {
        users.remove(user);
        saveUsersToFile("path/to/userList.json");
    }

    public User getUserByUsername(String username) {
        for(User user : users) {
            if(user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    private void saveUsersToFile(String filePath) {
        try(FileWriter file = new FileWriter(filePath)) {
            JSONArray usersArray = new JSONArray();
            for(User user : users) {
                JSONObject userJson = new JSONObject();
                userJson.put("userID", user.getId().toString());
                userJson.put("userName", user.getUserName());
                userJson.put("email", user.getEmail());
                userJson.put("languagePreference", user.getLanguagePreference());
                userJson.put("streakCount", user.getStreakCount());

                usersArray.add(userJson);
            }
            file.write(usersArray.toJSONString());
            file.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

