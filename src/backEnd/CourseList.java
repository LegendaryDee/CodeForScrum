package backEnd;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CourseList {
    private List<Course> courses;

// Constructor
public CourseList() {
    this.courses = new ArrayList<>();
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
        return new ArrayList<>(courses); // Return a copy to prevent modification from outside
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
    public List<Course> getCoursesByLanguage(String language) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getDescription().contains(language)) {
                result.add(course);
            }
        }
        return result;
    }
}
