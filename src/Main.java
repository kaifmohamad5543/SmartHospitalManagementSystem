// Importing controller class
import controller.HospitalController;

// Importing testing class
import testing.HospitalTestRunner;

// Main class of the Smart Hospital Management System
public class Main {

    // Main method where program execution starts
    public static void main(String[] args) {

        // Creating controller object
        HospitalController controller =
                new HospitalController();

        // Running the main hospital management system
        controller.runSystem();

        // Creating test runner object
        HospitalTestRunner testRunner =
                new HospitalTestRunner();

        // Running advanced testing
        testRunner.runAllTests();
    }
}