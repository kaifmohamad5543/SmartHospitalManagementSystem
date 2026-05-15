// Importing Login GUI page
import auth.LoginPage;

// Importing Email notification service
import notification.EmailNotification;

// Importing SMS notification service
import notification.SMSNotification;

// Importing salted SHA-256 password hashing utility
import security.PasswordHasher;

// Main class of Smart Hospital Management System
public class Main {

    // Main method where program execution starts
    public static void main(String[] args) {

        System.out.println("--- SMART HOSPITAL MANAGEMENT SYSTEM ---");

        System.out.println("\n--- Hospital Status ---");
        System.out.println("Patient registered successfully.");
        System.out.println("Doctor added successfully.");
        System.out.println("Appointment booked successfully.");
        System.out.println("Emergency case recorded successfully.");

        System.out.println("\n--- Billing Strategy Comparison ---");
        System.out.println("Standard Billing Cost: £1000.0");
        System.out.println("Insurance Billing Cost: £600.0");
        System.out.println("Emergency Billing Cost: £1100.0");
        System.out.println("Estimated Cost: £2700.0");

        System.out.println("\n--- Hospital Service Status ---");
        System.out.println("- Patient: John Smith | Age: 24 | Status: REGISTERED");
        System.out.println("- Doctor: Dr Ali | Specialisation: Cardiology | Status: AVAILABLE");
        System.out.println("- Appointment: John Smith with Dr Ali | Date: 23/01/2026 | Status: CONFIRMED");
        System.out.println("- Emergency Case: Minor Injury | Status: RECORDED");

        // Salted SHA-256 password hashing demonstration
        System.out.println("\n--- Salted Password Hashing Example ---");

        String password = "admin123";

        String storedHash = PasswordHasher.hashPassword(password);

        System.out.println("Original Password: " + password);
        System.out.println("Stored Salted Hash: " + storedHash);

        boolean validLogin = PasswordHasher.verifyPassword("admin123", storedHash);
        System.out.println("Correct Password Login Valid: " + validLogin);

        boolean invalidLogin = PasswordHasher.verifyPassword("wrongpass", storedHash);
        System.out.println("Wrong Password Login Valid: " + invalidLogin);

        System.out.println("\n--- Email/SMS Notification Example ---");

        EmailNotification email = new EmailNotification();

        email.sendNotification(
                "patient@example.com",
                "Your hospital appointment has been confirmed."
        );

        SMSNotification sms = new SMSNotification();

        sms.sendNotification(
                "+447000000000",
                "Hospital appointment reminder: Your appointment is confirmed."
        );

        System.out.println("\n--- Opening Login Page ---");

        new LoginPage();
    }
}