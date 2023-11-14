import javafx.scene.control.TableColumn;
import sun.awt.geom.AreaOp;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        int x = 10;
        float y = (float)3.142;
        double z = 15.15;
        char ch = 'h';
        boolean t = true;
        String s = "Hello world!";
        String[] myString = {"1","2","3"};
        System.out.println(s + z);


        if (x > 5){
            System.out.println("A");
        } else if(x >= 10){
            System.out.println("B");
        }
        else if(x > 15){
        System.out.println("c");
        }else{
        System.out.println("d");
        }

        switch (x){
            case 0:
            case 10:
                System.out.println("E");
            default:
                System.out.println("G");
        }

        sayHello("everybody");
        //scan
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap gia tri can kiem tra: " );
        int number = sc.nextInt();

        if (isPrime(number)) {
            System.out.println(number + " là số nguyên tố.");
        } else {
            System.out.println(number + " không là số nguyên tố.");
        }
    }
    //function
    static void sayHello(String msg){
        System.out.println("Hello wrold!" + msg);
    }

        // Hàm kiểm tra số nguyên tố
        static boolean isPrime(int n) {
            if (n <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }





}
