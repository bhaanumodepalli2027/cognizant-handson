package src;

/**
 * Adaptee: Stripe's proprietary gateway interface.
 */
public class StripeGateway {
    public void charge(double amount) {
        System.out.println("Stripe: Charging $" + amount + " to card.");
    }
}
