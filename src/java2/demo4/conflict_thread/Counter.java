package java2.demo4.conflict_thread;

public class Counter {
    private int x = 0;
    private int y = 0;
    private int z = 0;


    public synchronized void increment(){ //synchronized khoa o phuong thuc(cach nay duoc su dung nhieu hon).
        x++;
        y++;
    }

    public synchronized void print() {
        System.out.println("x = "+ x);
        System.out.println("y = "+ y);
    }

    public synchronized void incrementZ() {
        z++;
    }
    public synchronized void printZ() {
        System.out.println("z = "+ z);

    }
}
