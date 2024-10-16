package backEnd;

import java.util.List;
import java.util.ArrayList;

public class UserList {
    private List<User> users;

    public UserList() {
        users = DataLoader.getUsers(); // Load users using DataLoader
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
        DataWriter.saveUsers(users); // Save updated list to the data source
    }
}
