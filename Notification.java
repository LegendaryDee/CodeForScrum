import java.time.LocalDateTime;
import java.util.UUID;

public class Notification {
    private int id;
    private String message;
    private LocalDateTime timestamp;
    private NotificationStatus status;
    private UUID recipientID;
    private UUID senderID;
    private boolean isUrgent;

    public void sendNotifications() {
        // Logic to send notifications
    }

    public void markAsRead() {
        // Logic to mark notification as read
    }

    public String getNotificationDetails() {
        // Logic to get notification details
        return message;
    }

    public void deleteNotification() {
        // Logic to delete notification
    }

    public void filterNotifications() {
        // Logic to filter notifications
    }

    public int getUnreadCount() {
        // Logic to get unread notification count
        return 0;
    }
}

enum NotificationStatus {
    READ, UNREAD
}
