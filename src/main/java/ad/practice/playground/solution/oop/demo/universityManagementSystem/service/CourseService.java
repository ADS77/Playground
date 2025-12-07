package ad.practice.playground.solution.oop.demo.universityManagementSystem.service;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.entity.Attendance;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.entity.Course;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.entity.Student;
import ad.practice.playground.solution.oop.demo.universityManagementSystem.enums.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZoneId;
import java.util.*;
public class CourseService {
    private Map<String, Course> courses;
    private Map<String, List<String>> courseEnrollments;
    private Map<String, Map<String, Attendance>> studentAttendance;
    private static Logger logger = LoggerFactory.getLogger(CourseService.class);

    public CourseService() {
        this.courses = new HashMap<>();
        this.courseEnrollments = new HashMap<>();
        this.studentAttendance = new HashMap<>();
    }

    public void addCourse(Course course){
        courses.put(course.getCourseCode(), course);
        courseEnrollments.putIfAbsent(course.getCourseCode(), new ArrayList<>());
    }
    public void enrollStudentInCourse(Student student, String courseCode) {
        Course course = courses.get(courseCode);
        if(course == null){
            throw new IllegalArgumentException("Course not found with id : " + courseCode);
        }
        if(!course.hasAvailableSeats()){
            throw new IllegalStateException("max seats capacity exceeds");
        }
        if(! courseEnrollments.get(courseCode).contains(student.getId())){
            courseEnrollments.get(courseCode).add(student.getId());
            course.incrementEnrollment();
            student.enrollInCourse(courseCode);
            // initialize the attendance tracking
            studentAttendance.putIfAbsent(student.getId(), new HashMap<>());
            studentAttendance.get(student.getId()).put(courseCode, new Attendance(student.getId(), courseCode));
            logger.info(student.getName() + " successfully enrolled in " + courseCode);
        }
    }

    public void markAttendance(String studentId, String courseCode, Date date, boolean isPresent){
        if(studentAttendance.containsKey(studentId) && studentAttendance.get(studentId).containsKey(courseCode)){
            Attendance attendance = studentAttendance.get(studentId).get(courseCode);
            attendance.markAttendance(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), isPresent);
        }
    }

    public List<String> getStudentsInCourse(String courseCode) {
        return new ArrayList<>(courseEnrollments.getOrDefault(courseCode, new ArrayList<>()));
    }

    public void displayCourseEnrollments() {
        System.out.println("COURSE ENROLLMENTS");
        for (Map.Entry<String, List<String>> entry : courseEnrollments.entrySet()) {
            System.out.println("Course: " + entry.getKey() + " | Enrolled Students: " + entry.getValue().size());
        }
    }

    public void displayCourseStatistics() {
        System.out.println("COURSE STATISTICS");
        for (Course course : courses.values()) {
            List<String> enrolledStudents = courseEnrollments.get(course.getCourseCode());
            double enrollmentRate = (double) enrolledStudents.size() / course.getMaxCapacity() * 100;

            System.out.println("Course: " + course.getCourseCode() + " - " + course.getCourseName());
            System.out.println("  Type: " + course.getCourseType().getDescription());
            System.out.println("  Enrollment: " + enrolledStudents.size() + "/" + course.getMaxCapacity());
            System.out.println("  Enrollment Rate: " + String.format("%.1f%%", enrollmentRate));
            System.out.println("  Department: " + course.getDepartment().getFullName());
        }
    }

    public List<Course> getCoursesByDepartment(Department department) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses.values()) {
            if (course.getDepartment() == department) {
                result.add(course);
            }
        }
        return result;
    }

    public Course getCourse(String courseCode) {
        return courses.get(courseCode);
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses.values());
    }

}
