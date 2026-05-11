package testing;

import pattern.*;
import security.SecurityUtil;

// Simple manual test runner without JUnit
public class HospitalTestRunner {

    // Run all manual tests
    public void runAllTests() {

        System.out.println("\n===== HOSPITAL SYSTEM TESTING STARTED =====");

        testPasswordHashing();
        testStandardBilling();
        testInsuranceBilling();
        testEmergencyBilling();

        System.out.println("===== HOSPITAL SYSTEM TESTING COMPLETED =====\n");
    }

    // Test SHA-256 password hashing
    private void testPasswordHashing() {

        String password = "Hospital123";
        String hashedPassword = SecurityUtil.hashPassword(password);

        boolean passed = hashedPassword != null
                && !hashedPassword.equals(password)
                && hashedPassword.length() == 64;

        printResult(
                "Password Hashing Test",
                "Password should be converted into 64-character SHA-256 hash",
                passed
        );
    }

    // Test standard billing
    private void testStandardBilling() {

        BillingStrategy billing = new StandardBilling();
        double result = billing.calculateBill(2000);

        printResult(
                "Standard Billing Test",
                "Expected £2000.0",
                result == 2000
        );
    }

    // Test insurance billing
    private void testInsuranceBilling() {

        BillingStrategy billing = new InsuranceBilling();
        double result = billing.calculateBill(2000);

        printResult(
                "Insurance Billing Test",
                "Expected £1200.0",
                result == 1200
        );
    }

    // Test emergency billing
    private void testEmergencyBilling() {

        BillingStrategy billing = new EmergencyBilling();
        double result = billing.calculateBill(2000);

        printResult(
                "Emergency Billing Test",
                "Expected £2100.0",
                result == 2100
        );
    }

    // Reusable method to print test result
    private void printResult(String testName, String expectedResult, boolean passed) {

        System.out.println("-----------------------------------");
        System.out.println("Test Name: " + testName);
        System.out.println("Expected: " + expectedResult);
        System.out.println("Result: " + (passed ? "PASSED" : "FAILED"));
    }
}