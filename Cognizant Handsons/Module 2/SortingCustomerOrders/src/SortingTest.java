package src;

import java.util.Arrays;

/**
 * SortingTest - demonstrates Bubble Sort and Quick Sort on customer orders.
 */
public class SortingTest {

    public static void main(String[] args) {

        Order[] original = {
            new Order(1001, "Alice",   250.00),
            new Order(1002, "Bob",     89.50),
            new Order(1003, "Carol",   540.75),
            new Order(1004, "David",   120.00),
            new Order(1005, "Eve",     330.20),
            new Order(1006, "Frank",   75.00),
        };

        // Deep-copy for each sort to keep results independent
        Order[] bubbleArray = Arrays.copyOf(original, original.length);
        Order[] quickArray  = Arrays.copyOf(original, original.length);

        System.out.println("=== Original Orders ===");
        printOrders(original);

        // Bubble Sort
        SortingAlgorithms.bubbleSort(bubbleArray);
        System.out.println("\n=== After Bubble Sort (ascending by totalPrice) ===");
        printOrders(bubbleArray);

        // Quick Sort
        SortingAlgorithms.quickSort(quickArray, 0, quickArray.length - 1);
        System.out.println("\n=== After Quick Sort (ascending by totalPrice) ===");
        printOrders(quickArray);
    }

    private static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println("  " + o);
        }
    }
}
