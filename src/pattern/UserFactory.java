// ============================
// pattern/UserFactory.java
// ============================

package pattern;

// Importing model classes
import model.*;

// Factory class for creating users
public class UserFactory {

    // Static factory method
    public static User createUser(String type,
                                  int id,
                                  String name,
                                  String email) {

        // Creating objects dynamically
        switch (type.toLowerCase()) {

            case "patient":
                return new Patient(id,
                        name,
                        email,
                        "General Medical History");

            case "doctor":
                return new Doctor(id,
                        name,
                        email,
                        "Cardiology");

            case "admin":
                return new Admin(id,
                        name,
                        email);

            default:
                throw new IllegalArgumentException("Invalid user type");
        }
    }
}