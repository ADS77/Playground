package ad.practice.playground.solution.oop.inheritance.single;

public class Handler {

   public static void main(String[]a){
       Car myCar = new Car();
       myCar.brand = "Toyota";  // Inherited from Vehicle
       myCar.start();
       myCar.displayInfo();

       Bike myBike = new Bike();
       myBike.brand = "Yamaha";  // Inherited from Vehicle
       myBike.start();
       myBike.showType();

   }
}
