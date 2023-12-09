package demo4.abstractClass;

public class Main {
    public static void main(String[] args){
//        Person p = new Person();//Khong the tao obj tu asstract class.
        Person p = new Person() { //Anonymous class:
            @Override
            public void run() {
                System.out.println("Male run...");
            }

            @Override
            public void eat() {
                System.out.println("Eating....");
            }
        };
        Male m = new Male();
        Person p2 = (Person) m;//up casting
//        p2.love();
        Male m2 = (Male) p;//down casting
        m2.love();
    }
}
