package com.backend;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static UserList instance;
    private List<User> users;

    // Private constructor for Singleton pattern
    @SuppressWarnings("static-access")
    UserList() {
        // Load users using DataLoader
        DataLoader dataLoader = new DataLoader();
        this.users = dataLoader.getUsers();
        
        // If no users are loaded, initialize with an empty list
        if (this.users == null) {
            this.users = new ArrayList<>();
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
        return this.users;
    }

    // Method to get a user by username
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;  // If no user is found, return null
    }

    @SuppressWarnings("static-access")
    public void addUser(User user) {
        users.add(user);
        // Save updated user list to the data source
        DataWriter dataWriter = new DataWriter();
        dataWriter.saveUsers(users);
    }
}
