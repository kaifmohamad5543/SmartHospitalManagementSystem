package notification;

// SMS notification simulation
public class SMSNotification implements NotificationService {

    @Override
    public void sendNotification(String receiver, String message) {

        System.out.println("SMS sent to " + receiver);
        System.out.println("SMS Message: " + message);
    }
}