package backEnd;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static UserList instance;
    private List<User> users;

    // Private constructor for Singleton pattern
    UserList() {
        // Load users using DataLoader
        DataLoader dataLoader = new DataLoader();
        users = dataLoader.getUsers();
        
        // If no users are loaded, initialize with an empty list
        if (users == null) {
            users = new ArrayList<>();
        }
    }

    // Synchronized to ensure thread-safety in multithreaded environments
    public static synchronized UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        return null; // Return null if user not found
    }

    public void addUser(User user) {
        users.add(user);
        // Save updated user list to the data source
        DataWriter dataWriter = new DataWriter();
        dataWriter.saveUsers(users);
    }
}
