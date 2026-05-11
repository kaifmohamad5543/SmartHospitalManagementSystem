package analytics;

// HospitalAnalytics class is used to calculate hospital statistics
public class HospitalAnalytics {

    // Total number of patients
    private int totalPatients;

    // Total number of appointments
    private int totalAppointments;

    // Total number of emergencyCases
    private int emergencyCases;

    // Total hospital income
    private double totalIncome;

    // Constructor
    public HospitalAnalytics(int totalPatients,
                             int totalAppointments,
                             int emergencyCases,
                             double totalIncome) {

        this.totalPatients = totalPatients;
        this.totalAppointments = totalAppointments;
        this.emergencyCases = emergencyCases;
        this.totalIncome = totalIncome;
    }

    // Method to display text-based graph
    public void displayBarGraph() {

        System.out.println("\n--- Hospital Analytics Dashboard ---");

        printBar("Patients", totalPatients);
        printBar("Appointments", totalAppointments);
        printBar("Emergency Cases", emergencyCases);

        System.out.println("Total Income: £" + totalIncome);
    }

    // Helper method to print simple graph bars
    private void printBar(String label, int value) {

        System.out.print(label + ": ");

        for (int i = 0; i < value; i++) {
            System.out.print("█");
        }

        System.out.println(" (" + value + ")");
    }
}