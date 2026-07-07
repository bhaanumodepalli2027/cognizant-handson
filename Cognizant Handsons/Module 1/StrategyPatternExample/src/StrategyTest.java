package src;

/**
 * Test class demonstrating runtime strategy switching via the Strategy Pattern.
 */
public class StrategyTest {

    public static void main(String[] args) {
        double orderTotal = 299.99;

        // Start with Credit Card strategy
        PaymentContext context = new PaymentContext(
                new CreditCardPayment("1234567890123456", "Alice Johnson")
        );
        System.out.println("Order total: $" + orderTotal);
        context.executePayment(orderTotal);

        // Switch to PayPal at runtime
        System.out.println("\nCustomer switched payment method to PayPal.");
        context.setStrategy(new PayPalPayment("alice.johnson@email.com"));
        context.executePayment(orderTotal);
    }
}
