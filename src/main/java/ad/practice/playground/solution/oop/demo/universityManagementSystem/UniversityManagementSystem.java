package ad.practice.playground.solution.oop.demo.universityManagementSystem;

import ad.practice.playground.solution.oop.demo.universityManagementSystem.entity.*;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.enums.CourseType;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.enums.Department;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.interfaces.Displayable;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.interfaces.FinancialAidEligible;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.interfaces.GradeCalculable;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.interfaces.Researchable;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.service.CourseService;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.service.StudentService;

import java.util.*;

public class UniversityManagementSystem {
    public static void main(String[] args){
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();

        System.out.println("ENHANCED UNIVERSITY MANAGEMENT SYSTEM");

        Student undergradStudent = new Student("S001", "John Doe", "john@university.com",
                "123-4567", Department.COMPUTER_SCIENCE_AND_ENGINEERING, 3, 5000.0);
        Student gradStudent = new Student("S002", "Jane Smith", "jane@university.com",
                "123-4568", Department.PHYSICS, 2, 7500.0);

        Professor professor = new Professor("P001", "Dr. A.NG", "ang@university.com",
                "123-4569", "Computer Science", "Artificial Intelligence");

        studentService.addStudent(undergradStudent);
        studentService.addStudent(gradStudent);

        // Create and add courses
        Course cs101 = new Course("CS101", "Introduction to Programming",
                Department.COMPUTER_SCIENCE_AND_ENGINEERING, CourseType.LECTURE, 30, "P001");
        Course math201 = new Course("MATH201", "Advanced Calculus",
                Department.MATHEMATICS, CourseType.LECTURE, 25, "P002");
        Course phy501 = new Course("PHY501", "Quantum Mechanics",
                Department.PHYSICS, CourseType.SEMINAR, 15, "P003");

        courseService.addCourse(cs101);
        courseService.addCourse(math201);
        courseService.addCourse(phy501);

        // Demonstrate polymorphism
        System.out.println("POLYMORPHISM DEMONSTRATION");
        List<Person> people = Arrays.asList(undergradStudent, gradStudent, professor);

        for (Person person : people) {
            System.out.println("\nPerson Details:");
            person.displayInfo();
            System.out.println("Role: " + person.getRole());
        }


        System.out.println("MULTIPLE INTERFACES DEMONSTRATION");

        // Financial aid demonstration
        FinancialAidEligible[] financialAidStudents = {undergradStudent, gradStudent};
        for (FinancialAidEligible student : financialAidStudents) {
            System.out.println("Financial Aid Analysis:");
            studentService.displayFinancialAidReport(student);
            student.applyForScholarship("Academic Excellence Scholarship");
        }


        System.out.println("\nRESEARCH DEMONSTRATION");
        Researchable researcher = (Researchable) gradStudent;
        researcher.startResearch("Advanced Quantum Algorithms");
        researcher.publishPaper("Quantum Supremacy in Modern Computing");
        researcher.publishPaper("Entanglement in Multi-particle Systems");

        System.out.println("Research Papers: " + researcher.getResearchPapers());
        gradStudent.completeThesis();

        // Course enrollment features
        System.out.println("\nENHANCED COURSE MANAGEMENT");
        try {
            courseService.enrollStudentInCourse(undergradStudent, "CS101");
            courseService.enrollStudentInCourse(undergradStudent, "MATH201");
            courseService.enrollStudentInCourse(gradStudent, "PHY501");
            courseService.enrollStudentInCourse(gradStudent, "CS101");
        } catch (Exception e) {
            System.out.println("Enrollment error: " + e.getMessage());
        }

        //Grade management
        System.out.println("\nENHANCED GRADE MANAGEMENT");
        undergradStudent.addGrade("CS101", 85.5, 3);
        undergradStudent.addGrade("MATH201", 92.0, 4);
        gradStudent.addGrade("PHY501", 88.5, 3);
        gradStudent.addGrade("CS101", 95.0, 3);

        // Display comprehensive reports
        System.out.println("\nCOMPREHENSIVE REPORTS");
        studentService.displayAllStudents();
        courseService.displayCourseStatistics();
        studentService.generateDepartmentReport();
        studentService.generateGPADistribution();

        // Dean's list demonstration
        System.out.println("\n=== DEAN'S LIST STUDENTS ===");
        List<Student> deanListStudents = studentService.getDeanListStudents();
        System.out.println("Number of Dean's List students: " + deanListStudents.size());
        for (Student student : deanListStudents) {
            System.out.println(" - " + student.getName() + " (GPA: " +
                    String.format("%.2f", student.calculateGPA()) + ")");
        }

        // Department-specific operations
        System.out.println("\n DEPARTMENT-SPECIFIC OPERATIONS");
        List<Student> csStudents = studentService.getStudentsByDepartment(Department.COMPUTER_SCIENCE_AND_ENGINEERING);
        System.out.println("Computer Science Students: " + csStudents.size());

        List<Course> csCourses = courseService.getCoursesByDepartment(Department.COMPUTER_SCIENCE_AND_ENGINEERING);
        System.out.println("Computer Science Courses: " + csCourses.size());

        // Financial calculations
        System.out.println("\n FINANCIAL SUMMARY");
        for (Student student : studentService.getAllStudents()) {
            System.out.println(student.getName() + ":");
            System.out.println("  Tuition: $" + student.getTuitionFee());
            System.out.println("  Scholarship: $" + student.getScholarshipAmount());
            System.out.println("  Net Fee: $" + student.calculateTotalFees());
            System.out.println("  Total Credits: " + student.getTotalCredits());
        }

        /* Exception handling
        Exceptions are caused due to the inconsistency with the flow of program. They are very likely to occur from
        any portion of an application.So it's a golden rule to handle exceptions with great care.There are a lot of
        cases which can produce exceptions.In this case we will be finding a student by id and add invalid course that doesn't exists.
        and encounter an exception.
        */
        System.out.println("\nEXCEPTION HANDLING DEMONSTRATION");
        try {
            Student missingStudent = studentService.findStudentById("NON_EXISTENT");
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        try {
            undergradStudent.addGrade("INVALID_COURSE", 85.0, 3);
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

}
