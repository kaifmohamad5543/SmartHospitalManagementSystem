package test;

import org.junit.jupiter.api.Test;
import pattern.*;
import security.SecurityUtil;

import static org.junit.jupiter.api.Assertions.*;

// JUnit test class for Smart Hospital Management System
public class HospitalSystemTest {

    // Testing standard billing strategy
    @Test
    public void testStandardBilling() {

        BillingStrategy billing =
                new StandardBilling();

        double result =
                billing.calculateBill(2000);

        assertEquals(2000, result);
    }

    // Testing insurance billing strategy
    @Test
    public void testInsuranceBilling() {

        BillingStrategy billing =
                new InsuranceBilling();

        double result =
                billing.calculateBill(2000);

        assertEquals(1200, result);
    }

    // Testing emergency billing strategy
    @Test
    public void testEmergencyBilling() {

        BillingStrategy billing =
                new EmergencyBilling();

        double result =
                billing.calculateBill(2000);

        assertEquals(2100, result);
    }

    // Testing SHA-256 password hashing
    @Test
    public void testPasswordHashing() {

        String password = "Hospital123";

        String hashedPassword =
                SecurityUtil.hashPassword(password);

        assertNotNull(hashedPassword);

        assertNotEquals(
                password,
                hashedPassword
        );

        assertEquals(
                64,
                hashedPassword.length()
        );
    }

    // Testing singleton pattern
    @Test
    public void testSingletonPattern() {

        HospitalManagementSystem system1 =
                HospitalManagementSystem.getInstance();

        HospitalManagementSystem system2 =
                HospitalManagementSystem.getInstance();

        assertSame(system1, system2);
    }
}