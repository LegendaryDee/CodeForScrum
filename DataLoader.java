import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataLoader {
    
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();

        users.add(new User(UUID.randomUUID(), "Alice", "password123", "alice@gmail.com", LanguagePreference.ENGLISH, new ProgressData(), 5));
        users.add(new User(UUID.randomUUID(), "Bob", "password456", "bob@yahoo.com", LanguagePreference.SPANISH, new ProgressData(), 3));
        users.add(new User(UUID.randomUUID(), "Charlie", "password789", "charlie@icloud.com", LanguagePreference.FRENCH, new ProgressData(), 7));

        return users;
    }

    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();

        Course course1 = new Course(null, null, null, null, null);
        course1.setTopicVocabulary(List.of("hello", "world"));
        course1.setTopicSentenceMaking(List.of("Hello, world!"));
        course1.setListeningSection(new ArrayList<>());
        courses.add(course1);

        Course course2 = new Course(null, null, null, null, null);
        course2.setTopicVocabulary(List.of("bienvenue", "monde"));
        course2.setTopicSentenceMaking(List.of("Bienvenue, monde!"));
        course2.setListeningSection(new ArrayList<>());
        courses.add(course2);

        return courses;
    }
}
