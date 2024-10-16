package backEnd;
import java.util.UUID;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class CourseList {
    private ArrayList<Course> courses;
    private UUID id;

    public CourseList() {
        this.id = UUID.randomUUID();
        this.courses = new ArrayList<>();
        getCurrentCourse("path/to/courseList.json");
    }

    private void getCurrentCourse(String filePath) {
        try(FileReader reader = new FileReader(filePath)) {
            JSONParser parser = new JSONParser();
            JSONArray coursesArray = (JSONArray) parser.parse(reader);

            for(Object obj : coursesArray ) {
                JSONObject courseJson = (JSONObject) obj;
                UUID courseId = UUID.fromString((String) courseJson.get("id"));
                String title = (String) courseJson.get("title");
                String lesson = (String) courseJson.get("lesson");
                String description = (String) courseJson.get("description");
                Proficiency proficiency = (Proficiency) courseJson.get("proficiency");

                Course course = new Course(courseId, title, lesson, description, proficiency);
                courses.add(course);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
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

    public ArrayList<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }
}
