package backEnd;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class CourseList {
    private List<Course> courses;
    private UUID id;

    public CourseList() {
        this.id = UUID.randomUUID();
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public Course getCoruseByUUID(UUID id) {
        for(Course course : courses) {
            if(course.getId().equals(id)) {
                return course;
            }
        }
        return null; // Return null if not found
    }

    public Course findCourse(String courseID) {
        return courses.stream().filter(course -> courseID.equals(course.getCourseID())).findFirst().orElse(null);
    }

    public Course getCourseByTitle(String title) {
        for(Course course : courses) {
            if(course.getTitle().equalsIgnoreCase(title)) {
                return course;
            }
        }
        return null;
    }

    public UUID getId() {
        return id;
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }
}
