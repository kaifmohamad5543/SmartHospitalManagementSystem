// ============================
// pattern/PatientObserver.java
// ============================

package pattern;

// Patient observer class
public class PatientObserver implements Observer {

    // Overriding update method
    @Override
    public void update(String message) {

        // Displaying patient notification
        System.out.println("Patient Notification: " + message);
    }
}
