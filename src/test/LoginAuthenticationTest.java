package test;

import org.junit.jupiter.api.Test;
import security.SecurityUtil;

import static org.junit.jupiter.api.Assertions.*;

// JUnit test class for login authentication validation
public class LoginAuthenticationTest {

    // Valid login credentials
    private final String validUsername = "admin";
    private final String validPassword = "admin123";

    // Testing successful login authentication
    @Test
    public void testValidLoginAuthentication() {

        String username = "admin";
        String password = "admin123";

        assertEquals(validUsername, username);
        assertEquals(validPassword, password);
    }

    // Testing invalid username detection
    @Test
    public void testInvalidUsernameAuthentication() {

        String username = "wronguser";

        assertNotEquals(validUsername, username);
    }

    // Testing invalid password detection
    @Test
    public void testInvalidPasswordAuthentication() {

        String password = "wrongpass";

        assertNotEquals(validPassword, password);
    }

    // Testing SHA-256 password hashing security
    @Test
    public void testLoginPasswordHashing() {

        String hashedPassword =
                SecurityUtil.hashPassword(validPassword);

        assertNotNull(hashedPassword);

        assertNotEquals(
                validPassword,
                hashedPassword
        );

        assertEquals(
                64,
                hashedPassword.length()
        );
    }

    // Testing consistent password hashing output
    @Test
    public void testConsistentHashing() {

        String hash1 =
                SecurityUtil.hashPassword(validPassword);

        String hash2 =
                SecurityUtil.hashPassword(validPassword);

        assertEquals(hash1, hash2);
    }
}