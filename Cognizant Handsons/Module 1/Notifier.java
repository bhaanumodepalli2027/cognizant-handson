package src;

/**
 * Test class demonstrating the Decorator Pattern for multi-channel notifications.
 */
public class DecoratorTest {

    public static void main(String[] args) {
        String alert = "System alert: CPU usage exceeded 90%!";

        System.out.println("=== Email only ===");
        Notifier emailOnly = new EmailNotifier("admin@company.com");
        emailOnly.send(alert);

        System.out.println("\n=== Email + SMS ===");
        Notifier emailAndSMS = new SMSNotifierDecorator(
                new EmailNotifier("admin@company.com"),
                "+1-555-0100"
        );
        emailAndSMS.send(alert);

        System.out.println("\n=== Email + SMS + Slack ===");
        Notifier allChannels = new SlackNotifierDecorator(
                new SMSNotifierDecorator(
                        new EmailNotifier("admin@company.com"),
                        "+1-555-0100"
                ),
                "#ops-alerts"
        );
        allChannels.send(alert);
    }
}
