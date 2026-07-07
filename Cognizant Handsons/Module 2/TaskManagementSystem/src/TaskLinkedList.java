package src;

/**
 * TaskLinkedList - singly linked list for managing tasks.
 *
 * Linked List types:
 *  - Singly Linked List : each node holds data + one 'next' pointer.
 *  - Doubly Linked List : each node holds data + 'next' + 'prev' pointers (bi-directional traversal).
 *
 * Time Complexity:
 *  - Add (head)   : O(1)
 *  - Add (tail)   : O(n) — traverse to end (or O(1) with a tail pointer)
 *  - Search       : O(n)
 *  - Traverse     : O(n)
 *  - Delete       : O(n) — find predecessor then unlink
 *
 * Advantages over arrays:
 *  - Dynamic size — no pre-allocation needed.
 *  - O(1) insertion/deletion at head (no shifting).
 *  - Memory allocated per-node, only as needed.
 */
public class TaskLinkedList {

    // Internal node class
    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;
    private int  size;

    // ----------------------------------------------------------------
    // Add at head  — O(1)
    // ----------------------------------------------------------------
    public void addTask(Task task) {
        Node newNode = new Node(task);
        newNode.next = head;
        head         = newNode;
        size++;
        System.out.println("Added: " + task);
    }

    // ----------------------------------------------------------------
    // Search by taskId  — O(n)
    // ----------------------------------------------------------------
    public Task searchById(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // ----------------------------------------------------------------
    // Traverse  — O(n)
    // ----------------------------------------------------------------
    public void traverse() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        System.out.println("--- Task List (" + size + ") ---");
        Node current = head;
        while (current != null) {
            System.out.println("  " + current.task);
            current = current.next;
        }
        System.out.println("------------------------");
    }

    // ----------------------------------------------------------------
    // Delete by taskId  — O(n)
    // ----------------------------------------------------------------
    public boolean deleteById(int taskId) {
        if (head == null) return false;

        // Special case: head is the target
        if (head.task.getTaskId() == taskId) {
            System.out.println("Deleted: " + head.task);
            head = head.next;
            size--;
            return true;
        }

        // General case: find the node before the target
        Node current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId() == taskId) {
                System.out.println("Deleted: " + current.next.task);
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }

        System.out.println("DELETE failed: task id " + taskId + " not found.");
        return false;
    }
}
