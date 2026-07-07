package src;

/**
 * StudentView - View class responsible for presenting student details.
 */
public class StudentView {

    public void displayStudentDetails(String name, String id, String grade) {
        System.out.println("+-----------------------+");
        System.out.println("  Student Details");
        System.out.println("+-----------------------+");
        System.out.println("  Name  : " + name);
        System.out.println("  ID    : " + id);
        System.out.println("  Grade : " + grade);
        System.out.println("+-----------------------+");
    }
}
