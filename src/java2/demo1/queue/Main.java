package java2.demo1.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args){
        ArrayList<String>  arrayList = new ArrayList<>();

        HashSet<String> hs = new HashSet<>(); //HashSet ,set dam bao value la unique
        hs.add("Hello");
        hs.add("World");
        hs.add("Hello");
        System.out.println(hs.size());

        PriorityQueue<String> pq = new PriorityQueue<>(); //ProorityQueue ,mảng duyệt qua và sắp xếp các giá trị theo alpha
        pq.add("BB");
        pq.add("CC");
        pq.add("AA");
        pq.add("BA");
        pq.add("AC");

        System.out.println("PQ size:"+pq.size());
        while (pq.size() > 0){
//            pq.peek(); // lấy thằng đầu danh sách chứ ko bỏ đi
            String s = pq.poll(); // lấy thằng đầu danh sách ra và bỏ đi
            System.out.println(s);
        }
        System.out.println(pq.size());
        /////////////////////////////
        PriorityQueue<Person> pqp = new PriorityQueue<>((o1,o2) -> o1.getName().compareTo(o2.getName()) );
        pqp.add(new Person("Nam",18));
        pqp.add(new Person("An",19));
        pqp.add(new Person("Huy",17));

        while (pqp.size() > 0 ){
            Person p = pqp.poll();
            System.out.println(p.getName());
        }
        ////////////////////////
        HashMap<String,String> hm = new HashMap<>();//map dung theo cap key,value..(k thuoc collection tap hop,k dung dc add() ma dung put())
        hm.put("name","Tuan Anh");
        hm.put("address","So 8 Ton That Thuyet");

        System.out.println(hm.get("name"));
        System.out.println(hm.get("address"));

        HashMap<Integer,Person> hp = new HashMap<>();
        hp.put(4,new Person("Nam",20));

        HashMap<String,ArrayList<Person>> hsp = new HashMap<>();
        hsp.put("hsg" , new ArrayList<>());
        hsp.get("hsg").add(new Person("Nguyen",25));
        /////////////////////////////

    }

}
