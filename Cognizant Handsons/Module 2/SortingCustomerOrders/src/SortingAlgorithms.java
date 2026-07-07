package src;

/**
 * SortingAlgorithms - Bubble Sort and Quick Sort for Order arrays.
 *
 * Bubble Sort:
 *  - Best case  : O(n)   — already sorted (with early-exit flag).
 *  - Average    : O(n²)
 *  - Worst case : O(n²)
 *  - Space      : O(1)   — in-place
 *
 * Quick Sort:
 *  - Best case  : O(n log n) — balanced partitions.
 *  - Average    : O(n log n)
 *  - Worst case : O(n²)      — already sorted + bad pivot choice (rare with median-of-3).
 *  - Space      : O(log n)   — recursive call stack.
 *
 * Why Quick Sort is preferred:
 *  - Lower constant factors than Merge Sort.
 *  - In-place (no extra array allocation).
 *  - Worst case can be avoided with randomised/median-of-3 pivot selection.
 */
public class SortingAlgorithms {

    // ----------------------------------------------------------------
    // Bubble Sort — ascending by totalPrice
    // ----------------------------------------------------------------
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    swap(orders, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;   // early exit if already sorted
        }
    }

    // ----------------------------------------------------------------
    // Quick Sort — ascending by totalPrice
    // ----------------------------------------------------------------
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low,          pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                swap(orders, i, j);
            }
        }
        swap(orders, i + 1, high);
        return i + 1;
    }

    private static void swap(Order[] orders, int a, int b) {
        Order temp  = orders[a];
        orders[a]   = orders[b];
        orders[b]   = temp;
    }
}
