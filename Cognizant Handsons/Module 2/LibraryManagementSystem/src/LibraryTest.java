package src;

/**
 * LibraryTest - demonstrates linear and binary search on library books.
 *
 * When to use each:
 *  - Linear Search : small collections, unsorted data, infrequent queries.
 *  - Binary Search : large collections, data already sorted, frequent queries.
 */
public class LibraryTest {

    public static void main(String[] args) {

        // Unsorted — for linear search
        Book[] unsortedBooks = {
            new Book(4, "The Great Gatsby",              "F. Scott Fitzgerald"),
            new Book(1, "Clean Code",                    "Robert C. Martin"),
            new Book(6, "Design Patterns",               "Gang of Four"),
            new Book(2, "Effective Java",                "Joshua Bloch"),
            new Book(5, "Introduction to Algorithms",    "Cormen et al."),
            new Book(3, "The Pragmatic Programmer",      "Hunt & Thomas"),
        };

        // Sorted alphabetically by title — for binary search
        Book[] sortedBooks = {
            new Book(1, "Clean Code",                    "Robert C. Martin"),
            new Book(6, "Design Patterns",               "Gang of Four"),
            new Book(2, "Effective Java",                "Joshua Bloch"),
            new Book(5, "Introduction to Algorithms",    "Cormen et al."),
            new Book(4, "The Great Gatsby",              "F. Scott Fitzgerald"),
            new Book(3, "The Pragmatic Programmer",      "Hunt & Thomas"),
        };

        // --- Linear Search ---
        System.out.println("=== Linear Search ===");
        String target1 = "Effective Java";
        Book found = LibrarySearch.linearSearchByTitle(unsortedBooks, target1);
        System.out.println("Searching \"" + target1 + "\" -> "
                + (found != null ? found : "Not found"));

        String target2 = "Unknown Book";
        found = LibrarySearch.linearSearchByTitle(unsortedBooks, target2);
        System.out.println("Searching \"" + target2 + "\" -> "
                + (found != null ? found : "Not found"));

        // --- Binary Search ---
        System.out.println("\n=== Binary Search ===");
        found = LibrarySearch.binarySearchByTitle(sortedBooks, target1);
        System.out.println("Searching \"" + target1 + "\" -> "
                + (found != null ? found : "Not found"));

        found = LibrarySearch.binarySearchByTitle(sortedBooks, target2);
        System.out.println("Searching \"" + target2 + "\" -> "
                + (found != null ? found : "Not found"));

        String target3 = "Clean Code";
        found = LibrarySearch.binarySearchByTitle(sortedBooks, target3);
        System.out.println("Searching \"" + target3 + "\" -> "
                + (found != null ? found : "Not found"));
    }
}
