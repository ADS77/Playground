package ad.practice.playground.solution.oop.demo.universityManagementSystem.service;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.entity.Student;

import java.util.*;
public class CourseService {
    private Map<String, List<String>> courseEnrollments;

    public CourseService() {
        this.courseEnrollments = new HashMap<>();
    }
    public void enrollStudentInCourse(Student student, String courseCode) {
        courseEnrollments.putIfAbsent(courseCode, new ArrayList<>());

        if (!courseEnrollments.get(courseCode).contains(student.getId())) {
            courseEnrollments.get(courseCode).add(student.getId());
            student.enrollInCourse(courseCode);
        }
    }
    public List<String> getStudentsInCourse(String courseCode) {
        return new ArrayList<>(courseEnrollments.getOrDefault(courseCode, new ArrayList<>()));
    }

    public void displayCourseEnrollments() {
        System.out.println("\n=== COURSE ENROLLMENTS ===");
        for (Map.Entry<String, List<String>> entry : courseEnrollments.entrySet()) {
            System.out.println("Course: " + entry.getKey() + " | Enrolled Students: " + entry.getValue().size());
        }
    }
}
