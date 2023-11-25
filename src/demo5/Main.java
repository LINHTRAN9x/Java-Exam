package demo5;

public class Main {
    public static void main(String[] args) {
//        StudentInterface st = new StudentInterface();//interface k the gan dc vi la truu tuong.

        AptechInterface apt = new AptechInterface() {
            @Override
            public void code(String a) {

            };
        };

        //use lambda expression
        AptechInterface apt2 = (s) -> {

        };
    }
}
