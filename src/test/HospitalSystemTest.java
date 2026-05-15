package test;

import model.Appointment;
import org.junit.jupiter.api.Test;
import pattern.*;
import security.SecurityUtil;

import static org.junit.jupiter.api.Assertions.*;

public class HospitalSystemTest {

    @Test
    public void testStandardBilling() {
        BillingStrategy billing = new StandardBilling();
        assertEquals(2000, billing.calculateBill(2000));
    }

    @Test
    public void testInsuranceBilling() {
        BillingStrategy billing = new InsuranceBilling();
        assertEquals(1200, billing.calculateBill(2000));
    }

    @Test
    public void testEmergencyBilling() {
        BillingStrategy billing = new EmergencyBilling();
        assertEquals(2100, billing.calculateBill(2000));
    }

    @Test
    public void testZeroBillingAmount() {
        BillingStrategy billing = new StandardBilling();
        assertEquals(0, billing.calculateBill(0));
    }

    @Test
    public void testLargeBillingAmount() {
        BillingStrategy billing = new InsuranceBilling();
        assertEquals(6000, billing.calculateBill(10000));
    }

    @Test
    public void testPasswordHashingNotNull() {
        String hashedPassword = SecurityUtil.hashPassword("Hospital123");
        assertNotNull(hashedPassword);
    }

    @Test
    public void testPasswordHashingNotPlainText() {
        String password = "Hospital123";
        String hashedPassword = SecurityUtil.hashPassword(password);
        assertNotEquals(password, hashedPassword);
    }

    @Test
    public void testPasswordHashingLength() {
        String hashedPassword = SecurityUtil.hashPassword("Hospital123");
        assertEquals(64, hashedPassword.length());
    }

    @Test
    public void testPasswordHashingConsistency() {
        String hash1 = SecurityUtil.hashPassword("Hospital123");
        String hash2 = SecurityUtil.hashPassword("Hospital123");
        assertEquals(hash1, hash2);
    }

    @Test
    public void testDifferentPasswordsProduceDifferentHashes() {
        String hash1 = SecurityUtil.hashPassword("Hospital123");
        String hash2 = SecurityUtil.hashPassword("Admin123");
        assertNotEquals(hash1, hash2);
    }

    @Test
    public void testSingletonPattern() {
        HospitalManagementSystem system1 = HospitalManagementSystem.getInstance();
        HospitalManagementSystem system2 = HospitalManagementSystem.getInstance();
        assertSame(system1, system2);
    }

    @Test
    public void testFactoryCreatesPatient() {
        assertNotNull(
                UserFactory.createUser(
                        "patient",
                        1,
                        "John",
                        "john@example.com"
                )
        );
    }

    @Test
    public void testFactoryCreatesDoctor() {
        assertNotNull(
                UserFactory.createUser(
                        "doctor",
                        2,
                        "Dr Ali",
                        "doctor@example.com"
                )
        );
    }

    @Test
    public void testFactoryInvalidUserType() {
        assertThrows(
                IllegalArgumentException.class,
                () -> UserFactory.createUser(
                        "invalid",
                        3,
                        "Test",
                        "test@example.com"
                )
        );
    }
}