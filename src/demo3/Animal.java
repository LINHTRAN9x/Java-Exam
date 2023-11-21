package demo3;

public class Animal {
    private String kind;
    int yearOld;

    public Animal(){

    }
    public Animal(String kind, int yearOld) {
        this.kind = kind;
        this.yearOld = yearOld;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void eat(){
        System.out.println("Eating...");
        System.out.println("Eating...");
        System.out.println("Eating...");

    }
    public void run(){}
}
