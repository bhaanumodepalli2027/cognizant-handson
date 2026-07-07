package src;

/**
 * PaymentContext - holds a PaymentStrategy and delegates execution to it.
 * The strategy can be swapped at runtime.
 */
public class PaymentContext {

    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    /** Allows swapping the payment method at runtime. */
    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    /** Execute the currently selected payment strategy. */
    public void executePayment(double amount) {
        strategy.pay(amount);
    }
}
