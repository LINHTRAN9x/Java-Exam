package demo2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Bike b = new Bike();
        b.setBrand("Honda");
        b.setYear(12);
        b.showInfo();

        int[] arr = new int[5];
        //collection:List,Set,Quewe.
        ArrayList ls = new ArrayList<>();
        ls.add(1);
        ls.add("2");

        System.out.println(ls.get(0));
        System.out.println(ls.size());

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(2);
//        intList.add("3");

        ArrayList<String> stringList = new ArrayList<>();

        ArrayList<Bike> bList = new ArrayList<>();
        bList.add(new Bike());

        Bike nbike = bList.get(0);
        System.out.println("Danh sách tất cả các đối tượng trong danh sách:");
        for (Bike bike : bList) {
            System.out.println(bike);
        }

    }
}
