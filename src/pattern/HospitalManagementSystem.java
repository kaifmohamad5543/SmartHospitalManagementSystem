// ============================
// pattern/HospitalManagementSystem.java
// ============================

package pattern;

// Importing required libraries
import java.util.ArrayList;
import java.util.List;

// Importing appointment model
import model.Appointment;

// Singleton class
public class HospitalManagementSystem {

    // Static Singleton instance
    private static HospitalManagementSystem instance;




    // Private constructor
    private HospitalManagementSystem() {
    }

    // Singleton getter method
    public static HospitalManagementSystem getInstance() {

        // Creating object only once
        if (instance == null) {
            instance = new HospitalManagementSystem();
        }

        return instance;
    }

    // Adding observer
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    // Appointment list
    private List<Appointment> appointments = new ArrayList<>();
    // Adding appointment
    public void addAppointment(Appointment appointment) {

        appointments.add(appointment);

        // Notify all observers
        notifyObservers("New appointment scheduled.");
    }
    // Observer list
    private List<Observer> observers = new ArrayList<>();
    // Notification method
    public void notifyObservers(String message) {

        // Looping through all observers
        for (Observer observer : observers) {

            // Sending notification
            observer.update(message);
        }
    }
}