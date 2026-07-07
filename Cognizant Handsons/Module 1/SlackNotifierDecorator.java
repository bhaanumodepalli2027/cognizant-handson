package src;

/**
 * NotifierDecorator - abstract base decorator.
 * Wraps a Notifier and delegates to it, allowing subclasses to add behaviour.
 */
public abstract class NotifierDecorator implements Notifier {

    protected final Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}
