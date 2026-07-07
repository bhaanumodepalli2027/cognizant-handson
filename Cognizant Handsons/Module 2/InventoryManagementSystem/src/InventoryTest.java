package src;

/**
 * InventoryTest - demonstrates add, update, delete operations on the inventory.
 *
 * Time Complexity Analysis (HashMap):
 *  - Add    : O(1) average — hash lookup + insert
 *  - Update : O(1) average — hash lookup + field mutation
 *  - Delete : O(1) average — hash lookup + removal
 *
 * Optimization notes:
 *  - Initial capacity can be set to avoid rehashing for known large inventories.
 *  - Load factor can be tuned (default 0.75) to balance memory vs. collision rate.
 */
public class InventoryTest {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        System.out.println("=== Add Products ===");
        inventory.addProduct(new Product(101, "Laptop",        50,  899.99));
        inventory.addProduct(new Product(102, "Wireless Mouse", 200, 29.99));
        inventory.addProduct(new Product(103, "USB-C Hub",      150, 49.99));
        inventory.addProduct(new Product(104, "Monitor 27\"",   30,  349.99));

        System.out.println("\n=== Display All ===");
        inventory.displayAll();

        System.out.println("\n=== Update Product 102 ===");
        inventory.updateProduct(102, "Ergonomic Mouse", 180, 39.99);

        System.out.println("\n=== Delete Product 103 ===");
        inventory.deleteProduct(103);

        System.out.println("\n=== Delete non-existent product ===");
        inventory.deleteProduct(999);

        System.out.println("\n=== Final Inventory ===");
        inventory.displayAll();
    }
}
