package auth;

import dashboard.HospitalDashboard;

import javax.swing.*;
import java.awt.*;

// Login Page
public class LoginPage extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    // Constructor
    public LoginPage() {

        setTitle("Smart Hospital Login");

        setSize(450, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(null);

        JLabel title = new JLabel("SMART HOSPITAL LOGIN");

        title.setFont(new Font("Arial", Font.BOLD, 22));

        title.setBounds(90, 25, 300, 30);

        add(title);

        JLabel userLabel = new JLabel("Username:");

        userLabel.setBounds(70, 90, 100, 25);

        add(userLabel);

        usernameField = new JTextField();

        usernameField.setBounds(170, 90, 180, 25);

        add(usernameField);

        JLabel passLabel = new JLabel("Password:");

        passLabel.setBounds(70, 140, 100, 25);

        add(passLabel);

        passwordField = new JPasswordField();

        passwordField.setBounds(170, 140, 180, 25);

        add(passwordField);

        JButton loginButton = new JButton("Login");

        loginButton.setBounds(170, 200, 100, 30);

        add(loginButton);

        // Login action
        loginButton.addActionListener(e -> {

            String username = usernameField.getText();

            String password =
                    new String(passwordField.getPassword());

            if (username.equals("admin")
                    && password.equals("admin123")) {

                JOptionPane.showMessageDialog(
                        this,
                        "Login Successful"
                );

                dispose();

                new HospitalDashboard();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Username or Password"
                );
            }
        });

        setVisible(true);
    }
}