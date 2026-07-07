package src;

/**
 * StudentController - Controller that mediates between Student (model) and StudentView (view).
 */
public class StudentController {

    private final Student     model;
    private final StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view  = view;
    }

    // --- Getters (read from model) ---
    public String getStudentName()  { return model.getName(); }
    public String getStudentId()    { return model.getId(); }
    public String getStudentGrade() { return model.getGrade(); }

    // --- Setters (update model) ---
    public void setStudentName(String name)   { model.setName(name); }
    public void setStudentId(String id)       { model.setId(id); }
    public void setStudentGrade(String grade) { model.setGrade(grade); }

    /** Push current model state to the view. */
    public void updateView() {
        view.displayStudentDetails(
                model.getName(),
                model.getId(),
                model.getGrade()
        );
    }
}
