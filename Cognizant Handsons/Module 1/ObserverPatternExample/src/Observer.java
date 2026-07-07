package src;

/**
 * Observer - interface for all stock price observers.
 */
public interface Observer {
    void update(String stockSymbol, double price);
}
