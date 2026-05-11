package dashboard;

import javax.swing.*;
import java.awt.*;

// GUI dashboard for Smart Hospital Management System
public class HospitalDashboard extends JFrame {

    public HospitalDashboard() {

        setTitle("Smart Hospital Real-Time Dashboard");
        setSize(1200, 750);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(createHeader(), BorderLayout.NORTH);
        add(createLeftPanel(), BorderLayout.WEST);
        add(new GraphPanel(), BorderLayout.CENTER);
        add(createNotificationPanel(), BorderLayout.EAST);
        add(createAdminPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JLabel createHeader() {
        JLabel header = new JLabel("SMART HOSPITAL REAL-TIME DASHBOARD", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 22));
        header.setOpaque(true);
        header.setBackground(new Color(50, 90, 140));
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(1200, 45));
        return header;
    }

    private JPanel createLeftPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setPreferredSize(new Dimension(220, 600));
        panel.setBorder(BorderFactory.createTitledBorder("Hospital Control"));

        String[] buttons = {
                "Register Patient",
                "Book Appointment",
                "Check Doctor",
                "Emergency Case",
                "Generate Bill",
                "View Report"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            panel.add(button);
        }

        return panel;
    }

    private JScrollPane createNotificationPanel() {
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setText(
                "Notifications\n\n" +
                        "Patient registered successfully.\n" +
                        "Appointment booked successfully.\n" +
                        "Doctor notified by SMS.\n" +
                        "Patient notified by Email.\n" +
                        "Emergency case added.\n" +
                        "Billing strategy applied.\n" +
                        "JUnit tests passed.\n" +
                        "System running normally."
        );

        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setPreferredSize(new Dimension(280, 600));
        scrollPane.setBorder(BorderFactory.createTitledBorder("Notifications"));
        return scrollPane;
    }

    private JPanel createAdminPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 3, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Admin Panel"));

        panel.add(new JLabel("Select Billing Strategy:"));

        JComboBox<String> comboBox = new JComboBox<>(new String[]{
                "Standard Billing",
                "Insurance Billing",
                "Emergency Billing"
        });

        panel.add(comboBox);
        panel.add(new JButton("Apply Billing"));
        panel.add(new JLabel("Estimated Income: £5300"));
        panel.add(new JButton("Manage Users"));
        panel.add(new JButton("Run Tests"));

        return panel;
    }

    private static class GraphPanel extends JPanel {

        int[] values = {8, 5, 2, 3, 6};
        String[] labels = {
                "Patients",
                "Appointments",
                "Emergency",
                "Doctors",
                "Bills"
        };

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Hospital Analytics Graph", 300, 50);

            int x = 120;
            int baseY = 500;
            int barWidth = 70;

            for (int i = 0; i < values.length; i++) {
                int barHeight = values[i] * 40;

                g.setColor(Color.BLACK);
                g.fillRect(x, baseY - barHeight, barWidth, barHeight);

                g.setFont(new Font("Arial", Font.BOLD, 14));
                g.drawString(values[i] + "", x + 25, baseY - barHeight - 10);
                g.drawString(labels[i], x - 10, baseY + 25);

                x += 130;
            }

            g.drawString("Hospital Activity", 350, 560);
        }
    }
}