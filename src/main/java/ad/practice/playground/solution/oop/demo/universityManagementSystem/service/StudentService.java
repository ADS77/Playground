package ad.practice.playground.solution.oop.demo.universityManagementSystem.service;

import ad.practice.playground.solution.oop.demo.universityManagementSystem.entity.Attendance;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.entity.Student;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.enums.Department;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.enums.StudentQuality;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.interfaces.FinancialAidEligible;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.interfaces.GradeCalculable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class StudentService {
    private static Logger logger = LoggerFactory.getLogger(StudentService.class);
    private List<Student> students;
    private Map<String, List<Attendance>> attendanceRecords;

    // Constructor based dependency injection
    public StudentService() {
        this.students = new ArrayList<>();
        this.attendanceRecords = new HashMap<>();
    }

    public void addStudent(Student student) {
        if (student.validateData()) {
            students.add(student);
            logger.debug("Student added successfully: {}",student.getName());
        } else {
            logger.debug("Invalid student data!");
        }
    }
    public Student findStudentById(String id) {
        if (id == null) return null;
        for (Student s : students) {
            if (s != null && id.equals(s.getId())) {
                return s;
            }
        }
        logger.error("Student not found for id :{}", id);
        return null;
    }
    public List<Student> getStudentsByDepartment(Department department) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getDepartment().getCode().equalsIgnoreCase(department.getCode())) {
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
        System.out.println("ALL STUDENTS");
        for (Student student : students) {
            student.displayInfo();
            System.out.println("-------------------");
        }
    }

    public List<Student> getDeanListStudents() {
        List<Student> deanListHolders = new ArrayList<>();
        for(Student student : students){
            if(student.isOnDeanList()){
                deanListHolders.add(student);
            }
        }
        return  deanListHolders;
    }


    public void generateDepartmentReport() {
        System.out.println("DEPARTMENT REPORT");
        Map<Department, Long> studentCountByDept = new HashMap<>();
        for (Student student : students) {
            Department dept = student.getDepartment();
            // increment count manually
            studentCountByDept.put(dept, studentCountByDept.getOrDefault(dept, 0L) + 1);
        }
        for (Map.Entry<Department, Long> entry : studentCountByDept.entrySet()) {
            System.out.println(entry.getKey().getFullName() + ": " + entry.getValue() + " students");
        }

    }

    public void generateGPADistribution() {
        System.out.println("GPA DISTRIBUTION");
        Map<StudentQuality, Long> gpaDistribution = new HashMap<>();
        gpaDistribution.put(StudentQuality.EXCELLENT, 0L);
        gpaDistribution.put(StudentQuality.GOOD, 0L);
        gpaDistribution.put(StudentQuality.AVERAGE, 0L);
        gpaDistribution.put(StudentQuality.POOR, 0L);
        for (Student student : students) {
            double gpa = student.calculateGPA();
            StudentQuality key;
            if (gpa >= 3.5) key = StudentQuality.EXCELLENT;
            else if (gpa >= 3.25) key = StudentQuality.GOOD;
            else if (gpa >= 3.0) key = StudentQuality.AVERAGE;
            else key = StudentQuality.POOR;

            gpaDistribution.put(key, gpaDistribution.get(key) + 1);
        }
        for (Map.Entry<StudentQuality, Long> entry : gpaDistribution.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " students");
        }

    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public void displayFinancialAidReport(FinancialAidEligible student) {
        System.out.println("Eligible for financial aid: " + student.checkEligibility());
        System.out.println("Financial aid amount: BDT" + student.calculateFinancialAid());
    }
}
