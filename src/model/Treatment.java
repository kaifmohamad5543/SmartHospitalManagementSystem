// ============================
// model/Treatment.java
// ============================

package model;

// Treatment class
public class Treatment {

    // Treatment name
    private String treatmentName;

    // Treatment cost
    private double treatmentCost;

    // Constructor
    public Treatment(String treatmentName, double treatmentCost) {

        // Initializing values
        this.treatmentName = treatmentName;
        this.treatmentCost = treatmentCost;
    }

    // Getter for treatment name
    public String getTreatmentName() {
        return treatmentName;
    }

    // Getter for treatment cost
    public double getTreatmentCost() {
        return treatmentCost;
    }
}