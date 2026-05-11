package pattern;

// Emergency billing strategy class
public class EmergencyBilling implements BillingStrategy {

    // Calculates bill with emergency service charge
    @Override
    public double calculateBill(double treatmentCost) {

        // Add fixed emergency charge
        return treatmentCost + 100;
    }
}