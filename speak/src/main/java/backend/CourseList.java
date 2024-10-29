package backend;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CourseList{
    private static CourseList instance;
    private List<Course> courses;

// Constructor
@SuppressWarnings("static-access")
public CourseList() {
      // Load users using DataLoader
      DataLoader dataLoader = new DataLoader();
      this.courses= dataLoader.loadCourses();
      
      // If no users are loaded, initialize with an empty list
      if (this.courses == null) {
          this.courses = new ArrayList<>();
      }     
    this.courses = new ArrayList<>();
}

public static CourseList getInstance() {
    if(instance == null) {
        instance = new CourseList();
    }
    return instance;
}

    // Method to add a course to the list
public void addCourse(Course course) {
        courses.add(course);   
}

    // Method to remove a course from the list
    public void removeCourse(UUID courseId) {
        courses.removeIf(course -> course.getId(). equals(courseId));
    }

    // Method to get all courses
    public List<Course> getAllCourses() {
        return courses; // Return a copy to prevent modification from outside
    }

    // Method to find a course by its ID
    public Course findCourseById(UUID courseId) {
        for (Course course : courses) {
            if (course.getId(). equals(courseId)) {
                return course;
            }
        }
        return null; // Return null if no course is found
    }

    // Method to get courses by a specific language
    public ArrayList<Course> getCoursesByLanguage(String language) {
        ArrayList<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getDescription().contains(language)) {
                result.add(course);
            }
        }
        return result;
    }
}
