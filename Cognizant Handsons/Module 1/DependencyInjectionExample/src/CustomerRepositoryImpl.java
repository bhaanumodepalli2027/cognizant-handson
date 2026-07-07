package src;

import java.util.HashMap;
import java.util.Map;

/**
 * CustomerRepositoryImpl - concrete repository backed by an in-memory store.
 */
public class CustomerRepositoryImpl implements CustomerRepository {

    private final Map<String, Customer> store = new HashMap<>();

    public CustomerRepositoryImpl() {
        // Seed some sample data
        store.put("C001", new Customer("C001", "Alice Johnson", "alice@example.com"));
        store.put("C002", new Customer("C002", "Bob Smith",     "bob@example.com"));
        store.put("C003", new Customer("C003", "Carol White",   "carol@example.com"));
    }

    @Override
    public Customer findCustomerById(String id) {
        Customer customer = store.get(id);
        if (customer == null) {
            System.out.println("CustomerRepositoryImpl: No customer found with id=" + id);
        }
        return customer;
    }
}
