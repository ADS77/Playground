package ad.practice.playground.solution.oop.inheritance.single;

public class Car extends Vehicle{
     int wheels;
     double speed;

    void changeSpeed(int newSpeed ){
        speed = newSpeed;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Wheels: "+wheels);
        System.out.println("Speed:" + speed);
    }
}
