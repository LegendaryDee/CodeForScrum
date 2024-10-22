package com.backend;

import java.time.LocalDateTime;
import java.util.UUID;

public class Notification {
    public UUID id;
    private String message;
    public LocalDateTime timestamp;
    public NotificationStatus status;
    public UUID recipientID;
    public UUID senderID;
    public boolean isUrgent;

    public Notification(UUID uuid, String message, LocalDateTime timestamp, NotificationStatus status, UUID recipientID, UUID senderID, boolean isUrgent) {
        this.id = uuid;
        this.message = message;
        this.timestamp = timestamp;
        this.status = status;
        this.recipientID = recipientID;
        this.senderID = senderID;
        this.isUrgent = isUrgent;
    }

    public void sendNotifications() {
        System.out.println("Notification sent to " + recipientID + ": " + message);
    }

    public void markAsRead() {
        this.status = NotificationStatus.READ;
        System.out.println("Notification " + id + " marked as read.");
    }

    public String getNotificationDetails() {
        return String.format("ID: %s, Message: %s, Timestamp: %s, Status: %s, RecipientID: %s, SenderID: %s, Urgent: %b", id, message, timestamp, status, recipientID, senderID, isUrgent);
    }

    public void deleteNotification() {
        System.out.println("Notification " + id + " deleted.");
    }

    public void filterNotifications() {
        System.out.println("Filtering notifications...");
    }

    public int getUnreadCount() {
        return status == NotificationStatus.UNREAD ? 1 : 0;
    }
}

enum NotificationStatus {
    READ, UNREAD
}
