package demo1;
import demo2.Bike;

public class Main {
    public static void main(String[] args){
        Car c = new Car();
        Car c1 = new Car();
        System.out.println(c.color);
        System.out.println(c1.color);

        System.out.println(c.ownerOfCar.name);

        //call func
        c.run();

        //update
        c.color = "orange";
        c1.color = "green";
        System.out.println(c.color);
        System.out.println(c1.color);
        ///////////////
        c.printColor();
        c1.printColor();
        ////////////////
        //Use package another location;
        Bike b = new Bike();
        //truyen props cho bien private.
        b.setBrand("Yamaha");

    }
}
