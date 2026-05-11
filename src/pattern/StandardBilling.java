package pattern;

// Standard billing strategy class
public class StandardBilling implements BillingStrategy {

    // Calculates normal bill without discount or extra charge
    @Override
    public double calculateBill(double treatmentCost) {

        // Return original treatment cost
        return treatmentCost;
    }
}