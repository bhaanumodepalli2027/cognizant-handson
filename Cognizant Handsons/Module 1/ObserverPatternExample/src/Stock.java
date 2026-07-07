package src;

/**
 * Stock - subject interface for the Observer Pattern.
 */
public interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}
