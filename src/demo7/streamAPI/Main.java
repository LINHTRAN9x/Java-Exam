package demo7.streamAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args){
        Tree tr = new Tree(1);
        tr.grownUp();
        tr.die();

        tr.grownUp().die();

        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(3);
        ints.add(1);
        ints.add(2);
        ints.add(4);
        ints.add(0);

        ints.stream()
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer >=0;
                    }
                })
                .sorted(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return 0;
                    }
                })
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println("i ="+integer);
                    }
                });// ket thuc

        ints.stream().filter(i->i>=0).sorted((i1,i2)->i1-i2).forEach(i-> System.out.println("i="+i));

        System.out.println("Old array list:");
        ArrayList<Integer> ints2 = new ArrayList<>();
        ints2.addAll(ints);
        for (int i: ints2){
//            System.out.println("i="+i);
            if(i<2)
                ints2.remove(i);
        }
        Collections.sort(ints2,(i1,i2)->i1-i2);
        for (int i: ints2){
            System.out.println("i="+i);
        }
    }
}