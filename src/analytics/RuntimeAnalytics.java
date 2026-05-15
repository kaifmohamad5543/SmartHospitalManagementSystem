package analytics;

// Runtime analytics class for generating live system reports
public class RuntimeAnalytics {

    private int patients;
    private int appointments;
    private int emergencyCases;
    private int doctors;
    private int bills;
    private double income;

    public RuntimeAnalytics(int patients,
                            int appointments,
                            int emergencyCases,
                            int doctors,
                            int bills,
                            double income) {

        this.patients = patients;
        this.appointments = appointments;
        this.emergencyCases = emergencyCases;
        this.doctors = doctors;
        this.bills = bills;
        this.income = income;
    }

    public String generateSummary() {

        return "Runtime Analytics Report\n\n"
                + "Patients Registered: " + patients + "\n"
                + "Appointments Booked: " + appointments + "\n"
                + "Emergency Cases: " + emergencyCases + "\n"
                + "Doctors Managed: " + doctors + "\n"
                + "Bills Graph Value: " + bills + "\n"
                + "Estimated Income: £"
                + String.format("%.2f", income);
    }
}