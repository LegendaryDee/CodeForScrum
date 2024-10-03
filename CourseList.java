import java.util.ArrayList;
import java.util.List;

public class CourseList {
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public Course findCourse(String courseID) {
        // Logic to find a course by ID
        return courses.stream().filter(course -> courseID.equals(course.getCourseID())).findFirst().orElse(null);
    }

    public List<Course> getAllCourses() {
        return courses;
    }
}
