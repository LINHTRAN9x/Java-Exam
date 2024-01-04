package java2.demo4.conflict_thread;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount b = new BankAccount();
        Scanner scan = new Scanner(System.in);
        //Luong nap tien
        new Thread(() -> {
        for (int i = 0;i < 10; i++){
            System.out.println("So tien muon nap: ");
            b.deposit(200);
            try {
                Thread.sleep(1000);
            }catch (Exception e) {

            }
        }
        }).start();

        //Luong rut tien
        new Thread(() -> {
           b.withdraw(1000);
        }).start();

    };
    public static void main2(String[] args) {
        Counter c = new Counter();
        Runnable r = () -> {
            try{
                for(int i = 0; i < 10; i++){

//                    synchronized (c) {  //co che dong bo hoa object
                        c.increment();
                        c.print();
//                    }

                    Thread.sleep(1000);
                }
            }catch (Exception e){

            }
        };

        new Thread(r).start();
        new Thread(r).start();

        //Z
        new Thread(() -> {
            try{
                for(int i = 0; i < 10; i++){


                        c.incrementZ();
                        c.printZ();


                    Thread.sleep(1000);
                }
            }catch (Exception e) {

            }
        }).start();

    }
}
