package com;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.User;
import backend.UserList;

public class userListTest {
    private static UserList instance;
    private List<User> users;

     @Test
    public static synchronized UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }
    
    @Test
    public List<User> getUsers() {
        return this.users;
    }
    @Test
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;  // If no user is found, return null
    }
    
    @Test
    public void addUser() {

    }
}
