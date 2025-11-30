package ad.practice.playground.solution.oop.demo.universityManagementSystem.interfaces;

public interface Enrollable {
    void enrollInCourse(String courseCode);
    void dropCourse(String courseCode);
    boolean isEnrolledInCourse(String courseCode);
}
