package src;

/**
 * Adaptee: Square's proprietary gateway interface.
 */
public class SquareGateway {
    public void executeTransaction(double amount) {
        System.out.println("Square: Executing transaction of $" + amount);
    }
}
