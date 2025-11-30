package ad.practice.playground.solution.oop.demo.universityManagementSystem.entity;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Person{
    private String department;
    private String specialization;
    private List<String> coursesTeaching;

    public Professor(String id, String name, String email, String phone,
                     String department, String specialization) {
        super(id, name, email, phone);
        this.department = department;
        this.specialization = specialization;
        this.coursesTeaching = new ArrayList<>();
    }

    @Override
    public String getRole() {
        return "Professor";
    }

    @Override
    public boolean validateData() {
        return id != null && !id.isEmpty() &&
                name != null && !name.isEmpty() &&
                email != null && email.contains("@") &&
                phone != null && !phone.isEmpty() &&
                specialization != null && !specialization.isEmpty() &&
                department != null && !department.isEmpty();
    }

    @Override
    public String getDetails() {
        return String.format("Professor[ID=%s, Name=%s, Specialization=%s]",
                id, name, specialization);
    }
    public void addCourse(String courseCode) {
        if (!coursesTeaching.contains(courseCode)) {
            coursesTeaching.add(courseCode);
        }
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public List<String> getCoursesTeaching() { return new ArrayList<>(coursesTeaching); }
}
