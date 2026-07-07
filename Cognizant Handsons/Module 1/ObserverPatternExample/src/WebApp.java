package src;

/**
 * WebApp - concrete observer that reacts to stock price changes.
 */
public class WebApp implements Observer {

    private final String portalName;

    public WebApp(String portalName) {
        this.portalName = portalName;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("  [WebApp - " + portalName + "] Dashboard updated: "
                + stockSymbol + " = $" + price);
    }
}
