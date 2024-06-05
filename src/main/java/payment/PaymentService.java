package payment;

/**
 * Class representing a payment service.
 */
public class PaymentService {
    private final PaymentGateway gateway;

    public PaymentService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public boolean processPayment(double amount) {
        return gateway.process(amount);
    }
}
