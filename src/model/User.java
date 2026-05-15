// ============================
// model/User.java
// ============================
package model;

// Abstract parent class representing all users
public abstract class User {

    // Common attributes shared by all users
    protected int id;
    protected String name;
    protected String email;

    // Constructor to initialize common user details
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


    // Abstract method for polymorphism
    // Each subclass will implement its own role display
    public abstract void displayRole();

    // Getter method to retrieve user name
    public String getName() {
        return name;
    }

    // Getter method for email
    public String getEmail() {
        return email;
    }
}