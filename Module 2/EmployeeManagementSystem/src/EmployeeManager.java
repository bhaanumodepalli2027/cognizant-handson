package src;

/**
 * EmployeeManager - manages employee records using a fixed-size array.
 *
 * Arrays in memory:
 *  - Stored as a contiguous block; index i is at base_address + i * element_size.
 *  - Random access is O(1) because the address is computed directly.
 *
 * Time Complexity:
 *  - Add      : O(1) amortised — append at next free slot.
 *  - Search   : O(n) — linear scan (no index on employeeId).
 *  - Traverse : O(n) — visit every element.
 *  - Delete   : O(n) — find element + shift remaining elements left.
 *
 * Limitations of arrays:
 *  - Fixed size declared at creation; resizing requires copying the whole array.
 *  - Delete leaves a gap that must be closed by shifting.
 *  - Insertion in the middle is O(n) due to shifting.
 */
public class EmployeeManager {

    private static final int MAX_SIZE = 100;
    private final Employee[] employees = new Employee[MAX_SIZE];
    private int size = 0;

    // ----------------------------------------------------------------
    // Add  — O(1) amortised
    // ----------------------------------------------------------------
    public boolean addEmployee(Employee emp) {
        if (size == MAX_SIZE) {
            System.out.println("ADD failed: storage is full.");
            return false;
        }
        employees[size++] = emp;
        System.out.println("Added: " + emp);
        return true;
    }

    // ----------------------------------------------------------------
    // Search by employeeId  — O(n)
    // ----------------------------------------------------------------
    public Employee searchById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // ----------------------------------------------------------------
    // Traverse  — O(n)
    // ----------------------------------------------------------------
    public void traverse() {
        if (size == 0) {
            System.out.println("No employees on record.");
            return;
        }
        System.out.println("--- All Employees (" + size + ") ---");
        for (int i = 0; i < size; i++) {
            System.out.println("  " + employees[i]);
        }
        System.out.println("-------------------------------");
    }

    // ----------------------------------------------------------------
    // Delete by employeeId  — O(n)
    // ----------------------------------------------------------------
    public boolean deleteById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                System.out.println("Deleted: " + employees[i]);
                // Shift elements left to fill the gap
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;   // clear the last slot
                return true;
            }
        }
        System.out.println("DELETE failed: employee id " + employeeId + " not found.");
        return false;
    }
}
