package dashboard;

import analytics.RuntimeAnalytics;
import auth.LoginPage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HospitalDashboard extends JFrame {

    private JTextArea notificationArea;
    private JLabel incomeLabel;
    private JLabel runtimeAnalyticsLabel;

    private int patients = 0;
    private int appointments = 0;
    private int emergencyCases = 0;
    private int doctors = 0;
    private int bills = 0;

    private double estimatedIncome = 5300;

    private final Color BACKGROUND = new Color(245, 247, 250);
    private final Color HEADER_BLUE = new Color(21, 101, 192);
    private final Color SIDEBAR_NAVY = new Color(30, 41, 59);
    private final Color BUTTON_BLUE = new Color(25, 118, 210);
    private final Color CARD_WHITE = Color.WHITE;
    private final Color TEXT_DARK = new Color(38, 50, 56);
    private final Color LIGHT_BLUE = new Color(227, 242, 253);

    public HospitalDashboard() {

        setTitle("Smart Hospital Real-Time Dashboard");
        setSize(1250, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        getContentPane().setBackground(BACKGROUND);

        add(createHeader(), BorderLayout.NORTH);
        add(createLeftPanel(), BorderLayout.WEST);
        add(new GraphPanel(), BorderLayout.CENTER);
        add(createNotificationPanel(), BorderLayout.EAST);
        add(createAdminPanel(), BorderLayout.SOUTH);

        setVisible(true);
        updateRuntimeAnalytics();
    }

    private JLabel createHeader() {

        JLabel header = new JLabel("SMART HOSPITAL REAL-TIME DASHBOARD", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 27));
        header.setOpaque(true);
        header.setBackground(HEADER_BLUE);
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(1250, 70));

        return header;
    }

    private JPanel createLeftPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 12, 12));
        panel.setPreferredSize(new Dimension(230, 520));
        panel.setBackground(SIDEBAR_NAVY);
        panel.setBorder(new EmptyBorder(25, 15, 25, 15));

        JButton registerButton = createStyledButton("Register Patient");
        JButton appointmentButton = createStyledButton("Book Appointment");
        JButton doctorButton = createStyledButton("Doctor Management");
        JButton emergencyButton = createStyledButton("Emergency Cases");
        JButton billButton = createStyledButton("Generate Bills");
        JButton reportButton = createStyledButton("View Reports");

        registerButton.addActionListener(e -> registerPatient());
        appointmentButton.addActionListener(e -> bookAppointment());
        doctorButton.addActionListener(e -> manageDoctor());
        emergencyButton.addActionListener(e -> recordEmergency());
        billButton.addActionListener(e -> generateManualBill());
        reportButton.addActionListener(e -> viewReport());

        panel.add(registerButton);
        panel.add(appointmentButton);
        panel.add(doctorButton);
        panel.add(emergencyButton);
        panel.add(billButton);
        panel.add(reportButton);

        return panel;
    }

    private JButton createStyledButton(String text) {

        JButton button = new JButton(text);
        button.setBackground(BUTTON_BLUE);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(12, 10, 12, 10));

        return button;
    }

    private JScrollPane createNotificationPanel() {

        notificationArea = new JTextArea();
        notificationArea.setEditable(false);
        notificationArea.setFont(new Font("Arial", Font.PLAIN, 13));
        notificationArea.setBackground(LIGHT_BLUE);
        notificationArea.setForeground(TEXT_DARK);
        notificationArea.setBorder(new EmptyBorder(12, 12, 12, 12));

        notificationArea.setText(
                "Notifications\n\n"
                        + "System started successfully.\n"
                        + "Dashboard loaded.\n"
                        + "Runtime analytics active.\n"
                        + "Waiting for admin actions.\n"
        );

        JScrollPane scrollPane = new JScrollPane(notificationArea);
        scrollPane.setPreferredSize(new Dimension(300, 520));
        scrollPane.setBorder(BorderFactory.createTitledBorder("Notifications"));

        return scrollPane;
    }

    private JPanel createAdminPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 4, 12, 12));
        panel.setBackground(CARD_WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Admin Panel / Billing Strategy"),
                new EmptyBorder(15, 15, 15, 15)
        ));

        JLabel strategyLabel = new JLabel("Billing Strategy:");
        strategyLabel.setFont(new Font("Arial", Font.BOLD, 13));

        JComboBox<String> comboBox = new JComboBox<>(
                new String[]{
                        "Standard Billing",
                        "Insurance Billing",
                        "Emergency Billing"
                }
        );

        JButton applyButton = createStyledButton("Apply Billing");
        incomeLabel = new JLabel("Income: £" + String.format("%.2f", estimatedIncome));
        incomeLabel.setFont(new Font("Arial", Font.BOLD, 15));
        incomeLabel.setForeground(HEADER_BLUE);

        JButton manageButton = createStyledButton("Manage Users");
        JButton logoutButton = createStyledButton("Logout");

        runtimeAnalyticsLabel = new JLabel("Runtime Analytics: Loading...");
        runtimeAnalyticsLabel.setFont(new Font("Arial", Font.BOLD, 13));
        runtimeAnalyticsLabel.setForeground(TEXT_DARK);

        applyButton.addActionListener(e -> applyBillingStrategy(comboBox));
        manageButton.addActionListener(e -> manageUsers());
        logoutButton.addActionListener(e -> logout());

        panel.add(strategyLabel);
        panel.add(comboBox);
        panel.add(applyButton);
        panel.add(incomeLabel);
        panel.add(manageButton);
        panel.add(logoutButton);
        panel.add(runtimeAnalyticsLabel);

        return panel;
    }

    private void registerPatient() {

        String patientName = JOptionPane.showInputDialog(this, "Enter Patient Name:");
        String patientAge = JOptionPane.showInputDialog(this, "Enter Patient Age:");

        if (patientName != null && patientAge != null
                && !patientName.trim().isEmpty()
                && !patientAge.trim().isEmpty()) {

            patients++;

            addNotification("Patient registered successfully.");
            addNotification("Patient Name: " + patientName);
            addNotification("Patient Age: " + patientAge);

            JOptionPane.showMessageDialog(
                    this,
                    "Patient Registered Successfully\nName: " + patientName + "\nAge: " + patientAge
            );

            updateRuntimeAnalytics();
            repaint();

        } else {
            addNotification("Patient registration cancelled or incomplete.");
        }
    }

    private void bookAppointment() {

        String patientName = JOptionPane.showInputDialog(this, "Enter Patient Name:");
        String appointmentDate = JOptionPane.showInputDialog(this, "Enter Appointment Date:");

        if (patientName != null && appointmentDate != null
                && !patientName.trim().isEmpty()
                && !appointmentDate.trim().isEmpty()) {

            appointments++;

            addNotification("Appointment booked successfully.");
            addNotification("Appointment Patient: " + patientName);
            addNotification("Appointment Date: " + appointmentDate);

            JOptionPane.showMessageDialog(
                    this,
                    "Appointment Booked Successfully\nPatient: " + patientName + "\nDate: " + appointmentDate
            );

            updateRuntimeAnalytics();
            repaint();

        } else {
            addNotification("Appointment booking cancelled or incomplete.");
        }
    }

    private void manageDoctor() {

        String doctorName = JOptionPane.showInputDialog(this, "Enter Doctor Name:");
        String department = JOptionPane.showInputDialog(this, "Enter Department:");

        if (doctorName != null && department != null
                && !doctorName.trim().isEmpty()
                && !department.trim().isEmpty()) {

            doctors++;

            addNotification("Doctor record updated successfully.");
            addNotification("Doctor Name: " + doctorName);
            addNotification("Department: " + department);

            JOptionPane.showMessageDialog(
                    this,
                    "Doctor Added Successfully\nName: " + doctorName + "\nDepartment: " + department
            );

            updateRuntimeAnalytics();
            repaint();

        } else {
            addNotification("Doctor update cancelled or incomplete.");
        }
    }

    private void recordEmergency() {

        String patientName = JOptionPane.showInputDialog(this, "Enter Emergency Patient Name:");

        if (patientName != null && !patientName.trim().isEmpty()) {

            emergencyCases++;

            addNotification("Emergency case recorded.");
            addNotification("Emergency Patient: " + patientName);
            addNotification("Doctor notified by SMS simulation.");

            JOptionPane.showMessageDialog(
                    this,
                    "Emergency Case Recorded\nPatient: " + patientName
            );

            updateRuntimeAnalytics();
            repaint();

        } else {
            addNotification("Emergency case cancelled or incomplete.");
        }
    }

    private void generateManualBill() {

        String billAmountText = JOptionPane.showInputDialog(this, "Enter Bill Amount:");

        if (billAmountText != null && !billAmountText.trim().isEmpty()) {

            try {

                double billAmount = Double.parseDouble(billAmountText);

                if (billAmount <= 0) {
                    addNotification("Invalid bill amount entered.");
                    JOptionPane.showMessageDialog(this, "Bill amount must be greater than 0.");
                    return;
                }

                estimatedIncome += billAmount;
                bills = Math.min(15, (int) Math.round(estimatedIncome / 1000));

                incomeLabel.setText("Income: £" + String.format("%.2f", estimatedIncome));

                addNotification("Manual bill generated successfully.");
                addNotification("Bill Amount: £" + String.format("%.2f", billAmount));
                addNotification("Updated Income: £" + String.format("%.2f", estimatedIncome));

                JOptionPane.showMessageDialog(
                        this,
                        "Bill Generated Successfully\nBill Amount: £"
                                + String.format("%.2f", billAmount)
                                + "\nUpdated Income: £"
                                + String.format("%.2f", estimatedIncome)
                );

                updateRuntimeAnalytics();
                repaint();

            } catch (NumberFormatException ex) {
                addNotification("Invalid bill amount. Numbers only.");
                JOptionPane.showMessageDialog(this, "Invalid amount. Please enter numbers only.");
            }

        } else {
            addNotification("Bill generation cancelled or incomplete.");
        }
    }

    private void viewReport() {

        RuntimeAnalytics analytics = new RuntimeAnalytics(
                patients,
                appointments,
                emergencyCases,
                doctors,
                bills,
                estimatedIncome
        );

        addNotification("Runtime analytics report generated.");
        updateRuntimeAnalytics();

        JOptionPane.showMessageDialog(this, analytics.generateSummary());
    }

    private void applyBillingStrategy(JComboBox<String> comboBox) {

        String selectedStrategy = (String) comboBox.getSelectedItem();
        double billAmount = 0;

        if ("Standard Billing".equals(selectedStrategy)) {
            billAmount = 1000;
        } else if ("Insurance Billing".equals(selectedStrategy)) {
            billAmount = 600;
        } else if ("Emergency Billing".equals(selectedStrategy)) {
            billAmount = 1100;
        }

        estimatedIncome += billAmount;
        bills = Math.min(15, (int) Math.round(estimatedIncome / 1000));

        incomeLabel.setText("Income: £" + String.format("%.2f", estimatedIncome));

        addNotification("Billing strategy applied successfully.");
        addNotification("Selected Strategy: " + selectedStrategy);
        addNotification("Bill Added: £" + String.format("%.2f", billAmount));
        addNotification("Updated Income: £" + String.format("%.2f", estimatedIncome));

        JOptionPane.showMessageDialog(
                this,
                selectedStrategy
                        + " applied successfully.\n\nBill Added: £"
                        + String.format("%.2f", billAmount)
                        + "\nUpdated Income: £"
                        + String.format("%.2f", estimatedIncome)
        );

        updateRuntimeAnalytics();
        repaint();
    }

    private void manageUsers() {

        addNotification("Admin opened user management section.");

        JOptionPane.showMessageDialog(
                this,
                "User Management:\nAdmin can manage patients, doctors and staff."
        );
    }

    private void logout() {

        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to logout?",
                "Logout Confirmation",
                JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {
            addNotification("Admin logged out successfully.");
            dispose();
            new LoginPage();
        }
    }

    private void updateRuntimeAnalytics() {

        if (runtimeAnalyticsLabel != null) {

            runtimeAnalyticsLabel.setText(
                    "Patients: " + patients
                            + " | Appointments: " + appointments
                            + " | Emergency: " + emergencyCases
                            + " | Doctors: " + doctors
                            + " | Income: £"
                            + String.format("%.2f", estimatedIncome)
            );
        }
    }

    private void addNotification(String message) {

        if (notificationArea != null) {
            notificationArea.append(message + "\n");
            notificationArea.setCaretPosition(notificationArea.getDocument().getLength());
        }
    }

    private class GraphPanel extends JPanel {

        public GraphPanel() {
            setBackground(BACKGROUND);
            setBorder(new EmptyBorder(30, 30, 30, 30));
        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            int[] values = {
                    patients,
                    appointments,
                    emergencyCases,
                    doctors,
                    bills
            };

            String[] labels = {
                    "Patients",
                    "Appointments",
                    "Emergency",
                    "Doctors",
                    "Bills"
            };

            Color[] barColors = {
                    new Color(25, 118, 210),
                    new Color(76, 175, 80),
                    new Color(244, 67, 54),
                    new Color(255, 152, 0),
                    new Color(103, 58, 183)
            };

            // White card background for chart
            g2.setColor(CARD_WHITE);
            g2.fillRoundRect(30, 30, 650, 430, 25, 25);

            // Chart title
            g2.setColor(TEXT_DARK);
            g2.setFont(new Font("Arial", Font.BOLD, 24));
            g2.drawString("Hospital Activity Analytics", 180, 75);

            int x = 85;
            int baseY = 360;
            int barWidth = 60;
            int spacing = 115;

            for (int i = 0; i < values.length; i++) {

                int barHeight = Math.min(values[i] * 25, 250);

                // Draw bar
                g2.setColor(barColors[i]);

                g2.fillRoundRect(
                        x,
                        baseY - barHeight,
                        barWidth,
                        barHeight,
                        15,
                        15
                );

                // Draw value above bar
                g2.setColor(TEXT_DARK);
                g2.setFont(new Font("Arial", Font.BOLD, 16));

                g2.drawString(
                        String.valueOf(values[i]),
                        x + 22,
                        baseY - barHeight - 12
                );

                // Draw label below bar with proper centre alignment
                g2.setFont(new Font("Arial", Font.BOLD, 14));

                FontMetrics fm = g2.getFontMetrics();
                int labelWidth = fm.stringWidth(labels[i]);

                g2.drawString(
                        labels[i],
                        x + (barWidth - labelWidth) / 2,
                        baseY + 30
                );

                x += spacing;
            }

            // Footer explanation
            g2.setColor(new Color(120, 144, 156));
            g2.setFont(new Font("Arial", Font.PLAIN, 14));

            g2.drawString(
                    "Real-time dashboard data updates after each hospital operation.",
                    145,
                    425
            );
        }
    }
}