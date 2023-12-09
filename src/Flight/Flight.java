package Flight;

public class Flight {
    private int number = 0;
    private String destination;

    public Flight(){};
    public Flight(int number, String destination) {
        this.number = number;
        this.destination = destination;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void display(){
        System.out.println("Number: "+ number);
        System.out.println("Destination: "+ destination);
    };

}
