package ad.practice.playground.solution.oop.demo.universityManagementSystem.entity;

import ad.practice.playground.solution.oop.demo.universityManagementSystem.interfaces.Enrollable;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.interfaces.GradeCalculable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Person implements Enrollable, GradeCalculable {
    private String department;
    private int semester;
    private List<String> enrolledCourses;
    private Map<String, Double> courseGrades;

    public Student(String id, String name, String email, String phone,
                   String department, int semester) {
        //call the parent class constructor before going forward
        super(id, name, email, phone);
        this.department = department;
        this.semester = semester;
        this.enrolledCourses = new ArrayList<>();
        this.courseGrades = new HashMap<>();
    }

    // Override displayInfo for polymorphism
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + department);
        System.out.println("Semester: " + semester);
        System.out.println("GPA: " + String.format("%.2f", calculateGPA()));
        System.out.println("Enrolled Courses: " + enrolledCourses.size());
    }

    @Override
    public String getRole() {
        return "Student";
    }

    @Override
    public boolean validateData() {
        return id != null && !id.isEmpty() &&
                name != null && !name.isEmpty() &&
                email != null && email.contains("@");
    }

    @Override
    public String getDetails() {
        return String.format("Student[ID=%s, Name=%s, Department=%s, GPA=%.2f]",
                id, name, department, calculateGPA());
    }


    @Override
    public void enrollInCourse(String courseCode) {
        if (!enrolledCourses.contains(courseCode)) {
            enrolledCourses.add(courseCode);
            System.out.println(name + " enrolled in course: " + courseCode);
        }
    }

    @Override
    public void dropCourse(String courseCode) {
        enrolledCourses.remove(courseCode);
        courseGrades.remove(courseCode);
        System.out.println(name + " dropped course: " + courseCode);
    }

    @Override
    public boolean isEnrolledInCourse(String courseCode) {
        return enrolledCourses.contains(courseCode);
    }

    @Override
    public double calculateGPA() {
        if (courseGrades.isEmpty()) return 0.0;

        double totalPoints = 0.0;
        for (double grade : courseGrades.values()) {
            totalPoints += convertToGradePoints(grade);
        }
        return totalPoints / courseGrades.size();
    }
    private double convertToGradePoints(double marks) {
        if (marks >= 80) return 4.0;
        else if (marks >= 75) return 3.75;
        else if (marks >= 70) return 3.50;
        else if (marks >= 65) return 3.25;
        else if (marks >= 60) return 3.00;
        else if (marks >= 55) return 2.75;
        else if (marks >= 50) return 2.50;
        else if (marks >= 45) return 2.25;
        else if (marks >= 40) return 2.00;
        else return 0.0;
    }

    @Override
    public String getGradeLetter(double marks) {
        if (marks >= 80) return "A+";
        else if (marks >= 75) return "A";
        else if (marks >= 70) return "A-";
        else if (marks >= 65) return "B+";
        else if (marks >= 60) return "B";
        else if (marks >= 55) return "B-";
        else if (marks >= 50) return "C+";
        else if (marks >= 45) return "C";
        else if (marks >= 40) return "D";
        else return "F";
    }
    public void addGrade(String courseCode, double marks) {
        if (enrolledCourses.contains(courseCode)) {
            courseGrades.put(courseCode, marks);
        }
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }

    public List<String> getEnrolledCourses() { return new ArrayList<>(enrolledCourses); }
    public Map<String, Double> getCourseGrades() { return new HashMap<>(courseGrades); }
}
