package src;

/**
 * Adapter: Wraps SquareGateway and exposes the PaymentProcessor interface.
 */
public class SquareAdapter implements PaymentProcessor {

    private final SquareGateway squareGateway;

    public SquareAdapter(SquareGateway squareGateway) {
        this.squareGateway = squareGateway;
    }

    @Override
    public void processPayment(double amount) {
        squareGateway.executeTransaction(amount);
    }
}
