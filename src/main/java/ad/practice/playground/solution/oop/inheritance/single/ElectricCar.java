package ad.practice.playground.solution.oop.inheritance.single;

public class ElectricCar extends Car{
    double batteryCapacity;

    void charge(){
        System.out.println("Charging... Battery at " + batteryCapacity + " kWh.");
    }

}
