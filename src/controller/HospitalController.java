package controller;

import model.*;
import notification.*;
import pattern.*;
import security.SecurityUtil;
import testing.HospitalTestRunner;
import view.HospitalView;

// Controller class connects Model, View and system logic
public class HospitalController {

    private final HospitalView view = new HospitalView();

    public void runSystem() {

        view.showMessage("Smart Hospital Management System Started");

        HospitalManagementSystem system =
                HospitalManagementSystem.getInstance();

        system.addObserver(new PatientObserver());
        system.addObserver(new DoctorObserver());

        Patient patient =
                (Patient) UserFactory.createUser(
                        "patient",
                        1,
                        "John Smith",
                        "john@gmail.com"
                );

        Doctor doctor =
                (Doctor) UserFactory.createUser(
                        "doctor",
                        2,
                        "Dr Ali",
                        "doctor@gmail.com"
                );

        patient.displayRole();
        doctor.displayRole();

        Appointment appointment =
                new Appointment(
                        patient,
                        doctor,
                        "20 May 2026"
                );

        system.addAppointment(appointment);
        appointment.confirmAppointment();

        NotificationService email =
                new EmailNotification();

        email.sendNotification(
                patient.getEmail(),
                "Dear " + patient.getName()
                        + ", your appointment with "
                        + doctor.getName()
                        + " has been confirmed."
        );

        NotificationService sms =
                new SMSNotification();

        sms.sendNotification(
                doctor.getEmail(),
                "New appointment confirmed with patient "
                        + patient.getName()
        );

        Treatment treatment =
                new Treatment(
                        "Heart Surgery",
                        2000
                );

        BillingStrategy standard =
                new StandardBilling();

        BillingStrategy insurance =
                new InsuranceBilling();

        BillingStrategy emergency =
                new EmergencyBilling();

        double standardBill =
                standard.calculateBill(
                        treatment.getTreatmentCost());

        double insuranceBill =
                insurance.calculateBill(
                        treatment.getTreatmentCost());

        double emergencyBill =
                emergency.calculateBill(
                        treatment.getTreatmentCost());

        view.showMessage("Standard Bill: £" + standardBill);
        view.showMessage("Insurance Bill: £" + insuranceBill);
        view.showMessage("Emergency Bill: £" + emergencyBill);

        String hashedPassword =
                SecurityUtil.hashPassword("Hospital123");

        view.showMessage(
                "Secure Password Hash: "
                        + hashedPassword
        );

        HospitalTestRunner testRunner =
                new HospitalTestRunner();

        testRunner.runAllTests();
    }
}