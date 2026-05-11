// ============================
// pattern/DoctorObserver.java
// ============================

package pattern;

// Doctor observer class
public class DoctorObserver implements Observer {

    // Overriding update method
    @Override
    public void update(String message) {

        // Displaying doctor notification
        System.out.println("Doctor Notification: " + message);
    }
}