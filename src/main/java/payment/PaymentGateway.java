package payment;

/**
 * Interface representing a payment gateway.
 */
public interface PaymentGateway {
    boolean process(double amount);
}
