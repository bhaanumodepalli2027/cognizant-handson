package src;

/**
 * Task - represents a single task in the management system.
 */
public class Task {

    private int    taskId;
    private String taskName;
    private String status;   // e.g., "PENDING", "IN_PROGRESS", "DONE"

    public Task(int taskId, String taskName, String status) {
        this.taskId   = taskId;
        this.taskName = taskName;
        this.status   = status;
    }

    public int    getTaskId()   { return taskId; }
    public String getTaskName() { return taskName; }
    public String getStatus()   { return status; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("Task { id=%-4d name=%-20s status=%s }",
                taskId, taskName, status);
    }
}
