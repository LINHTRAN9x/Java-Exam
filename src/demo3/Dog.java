package demo3;

public class Dog extends Animal{

    private String name;

    public Dog(){

    }

    public Dog(String kind, int yearOld, String name) {
        super(kind, yearOld);
        this.name = name;
    }

    public void drink(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void eat(){
        super.eat(); //this
        System.out.println("Dog eating...");
    }
}
