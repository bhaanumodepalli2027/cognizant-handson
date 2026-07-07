package src;

/**
 * Test class demonstrating different payment gateways via the Adapter Pattern.
 */
public class AdapterTest {

    public static void main(String[] args) {
        double amount = 150.75;

        // Each gateway is accessed through the unified PaymentProcessor interface
        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        PaymentProcessor square = new SquareAdapter(new SquareGateway());

        System.out.println("Processing $" + amount + " via three different gateways:\n");

        paypal.processPayment(amount);
        stripe.processPayment(amount);
        square.processPayment(amount);
    }
}
