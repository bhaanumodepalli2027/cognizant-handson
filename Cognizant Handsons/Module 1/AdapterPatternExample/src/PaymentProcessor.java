package src;

/**
 * PaymentProcessor - target interface expected by the client.
 */
public interface PaymentProcessor {
    void processPayment(double amount);
}
