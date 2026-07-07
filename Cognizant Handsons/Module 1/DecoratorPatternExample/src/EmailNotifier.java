package src;

/**
 * EmailNotifier - concrete component; the base notification channel.
 */
public class EmailNotifier implements Notifier {

    private final String emailAddress;

    public EmailNotifier(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void send(String message) {
        System.out.println("Email to [" + emailAddress + "]: " + message);
    }
}
