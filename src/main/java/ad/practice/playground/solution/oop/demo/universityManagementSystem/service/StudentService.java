package ad.practice.playground.solution.oop.demo.universityManagementSystem.service;

import ad.practice.playground.solution.oop.demo.universityManagementSystem.entity.Student;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.interfaces.GradeCalculable;

import java.util.*;

public class StudentService {
    private List<Student> students;

    public StudentService() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (student.validateData()) {
            students.add(student);
            System.out.println("Student added successfully: " + student.getName());
        } else {
            System.out.println("Invalid student data!");
        }
    }
    public Student findStudentById(String id) {
        if (id == null) return null;
        for (Student s : students) {
            if (s != null && id.equals(s.getId())) {
                return s;
            }
        }
        return null;
    }
    public List<Student> getStudentsByDepartment(String department) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getDepartment().equalsIgnoreCase(department)) {
                result.add(student);
            }
        }
        return result;
    }

    // Polymorphism in action - works with any GradeCalculable object
    public void displayGPAReport(GradeCalculable gradeCalculable) {
        System.out.println("GPA: " + String.format("%.2f", gradeCalculable.calculateGPA()));
    }
    public void displayAllStudents() {
        System.out.println("\n=== ALL STUDENTS ===");
        for (Student student : students) {
            student.displayInfo();
            System.out.println("-------------------");
        }
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }


}
