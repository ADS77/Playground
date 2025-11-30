package ad.practice.playground.solution.oop.demo.universityManagementSystem;

import ad.practice.playground.solution.oop.demo.universityManagementSystem.entity.GraduateStudent;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.entity.Person;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.entity.Professor;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.entity.Student;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.interfaces.Displayable;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.interfaces.GradeCalculable;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.service.CourseService;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.service.StudentService;

import java.util.*;

public class UniversityManagementSystem {
    public static void main(String[] args){
        // Initialize services
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();

        System.out.println("=== UNIVERSITY MANAGEMENT SYSTEM ===\n");

        // Create students (Inheritance)
        Student undergradStudent = new Student("S001", "Rahim", "rahim@university.com",
                "123-4567", "Computer Science & Engineering", 3);

        GraduateStudent gradStudent = new GraduateStudent("S002", "Karim", "karim@university.com",
                "123-4568", "Physics", 2,
                "Quantum Computing", "Dr. Einstein");

        // Create professor
        Professor professor = new Professor("P001", "Dr. Wilson", "wilson@university.com",
                "123-4569", "Computer Science & Engineering", "Artificial Intelligence");

        // Add students to service (Encapsulation)
        studentService.addStudent(undergradStudent);
        studentService.addStudent(gradStudent);

        // Demonstrate polymorphism with Person abstract class
        System.out.println("\n=== POLYMORPHISM DEMONSTRATION ===");
        List<Person> people = Arrays.asList(undergradStudent, gradStudent, professor);

        for (Person person : people) {
            System.out.println("\nPerson Details:");
            person.displayInfo(); // Polymorphic method call
            System.out.println("Role: " + person.getRole());
        }

        // Demonstrate interface implementation
        System.out.println("\n=== INTERFACE DEMONSTRATION ===");
        Displayable[] displayables = {undergradStudent, gradStudent, professor};
        for (Displayable displayable : displayables) {
            System.out.println(displayable.getDetails());
        }

        // Course enrollment (Interface usage)
        System.out.println("\n=== COURSE ENROLLMENT ===");
        courseService.enrollStudentInCourse(undergradStudent, "CS101");
        courseService.enrollStudentInCourse(undergradStudent, "MATH201");
        courseService.enrollStudentInCourse(gradStudent, "PHY501");
        courseService.enrollStudentInCourse(gradStudent, "CS101");

        // Add grades and demonstrate GradeCalculable interface
        System.out.println("\n=== GRADE MANAGEMENT ===");
        undergradStudent.addGrade("CS101", 85.5);
        undergradStudent.addGrade("MATH201", 92.0);
        gradStudent.addGrade("PHY501", 88.5);
        gradStudent.addGrade("CS101", 95.0);

        // Demonstrate interface with different student types
        GradeCalculable[] gradeables = {undergradStudent, gradStudent};
        for (GradeCalculable gradeable : gradeables) {
            studentService.displayGPAReport(gradeable);
            System.out.println("Grade for 85 marks: " + gradeable.getGradeLetter(85));
        }

        // Display all information
        studentService.displayAllStudents();
        courseService.displayCourseEnrollments();

        // Demonstrate abstraction and data validation
        System.out.println("\n=== DATA VALIDATION ===");
        Student invalidStudent = new Student("", "Invalid Student", "invalid-email", "", "", 0);
        studentService.addStudent(invalidStudent);

        // Demonstrate specific functionality
        System.out.println("\n=== GRADUATE STUDENT SPECIFIC ===");
        System.out.println("Research Topic: " + gradStudent.getResearchTopic());
        System.out.println("Supervisor: " + gradStudent.getSupervisor());
    }

}
