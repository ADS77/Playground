package ad.practice.playground.solution.oop.demo.universityManagementSystem.entity;

public class GraduateStudent extends Student{
    private String researchTopic;
    private String supervisor;

    public GraduateStudent(String id, String name, String email, String phone,
                           String department, int semester,
                           String researchTopic, String supervisor) {
        super(id, name, email, phone, department, semester);
        this.researchTopic = researchTopic;
        this.supervisor = supervisor;
    }

    @Override
    public String getRole() {
        return "Graduate Student";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Research Topic: " + researchTopic);
        System.out.println("Supervisor: " + supervisor);
    }

    @Override
    public String getDetails() {
        return String.format("GraduateStudent[ID=%s, Name=%s, Research=%s]",
                getId(), getName(), researchTopic);
    }

    public String getResearchTopic() { return researchTopic; }
    public void setResearchTopic(String researchTopic) { this.researchTopic = researchTopic; }

    public String getSupervisor() { return supervisor; }
    public void setSupervisor(String supervisor) { this.supervisor = supervisor; }
}
