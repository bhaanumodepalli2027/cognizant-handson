package src;

/**
 * Adapter: Wraps PayPalGateway and exposes the PaymentProcessor interface.
 */
public class PayPalAdapter implements PaymentProcessor {

    private final PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Translate the generic call into PayPal-specific method
        payPalGateway.makePayment(amount);
    }
}
