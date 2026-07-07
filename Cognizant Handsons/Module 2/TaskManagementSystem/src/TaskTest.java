package src;

/**
 * TaskTest - demonstrates add, search, traverse, and delete on the linked list.
 */
public class TaskTest {

    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        System.out.println("=== Add Tasks ===");
        taskList.addTask(new Task(1, "Design database schema", "PENDING"));
        taskList.addTask(new Task(2, "Implement REST APIs",    "IN_PROGRESS"));
        taskList.addTask(new Task(3, "Write unit tests",       "PENDING"));
        taskList.addTask(new Task(4, "Deploy to staging",      "PENDING"));

        System.out.println("\n=== Traverse ===");
        taskList.traverse();

        System.out.println("\n=== Search for task id=2 ===");
        Task found = taskList.searchById(2);
        System.out.println(found != null ? "Found: " + found : "Not found");

        System.out.println("\n=== Search for task id=99 ===");
        found = taskList.searchById(99);
        System.out.println(found != null ? "Found: " + found : "Not found");

        System.out.println("\n=== Delete task id=3 ===");
        taskList.deleteById(3);

        System.out.println("\n=== Traverse after deletion ===");
        taskList.traverse();

        System.out.println("\n=== Delete head task ===");
        taskList.deleteById(4);   // head because addTask prepends

        System.out.println("\n=== Final list ===");
        taskList.traverse();
    }
}
