package src;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Inventory - manages products using a HashMap for O(1) average-case operations.
 *
 * Why HashMap?
 *  - Direct key-based lookup by productId avoids scanning every element.
 *  - Add / Update / Delete are all O(1) average, O(n) worst-case (hash collision).
 *  - ArrayList would give O(n) lookup and delete because it requires a linear scan.
 */
public class Inventory {

    // Key = productId, Value = Product
    private final Map<Integer, Product> store = new HashMap<>();

    // ----------------------------------------------------------------
    // Add  — O(1) average
    // ----------------------------------------------------------------
    public void addProduct(Product product) {
        if (store.containsKey(product.getProductId())) {
            System.out.println("ADD failed: product id " + product.getProductId() + " already exists.");
            return;
        }
        store.put(product.getProductId(), product);
        System.out.println("Added: " + product);
    }

    // ----------------------------------------------------------------
    // Update  — O(1) average
    // ----------------------------------------------------------------
    public void updateProduct(int productId, String newName, int newQty, double newPrice) {
        Product p = store.get(productId);
        if (p == null) {
            System.out.println("UPDATE failed: product id " + productId + " not found.");
            return;
        }
        p.setProductName(newName);
        p.setQuantity(newQty);
        p.setPrice(newPrice);
        System.out.println("Updated: " + p);
    }

    // ----------------------------------------------------------------
    // Delete  — O(1) average
    // ----------------------------------------------------------------
    public void deleteProduct(int productId) {
        Product removed = store.remove(productId);
        if (removed == null) {
            System.out.println("DELETE failed: product id " + productId + " not found.");
        } else {
            System.out.println("Deleted: " + removed);
        }
    }

    // ----------------------------------------------------------------
    // Display all  — O(n)
    // ----------------------------------------------------------------
    public void displayAll() {
        if (store.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("--- Inventory ---");
        Collection<Product> products = store.values();
        for (Product p : products) {
            System.out.println("  " + p);
        }
        System.out.println("-----------------");
    }
}
