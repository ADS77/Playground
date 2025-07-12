package ad.practice.playground.solution.oop.lab_work;

public class PartTimeEmployee extends Employee{
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, int hoursWorked,double hourlyRate, int id) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    public double getHourlyRate(){
        return hourlyRate;
    }
    public void setHourlyRate(double rate){
        if(rate >= 0){
            this.hourlyRate = rate;
        }
    }
    public int getHoursWorked(){
        return hoursWorked;
    }
    public void  setHoursWorked(int hoursWorked){
        if(hoursWorked >= 0) {
            this.hoursWorked = hoursWorked;
        }
    }
}
