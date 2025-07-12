package ad.practice.playground.solution.oop.lab_work;

public class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return  monthlySalary;
    }
    public void setMonthlySalary(double monthlySalary){
        if(monthlySalary >= 0){
            this.monthlySalary = monthlySalary;
        }
    }
    public double getMonthlySalary(){
        return monthlySalary;
    }
}
