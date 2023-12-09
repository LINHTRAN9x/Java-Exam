package Flight;

public class Flight {
    private int number;
    private String destination;

    public Flight(){
        this.number = 0;
        this.destination = "";
    };
    public Flight(int number, String destination) {
        if (number > 0) {
            this.number = number;
            this.destination = destination;
        } else {
            this.number = 0;
            this.destination = "";
        }
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
