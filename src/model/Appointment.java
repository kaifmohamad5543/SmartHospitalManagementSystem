// ============================
// model/Appointment.java
// ============================

package model;

// Appointment class
public class Appointment {

    // Appointment attributes
    private Patient patient;
    private Doctor doctor;
    private String appointmentDate;
    private String status;

    // Constructor
    public Appointment(Patient patient, Doctor doctor, String appointmentDate) {

        // Initializing appointment details
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;

        // Default status
        this.status = "Scheduled";
    }

    // Method to confirm appointment
    public void confirmAppointment() {

        // Updating status
        status = "Confirmed";

        // Display confirmation
        System.out.println("Appointment confirmed for "
                + patient.getName()
                + " with Dr "
                + doctor.getName()
                + " on "
                + appointmentDate);
    }
}