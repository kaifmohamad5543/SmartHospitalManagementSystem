package notification;

// Interface for different notification methods
public interface NotificationService {

    // Common method for sending notifications
    void sendNotification(String receiver, String message);
}