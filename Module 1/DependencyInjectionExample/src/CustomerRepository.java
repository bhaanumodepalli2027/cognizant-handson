package src;

/**
 * CustomerRepository - interface defining data access operations for customers.
 */
public interface CustomerRepository {
    Customer findCustomerById(String id);
}
