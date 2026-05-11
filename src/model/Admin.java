// ============================
// model/Admin.java
// ============================

package model;

// Admin class inheriting User
public class Admin extends User {

    // Constructor
    public Admin(int id, String name, String email) {

        // Calling parent constructor
        super(id, name, email);
    }

    // Overriding abstract method
    @Override
    public void displayRole() {

        // Displaying admin role
        System.out.println(name + " is an Admin.");
    }
}