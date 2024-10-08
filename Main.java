import java.util.ArrayList;
import java.util.UUID;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
       ArrayList<User> users = DataLoader.getUsers();
       ArrayList<Course> courses = DataLoader.getCourses();
       ArrayList<ProgressData> progressData = DataLoader.getProgressData();

       for(User user : users) {
        System.out.println("User: " + user.getUserName());
       }
    }
}
