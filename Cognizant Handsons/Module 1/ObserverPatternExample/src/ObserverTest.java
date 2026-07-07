package src;

/**
 * Test class demonstrating the Observer Pattern for stock price monitoring.
 */
public class ObserverTest {

    public static void main(String[] args) {
        StockMarket appleStock = new StockMarket("AAPL", 175.00);

        Observer mobileApp = new MobileApp("StockTracker Pro");
        Observer webApp    = new WebApp("FinanceDashboard");

        // Register observers
        appleStock.registerObserver(mobileApp);
        appleStock.registerObserver(webApp);

        // Trigger price updates — all observers get notified
        appleStock.setPrice(178.50);
        appleStock.setPrice(182.00);

        // Deregister the web app and update again
        appleStock.deregisterObserver(webApp);
        appleStock.setPrice(179.25);   // only MobileApp should receive this
    }
}
