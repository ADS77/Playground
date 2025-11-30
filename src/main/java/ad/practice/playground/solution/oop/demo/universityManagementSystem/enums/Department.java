package ad.practice.playground.solution.oop.demo.universityManagementSystem.enums;

public enum Department {
    COMPUTER_SCIENCE_AND_ENGINEERING("CSE", "Computer Science & Engineering"),
    ELECTRICAL_AND_ELECTRONICS_ENGINEERING("EEE", "Electrical & Electronics Engineering"),
    MECHANICAL_ENGINEERING("ME", "Mechanical Engineering"),
    CIVIL_ENGINEERING("CE", "Civil Engineering"),
    PHYSICS("PHY", "Physics"),
    MATHEMATICS("MATH", "Mathematics"),
    BUSINESS("BUS", "Business Administration");

    private final String code;
    private final String fullName;

    Department(String code, String fullName) {
        this.code = code;
        this.fullName = fullName;
    }

    public String getCode() { return code; }
    public String getFullName() { return fullName; }
}
