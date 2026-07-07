package src;

/**
 * LibrarySearch - implements Linear and Binary Search for books by title.
 *
 * Linear Search:
 *  - Works on any array (sorted or unsorted).
 *  - O(n) time — scans every element until a match is found.
 *  - Suitable for small collections or one-off queries on unsorted data.
 *
 * Binary Search:
 *  - Requires the array sorted alphabetically by title.
 *  - O(log n) time — halves the search space on each step.
 *  - Suitable for large, frequently queried collections where maintaining
 *    a sorted order is practical.
 */
public class LibrarySearch {

    // ----------------------------------------------------------------
    // Linear Search by title (case-insensitive)  — O(n)
    // ----------------------------------------------------------------
    public static Book linearSearchByTitle(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // ----------------------------------------------------------------
    // Binary Search by title (array must be sorted A-Z by title)  — O(log n)
    // ----------------------------------------------------------------
    public static Book binarySearchByTitle(Book[] sortedBooks, String title) {
        int low  = 0;
        int high = sortedBooks.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = sortedBooks[mid].getTitle().compareToIgnoreCase(title);

            if (cmp == 0) {
                return sortedBooks[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
