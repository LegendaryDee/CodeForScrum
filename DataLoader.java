import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataLoader {
    
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User(UUID.randomUUID(), "Alice", "password123", "alice@gmail.com", LanguagePreference.ENGLISH, new ProgressData(), 5));
        users.add(new User(UUID.randomUUID(), "Bob", "password456", "bob@yahoo.com", LanguagePreference.SPANISH, new ProgressData(), 3));
        users.add(new User(UUID.randomUUID(), "Charlie", "password789", "charlie@icloud.com", LanguagePreference.FRENCH, new ProgressData(), 7));

        return users;
    }
}
