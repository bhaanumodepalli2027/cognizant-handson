package src;

/**
 * DependencyInjectionTest - demonstrates constructor-based DI.
 *
 * The 'wiring' (creating and passing dependencies) happens here in main(),
 * keeping CustomerService completely decoupled from the concrete repository.
 */
public class DependencyInjectionTest {

    public static void main(String[] args) {
        // 1. Create the concrete repository
        CustomerRepository repository = new CustomerRepositoryImpl();

        // 2. Inject it into the service via the constructor
        CustomerService service = new CustomerService(repository);

        // 3. Use the service
        System.out.println("=== Customer Lookup ===\n");

        service.printCustomerDetails("C001");
        System.out.println();

        service.printCustomerDetails("C003");
        System.out.println();

        // Non-existent customer
        service.printCustomerDetails("C999");
    }
}
