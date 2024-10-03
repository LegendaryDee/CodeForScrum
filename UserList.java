import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public User findUser(String username) {
        // Logic to find user by username
        return users.stream().filter(user -> user.getUserName().equals(username)).findFirst().orElse(null);
    }

    public List<User> getUsers() {
        return users;
    }
}
