package backEnd;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class DataLoader {

    private List<User> users;
    private List<Course> courses;

    public DataLoader() {
        // Initialize the data when the program starts
        this.users = loadUsers();
        this.courses = loadCourses();
    }

    // Method to load users
    private List<User> loadUsers() {
        // Mock loading from a file or database
        List<User> users = new ArrayList<>();
        // Populate users list from the data source
        return users;
    }

    // Method to load courses
    private List<Course> loadCourses() {
        // Mock loading from a file or database
        List<Course> courses = new ArrayList<>();
        // Populate courses list from the data source
        return courses;
    }

    // Public methods to retrieve loaded data
    public List<User> getUsers() {
        return users;
    }

    public List<Course> getCourses() {
        return courses;
    }

    // Optionally add methos to reload or refresh data
    public void reloadUsers() {
        this.users = loadUsers();
    }

    public void reloadCourses() {
        this.courses = loadCourses();
    }

    // Optionally provide methods to find specific users or courses 
    public User getUserById(UUID id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public Course getCourseById(UUID id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                return course;
            }
        }
        return null; // return null if course not found
    }
}
