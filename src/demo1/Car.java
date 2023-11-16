package demo1;

public class Car {
    String color = "red";
    int year;

    Owner ownerOfCar = new Owner();

    void run(){
        System.out.println("Car is running...");
    }
    void clearCar(){
        System.out.println("Cleaning the car...");
    }

    void printColor(){
        this.clearCar();
        System.out.println("My color: " + this.color);
    }
}
