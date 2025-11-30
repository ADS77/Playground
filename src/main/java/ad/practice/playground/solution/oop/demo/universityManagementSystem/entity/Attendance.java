package ad.practice.playground.solution.oop.demo.universityManagementSystem.entity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Attendance {
    private String studentId;
    private String courseCode;
    private Map<LocalDate, Boolean> attendanceRecords;

    public Attendance(String studentId, String courseCode) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.attendanceRecords = new HashMap<>();
    }

    public void markAttendance(LocalDate date, boolean present) {
        attendanceRecords.put(date, present);
    }

    public double calculateAttendancePercentage() {
        if (attendanceRecords.isEmpty()) return 0.0;
        int presentDays = 0;
        int total = 0;
        for (Boolean present : attendanceRecords.values()) {
            if (present != null && present) {
                presentDays++;
            }
            total++;
        }
        return (presentDays * 100.0) / total;
    }

    public int getTotalPresentDays() {
        int count = 0;
        for (Boolean present : attendanceRecords.values()) {
            if (present != null && present) {
                count++;
            }
        }
        return count;
    }

    public int getTotalAbsentDays() {
        int count = 0;
        for (Boolean present : attendanceRecords.values()) {
            if (present == null || !present) {
                count++;
            }
        }
        return count;
    }

    public String getStudentId() { return studentId; }
    public String getCourseCode() { return courseCode; }
    public Map<LocalDate, Boolean> getAttendanceRecords() {
        return new HashMap<>(attendanceRecords);
    }

}
