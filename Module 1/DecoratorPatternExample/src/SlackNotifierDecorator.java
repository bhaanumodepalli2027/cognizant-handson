package src;

/**
 * SlackNotifierDecorator - adds Slack notification on top of the wrapped notifier.
 */
public class SlackNotifierDecorator extends NotifierDecorator {

    private final String slackChannel;

    public SlackNotifierDecorator(Notifier notifier, String slackChannel) {
        super(notifier);
        this.slackChannel = slackChannel;
    }

    @Override
    public void send(String message) {
        super.send(message);                                              // delegate to wrapped
        System.out.println("Slack [" + slackChannel + "]: " + message);
    }
}
