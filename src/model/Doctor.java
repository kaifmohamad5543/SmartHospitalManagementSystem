// ============================
// model/Doctor.java
// ============================

package model;

// Doctor class extending User class
public class Doctor extends User {

    // Doctor specialization
    private String specialization;

    // Constructor
    public Doctor(int id, String name, String email, String specialization) {

        // Calling superclass constructor
        super(id, name, email);

        // Initializing specialization
        this.specialization = specialization;
    }

    // Overridden polymorphic method
    @Override
    public void displayRole() {

        // Printing doctor information
        System.out.println(name + " is a Doctor specialised in " + specialization);
    }

    // Getter method
    public String getSpecialization() {
        return specialization;
    }
}