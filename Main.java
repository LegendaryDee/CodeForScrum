import java.util.ArrayList;
import java.util.UUID;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader();

        ArrayList<User> users = dataLoader.getUsers();

        System.out.println("Loaded Users:");
        for(User user : users) {
            System.out.println(user);
        }

        System.out.println("\nCreating notifications:");
        for(User user : users) {
            Notification notification = new Notification(
            user.getId(),
            "Hello " + user.getUserName() + ", welcome to the platform!",
            LocalDateTime.now(),
            NotificationStatus.UNREAD,
            user.getId(),
            UUID.randomUUID(),
            false
        );

        System.out.println(notification.getNotificationDetails());
        notification.sendNotifications();

        }
    }
}
