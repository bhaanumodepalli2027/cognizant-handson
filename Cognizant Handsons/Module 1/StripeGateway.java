package src;

/**
 * CreditCardPayment - concrete strategy for credit card payments.
 */
public class CreditCardPayment implements PaymentStrategy {

    private final String cardNumber;
    private final String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber     = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card ["
                + maskCard(cardNumber) + "] held by " + cardHolderName);
    }

    /** Masks all but the last 4 digits for display. */
    private String maskCard(String number) {
        return "**** **** **** " + number.substring(number.length() - 4);
    }
}
