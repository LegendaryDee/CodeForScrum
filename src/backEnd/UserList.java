package backEnd;
import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static UserList instance;
    private List<User> users;

    UserList() {
        users = new ArrayList<>(); // Load users using DataLoader
    }

    public static UserList getInstance() {
        if(instance == null) {
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
        DataWriter.saveUsers(); // Save updated list to the data source
    }
}
