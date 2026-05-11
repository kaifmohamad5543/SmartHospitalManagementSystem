package pattern;

public class InsuranceBilling implements BillingStrategy {

    @Override
    public double calculateBill(double treatmentCost) {
        return treatmentCost * 0.60;
    }
}