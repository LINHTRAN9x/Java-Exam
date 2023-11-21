package demo3;

public class Main {
    public static void main(String[] args){
        Animal a = new Animal();
        a.eat();
//        a.drink(); can not call
        Dog d = new Dog();
        d.eat();
        d.run();
        d.yearOld = 3;
        d.drink();

    }
}
