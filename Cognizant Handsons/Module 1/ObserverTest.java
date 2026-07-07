package src;

/**
 * MVCTest - main class demonstrating the MVC Pattern for student record management.
 */
public class MVCTest {

    public static void main(String[] args) {
        // Create model
        Student student = new Student("Alice Johnson", "STU-1001", "A");

        // Create view
        StudentView view = new StudentView();

        // Create controller wiring model and view
        StudentController controller = new StudentController(student, view);

        System.out.println("=== Initial Student Record ===");
        controller.updateView();

        // Update via controller (simulates user editing details)
        controller.setStudentName("Alice M. Johnson");
        controller.setStudentGrade("A+");

        System.out.println("\n=== Updated Student Record ===");
        controller.updateView();
    }
}
