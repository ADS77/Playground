package ad.practice.playground.solution.oop.inheritance.single;

public class Vehicle {
     public String brand;
     public int year;

    void start(){
        System.out.println("Vehicle started");
    }
    void stop(){
        System.out.println("Vehicle stopped");
    }
    void displayInfo(){
        System.out.println("Brand: " + brand);
        System.out.println("Year: "+ year);
    }
}

