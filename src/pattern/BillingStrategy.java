package pattern;

// Strategy interface for different hospital billing methods
public interface BillingStrategy {

    // Abstract method implemented by different billing strategies
    double calculateBill(double treatmentCost);
}