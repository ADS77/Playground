package ad.practice.playground.solution.oop.demo.universityManagementSystem.enums;

public enum CourseType {
    LECTURE("Lecture", 3),
    LAB("Laboratory", 2),
    SEMINAR("Seminar", 2),
    WORKSHOP("Workshop", 1),
    THESIS("Thesis", 6);

    private final String description;
    private final int credits;

    CourseType(String description, int credits) {
        this.description = description;
        this.credits = credits;
    }

    public String getDescription() { return description; }
    public int getCredits() { return credits; }
}
