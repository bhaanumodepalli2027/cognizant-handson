package src;

import java.util.ArrayList;
import java.util.List;

/**
 * StockMarket - concrete subject that maintains and notifies observers.
 */
public class StockMarket implements Stock {

    private final List<Observer> observers = new ArrayList<>();
    private String stockSymbol;
    private double price;

    public StockMarket(String stockSymbol, double initialPrice) {
        this.stockSymbol = stockSymbol;
        this.price       = initialPrice;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Observer registered: " + observer.getClass().getSimpleName());
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Observer deregistered: " + observer.getClass().getSimpleName());
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockSymbol, price);
        }
    }

    /** Update the stock price and push the change to all observers. */
    public void setPrice(double newPrice) {
        System.out.println("\n[StockMarket] " + stockSymbol + " price changed: $"
                + this.price + " -> $" + newPrice);
        this.price = newPrice;
        notifyObservers();
    }

    public double getPrice()       { return price; }
    public String getStockSymbol() { return stockSymbol; }
}
