package ad.practice.playground.solution.oop.lab_work;

public abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public abstract double calculateSalary();
    public void displayInfo(){
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Monthly Salary: " + String.format("%.2f", calculateSalary()));
        System.out.println("Employee Type: " + this.getClass().getSimpleName());
        System.out.println("-".repeat(40));
    }
}
