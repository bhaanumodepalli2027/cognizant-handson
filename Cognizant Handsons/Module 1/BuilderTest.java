package src;

/**
 * PayPalPayment - concrete strategy for PayPal payments.
 */
public class PayPalPayment implements PaymentStrategy {

    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via PayPal account [" + email + "]");
    }
}
