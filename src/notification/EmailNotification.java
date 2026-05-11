package notification;

// Email notification simulation
public class EmailNotification implements NotificationService {

    @Override
    public void sendNotification(String receiver, String message) {

        System.out.println("Email sent to " + receiver);
        System.out.println("Email Message: " + message);
    }
}