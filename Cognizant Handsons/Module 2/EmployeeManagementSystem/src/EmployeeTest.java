package src;

/**
 * EmployeeTest - demonstrates add, search, traverse, and delete operations.
 */
public class EmployeeTest {

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        System.out.println("=== Add Employees ===");
        manager.addEmployee(new Employee(1, "Alice Johnson", "Software Engineer", 85000));
        manager.addEmployee(new Employee(2, "Bob Smith",     "Project Manager",   92000));
        manager.addEmployee(new Employee(3, "Carol White",   "QA Engineer",       72000));
        manager.addEmployee(new Employee(4, "David Lee",     "DevOps Engineer",   88000));

        System.out.println("\n=== Traverse All ===");
        manager.traverse();

        System.out.println("\n=== Search for Employee id=3 ===");
        Employee found = manager.searchById(3);
        System.out.println(found != null ? "Found: " + found : "Not found");

        System.out.println("\n=== Search for Employee id=99 ===");
        found = manager.searchById(99);
        System.out.println(found != null ? "Found: " + found : "Not found");

        System.out.println("\n=== Delete Employee id=2 ===");
        manager.deleteById(2);

        System.out.println("\n=== Traverse after deletion ===");
        manager.traverse();
    }
}
