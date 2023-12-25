package java2.demo2.generic;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Exam<Integer> e = new Exam<>("LBEP",7);

        Exam<Double> e1 = new Exam<>("JP 1",4.5);

        ArrayList<String> arr = new ArrayList<>();
        ArrayList<Integer> irr = new ArrayList<>();

        e.display(5,6);
        e.display("ABC","XYZ");
        e.display(5,"XYZ");
        e.display(4.5,6.2);
    }
}
