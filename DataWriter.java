import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataWriter {

    public DataWriter() {
    }

    public boolean saveUsers(List<User> users) {
        try (FileWriter writer = new FileWriter("users_data.txt")) {
            for (User user : users) {
                writer.write(user.toString() + "\n");  
            }
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred while saving users: " + e.getMessage());
            return false;
        }
    }

    public boolean saveCourses(List<Course> courses) {
        try (FileWriter writer = new FileWriter("courses_data.txt")) {
            for (Course course : courses) {
                writer.write(course.toString() + "\n");  
            }
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred while saving courses: " + e.getMessage());
            return false;
        }
    }
}
