package ad.practice.playground.solution.oop.demo.universityManagementSystem.interfaces;

import java.util.List;

public interface Researchable {
    void startResearch(String topic);
    void publishPaper(String paperTitle);
    List<String> getResearchPapers();
}
