import java.util.Arrays;
import java.util.Comparator;

public class SearchFunction {

    // Linear Search
    public static Product linearSearch(Product[] products, String target) {

        for (Product product : products) {

            if (product.productName.equalsIgnoreCase(target)) {
                return product;
            }
        }

        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String target) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = products[mid].productName.compareToIgnoreCase(target);

            if (result == 0) {
                return products[mid];
            }

            if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {

                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mobile", "Electronics"),
                new Product(103, "Tablet", "Electronics"),
                new Product(104, "Shoes", "Fashion"),
                new Product(105, "Watch", "Accessories")
        };

        String searchProduct = "Tablet";

        Product linearResult = linearSearch(products, searchProduct);

        if (linearResult != null) {

            System.out.println("Linear Search Found:");
            System.out.println(linearResult.productName);
        }

        Arrays.sort(products,
                Comparator.comparing(p -> p.productName));

        Product binaryResult = binarySearch(products, searchProduct);

        if (binaryResult != null) {

            System.out.println("\nBinary Search Found:");
            System.out.println(binaryResult.productName);
        }
    }
}