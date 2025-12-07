package ad.practice.playground.solution.oop.demo.universityManagementSystem.entity;

import ad.practice.playground.solution.oop.demo.universityManagementSystem.enums.Department;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.enums.StudentStatus;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.interfaces.Enrollable;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.interfaces.FinancialAidEligible;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.interfaces.GradeCalculable;

import java.util.*;
import java.util.zip.DataFormatException;

public class Student extends Person implements Enrollable, GradeCalculable, FinancialAidEligible {
    private Department department;
    private int semester;
    private List<String> enrolledCourses;
    private Map<String, Double> courseGrades;
    private StudentStatus status;
    private double tuitionFee;
    private double scholarshipAmount;
    Map<String, Integer> courseCredits;
    private Date enrollmentDate;
    private boolean thesisCompleted;

    public Student(String id, String name, String email, String phone,
                   Department department, int semester, double tuitionFee) {
        super(id, name, email, phone);
        this.department = department;
        this.semester = semester;
        this.tuitionFee = tuitionFee;
        this.scholarshipAmount = 0.0;
        this.status = StudentStatus.ACTIVE;
        this.enrolledCourses = new ArrayList<>();
        this.courseGrades = new HashMap<>();
        this.courseCredits = new HashMap<>();
        this.enrollmentDate = new Date();
    }


    // Override displayInfo for polymorphism
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + department.getFullName());
        System.out.println("Semester: " + semester);
        System.out.println("Status: " + status.getStatus());
        System.out.println("GPA: " + String.format("%.2f", calculateGPA()));
        System.out.println("Total Credits: " + getTotalCredits());
        System.out.println("Tuition Fee: $" + tuitionFee);
        System.out.println("Scholarship: $" + scholarshipAmount);
        System.out.println("Net Fee: $" + calculateTotalFees());
        System.out.println("Dean's List: " + (isOnDeanList() ? "Yes" : "No"));
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
                email != null && email.contains("@") &&
                department != null;
    }

    @Override
    public String getDetails() {
        return String.format("EnhancedStudent[ID=%s, Name=%s, Department=%s, GPA=%.2f, Status=%s]",
                id, name, department.getFullName(), calculateGPA(), status.getStatus());
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    public void setScholarshipAmount(double scholarshipAmount) {
        this.scholarshipAmount = scholarshipAmount;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }

    public List<String> getEnrolledCourses() { return new ArrayList<>(enrolledCourses); }
    public Map<String, Double> getCourseGrades() { return new HashMap<>(courseGrades); }


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
        int totalCredits = 0;
        // Iterating through the map
        for (Map.Entry<String, Double> entry : courseGrades.entrySet()) {
            String courseCode = entry.getKey();
            double grade = entry.getValue();
            int credits = courseCredits.getOrDefault(courseCode, 3);
            totalPoints += convertToGradePoints(grade) * credits;
            totalCredits += credits;
        }
        return totalCredits > 0 ? totalPoints / totalCredits : 0.0;
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
    public void addGrade(String courseCode, double marks, int credits) {
        if (marks < 0 || marks > 100) {
            throw new IllegalStateException("Grade must be between 0 and 100");
        }
        if (enrolledCourses.contains(courseCode)) {
            courseGrades.put(courseCode, marks);
            courseCredits.put(courseCode, credits);
        }else {
            throw new IllegalArgumentException("No such course-code : "+courseCode);
        }
    }

    public double calculateTotalFees() {
        return tuitionFee - scholarshipAmount;
    }

    public int getTotalCredits() {
        return courseCredits.values().stream().mapToInt(Integer::intValue).sum();
    }

    public boolean isOnDeanList() {
        return calculateGPA() >= 3.75 && getTotalCredits() >= 12;
    }

    @Override
    public boolean checkEligibility() {
        // students obtained gpa 3.75 or higher , eligible for scholarship
        return calculateGPA() >= 3.75 && status == StudentStatus.ACTIVE;
    }

    @Override
    public double calculateFinancialAid() {
        if (checkEligibility()) {
            double gpa = calculateGPA();
            if (gpa >= 3.9) return tuitionFee * 0.5; // 50% scholarship
            else if (gpa >= 3.8) return tuitionFee * 0.35; // 35% scholarship
            else if (gpa >= 3.75) return tuitionFee * 0.3; // 30% scholarship
        }
        return 0.0;
    }

    @Override
    public void applyForScholarship(String scholarshipName) {
        double aid = calculateFinancialAid();
        if (aid > 0) {
            this.scholarshipAmount = aid;
            System.out.println(name + " awarded " + scholarshipName + ": BDT" + aid);
        } else {
            System.out.println(name + " not eligible for " + scholarshipName);
        }
    }

    public void completeThesis() {
        this.thesisCompleted = true;
        System.out.println(name + " has completed thesis defense");
    }
}
