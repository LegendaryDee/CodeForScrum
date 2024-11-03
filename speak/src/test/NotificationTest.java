package backend;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationTest {

    private Notification notification;
    private UUID recipientID;
    private UUID senderID;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Starting NotificationTest...");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Finished NotificationTest.");
    }

    @Before
    public void setUp() {
        recipientID = UUID.randomUUID();
        senderID = UUID.randomUUID();
        notification = new Notification(
            UUID.randomUUID(),
            "This is a test notification",
            LocalDateTime.now(),
            NotificationStatus.UNREAD,
            recipientID,
            senderID,
            true
        );
    }

    @After
    public void tearDown() {
        notification = null;
    }

    @Test
    public void testSendNotifications() {
        notification.sendNotifications();
        // Verify output manually or assume successful if no exceptions are thrown.
    }

    @Test
    public void testMarkAsRead() {
        notification.markAsRead();
        assertEquals(NotificationStatus.READ, notification.status);
    }

    @Test
    public void testGetNotificationDetails() {
        String details = notification.getNotificationDetails();
        assertTrue(details.contains("This is a test notification"));
        assertTrue(details.contains(recipientID.toString()));
        assertTrue(details.contains(senderID.toString()));
    }

    @Test
    public void testDeleteNotification() {
        notification.deleteNotification();
        // Verify output manually or assume successful if no exceptions are thrown.
    }

    @Test
    public void testFilterNotifications() {
        notification.filterNotifications();
        // Verify output manually or assume successful if no exceptions are thrown.
    }

    @Test
    public void testGetUnreadCount() {
        assertEquals(1, notification.getUnreadCount());
        notification.markAsRead();
        assertEquals(0, notification.getUnreadCount());
    }

    @Test
    public void testIsUrgent() {
        assertTrue(notification.isUrgent);
    }
}
