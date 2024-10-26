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
        this.users = DataLoader.getUsers();
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
    	if(this.users == null) {
    		this.users = new ArrayList<>();
    	}
        return this.users;
    }

    public User getUser(String username) {
        User finalUser = null;
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                finalUser = user;
                break;
            }
        
        }
        return finalUser; // Return final user if found otherwise null if user not found
    }

    @SuppressWarnings("static-access")
    public void addUser(User user) {
         this.getUsers().add(user);
        // Save updated user list to the data source
        new DataWriter().saveUsers(users);;
       
    }
}
