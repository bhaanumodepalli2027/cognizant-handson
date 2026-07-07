package src;

/**
 * Test class demonstrating lazy initialization and caching via the Proxy Pattern.
 */
public class ProxyTest {

    public static void main(String[] args) {
        Image img1 = new ProxyImage("photo_landscape.jpg");
        Image img2 = new ProxyImage("photo_portrait.jpg");

        // First display — triggers remote load
        System.out.println("--- First display of img1 ---");
        img1.display();

        // Second display — uses cache, no remote load
        System.out.println("\n--- Second display of img1 ---");
        img1.display();

        // img2 has not been displayed yet — will trigger its own load
        System.out.println("\n--- First display of img2 ---");
        img2.display();

        System.out.println("\n--- Second display of img2 ---");
        img2.display();
    }
}
