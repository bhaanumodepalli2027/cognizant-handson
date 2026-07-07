package src;

/**
 * Adaptee: PayPal's proprietary gateway interface.
 */
public class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("PayPal: Processing payment of $" + amount);
    }
}
