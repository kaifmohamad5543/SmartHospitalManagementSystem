// ============================
// model/Patient.java
// ============================

package model;

// Patient class inheriting from User class
public class Patient extends User {

    // Attribute specific to patient
    private String medicalHistory;

    // Constructor for patient
    public Patient(int id, String name, String email, String medicalHistory) {

        // Calling parent constructor
        super(id, name, email);

        // Initializing medical history
        this.medicalHistory = medicalHistory;
    }

    // Overriding abstract method from User class
    @Override
    public void displayRole() {

        // Displaying patient role
        System.out.println(name + " is a Patient.");
    }

    // Getter for medical history
    public String getMedicalHistory() {
        return medicalHistory;
    }
}