package payment;

/**
 * Mock implementation of a payment gateway.
 */
public class MockPaymentGateway implements PaymentGateway {
    @Override
    public boolean process(double amount) {
        // Simulate payment processing
        return true;
    }
}
