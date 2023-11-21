package demo3;

public class SheepDog extends Dog{
    //ke thua dog va animal
    @Override
    public void eat(){
        super.eat();//Dog
        System.out.println("SheepDog eating...");
    }
}
