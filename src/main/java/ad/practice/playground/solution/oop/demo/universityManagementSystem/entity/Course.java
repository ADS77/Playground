package ad.practice.playground.solution.oop.demo.universityManagementSystem.entity;

import ad.practice.playground.solution.oop.demo.universityManagementSystem.enums.CourseType;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.enums.Department;

public class Course {
    private String courseCode;
    private String courseName;
    private Department department;
    private CourseType courseType;
    private int maxCapacity;
    private int currentEnrollment;
    private String instructorId;

    public Course(String courseCode, String courseName, Department department,
                  CourseType courseType, int maxCapacity, String instructorId) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
        this.maxCapacity = maxCapacity;
        this.currentEnrollment = 0;
        this.instructorId = instructorId;
    }

    public boolean hasAvailableSeats() {
        return currentEnrollment < maxCapacity;
    }

    public void incrementEnrollment() {
        if (hasAvailableSeats()) {
            currentEnrollment++;
        }
    }

    public void decrementEnrollment() {
        if (currentEnrollment > 0) {
            currentEnrollment--;
        }
    }
    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public Department getDepartment() { return department; }
    public CourseType getCourseType() { return courseType; }
    public int getMaxCapacity() { return maxCapacity; }
    public int getCurrentEnrollment() { return currentEnrollment; }
    public String getInstructorId() { return instructorId; }
}
