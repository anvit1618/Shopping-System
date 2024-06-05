package payment;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PaymentServiceTest {

    @Test
    public void testProcessPayment() {
        PaymentService paymentService = new PaymentService(new MockPaymentGateway());
        boolean result = paymentService.processPayment(100.0);
        assertTrue(result);
    }
}
