package demo4.abstractClass;

public class Male extends Person {
    @Override
    public void run(){
        System.out.println("Male run....");
    };

    @Override
    public void eat() {
        System.out.println("Male eating......");
    }

    public void love(){};
}
