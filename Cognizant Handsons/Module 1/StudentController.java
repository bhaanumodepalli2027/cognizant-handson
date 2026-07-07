package src;

/**
 * CustomerService - service class that depends on CustomerRepository.
 * The dependency is injected via the constructor (Constructor Injection).
 */
public class CustomerService {

    private final CustomerRepository customerRepository;

    /** Constructor injection — no 'new' keyword inside this class. */
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(String id) {
        System.out.println("CustomerService: Looking up customer with id=" + id);
        return customerRepository.findCustomerById(id);
    }

    public void printCustomerDetails(String id) {
        Customer customer = getCustomerById(id);
        if (customer != null) {
            System.out.println("Details: " + customer);
        }
    }
}
