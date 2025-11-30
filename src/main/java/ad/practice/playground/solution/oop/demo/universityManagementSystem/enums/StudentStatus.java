package ad.practice.playground.solution.oop.demo.universityManagementSystem.enums;

public enum StudentStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    EVENING("Evening"),
    DAY("Day"),
    DAY_TO_EVENING("Day to Evening"),
    GRADUATED("Graduated"),
    SUSPENDED("Suspended");

    private final String status;

    StudentStatus(String status) {
        this.status = status;
    }

    public String getStatus() { return status; }
}
