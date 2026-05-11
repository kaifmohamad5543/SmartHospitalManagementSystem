// ============================
// security/SecurityUtil.java
// ============================

package security;

// Importing MessageDigest
import java.security.MessageDigest;

// Security utility class
public class SecurityUtil {

    // Method for hashing password
    public static String hashPassword(String password) {

        try {

            // Using SHA-256 algorithm
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Converting password into hash bytes
            byte[] hashBytes = md.digest(password.getBytes());

            // StringBuilder for hexadecimal conversion
            StringBuilder builder = new StringBuilder();

            // Looping through bytes
            for (byte b : hashBytes) {

                // Converting bytes into hexadecimal
                builder.append(String.format("%02x", b));
            }

            // Returning hashed password
            return builder.toString();

        } catch (Exception e) {

            // Throwing runtime exception
            throw new RuntimeException("Hashing failed");
        }
    }
}