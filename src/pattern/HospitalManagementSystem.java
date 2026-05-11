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

    // Static instance
    private static HospitalManagementSystem instance;

    // Appointment list
    private List<Appointment> appointments = new ArrayList<>();

    // Observer list
    private List<Observer> observers = new ArrayList<>();

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

    // Adding appointment
    public void addAppointment(Appointment appointment) {

        appointments.add(appointment);

        // Notify all observers
        notifyObservers("New appointment scheduled.");
    }

    // Notification method
    public void notifyObservers(String message) {

        // Looping through all observers
        for (Observer observer : observers) {

            // Sending notification
            observer.update(message);
        }
    }
}