package controller;

// Importing analytics package
import analytics.HospitalAnalytics;

// Importing model classes
import model.*;

import dashboard.HospitalDashboard;

// Importing notification classes
import notification.*;

// Importing design pattern classes
import pattern.*;

// Importing security class
import security.SecurityUtil;

// Importing testing class
import testing.HospitalTestRunner;

// Importing view class
import view.HospitalView;

// Controller class connects Model, View and system logic
public class HospitalController {

    // View object used to display output
    private final HospitalView view = new HospitalView();

    // Main method to run hospital system
    public void runSystem() {

        // Opening hospital GUI dashboard
        new HospitalDashboard();

        // Display startup message
        view.showMessage("Smart Hospital Management System Started");

        // Singleton Pattern: one central hospital system object
        HospitalManagementSystem system = HospitalManagementSystem.getInstance();

        // Observer Pattern: add notification observers
        system.addObserver(new PatientObserver());
        system.addObserver(new DoctorObserver());

        // Factory Pattern: create patient dynamically
        Patient patient = (Patient) UserFactory.createUser(
                "patient",
                1,
                "John Smith",
                "john@gmail.com"
        );

        // Factory Pattern: create doctor dynamically
        Doctor doctor = (Doctor) UserFactory.createUser(
                "doctor",
                2,
                "Dr Ali",
                "doctor@gmail.com"
        );

        // Polymorphism: display role based on object type
        patient.displayRole();
        doctor.displayRole();

        // Create appointment
        Appointment appointment = new Appointment(
                patient,
                doctor,
                "20 May 2026"
        );

        // Add appointment into hospital system
        system.addAppointment(appointment);

        // Confirm appointment
        appointment.confirmAppointment();

        // Email notification simulation
        NotificationService email = new EmailNotification();

        email.sendNotification(
                patient.getEmail(),
                "Dear " + patient.getName()
                        + ", your appointment with "
                        + doctor.getName()
                        + " has been confirmed for 20 May 2026."
        );

        // SMS notification simulation
        NotificationService sms = new SMSNotification();

        sms.sendNotification(
                doctor.getEmail(),
                "New appointment confirmed with patient "
                        + patient.getName()
                        + " on 20 May 2026."
        );

        // Create treatment
        Treatment treatment = new Treatment(
                "Heart Surgery",
                2000
        );

        // Strategy Pattern: standard billing
        BillingStrategy standard = new StandardBilling();

        // Strategy Pattern: insurance billing
        BillingStrategy insurance = new InsuranceBilling();

        // Strategy Pattern: emergency billing
        BillingStrategy emergency = new EmergencyBilling();

        // Calculate bills
        double standardBill = standard.calculateBill(treatment.getTreatmentCost());
        double insuranceBill = insurance.calculateBill(treatment.getTreatmentCost());
        double emergencyBill = emergency.calculateBill(treatment.getTreatmentCost());

        // Display bill results
        view.showMessage("Standard Bill: £" + standardBill);
        view.showMessage("Insurance Bill: £" + insuranceBill);
        view.showMessage("Emergency Bill: £" + emergencyBill);

        // Security: hash password
        String hashedPassword = SecurityUtil.hashPassword("Hospital123");

        // Display hashed password
        view.showMessage("Secure Password Hash: " + hashedPassword);

        // Analytics dashboard with graph
        HospitalAnalytics analytics = new HospitalAnalytics(
                8,
                5,
                2,
                standardBill + insuranceBill + emergencyBill
        );

        // Display text-based graph
        analytics.displayBarGraph();

        // Advanced testing
        HospitalTestRunner testRunner = new HospitalTestRunner();
        testRunner.runAllTests();
    }
}