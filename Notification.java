import java.time.LocalDateTime;
import java.util.UUID;

public class Notification {
    public int id;
    private String message;
    public LocalDateTime timestamp;
    public NotificationStatus status;
    public UUID recipientID;
    public UUID senderID;
    public boolean isUrgent;

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
