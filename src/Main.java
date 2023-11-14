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

        fibonacci(10);
        //Find value in fibonacci;
        System.out.println(fibonacciCheck(8));
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
 //Fibonaci
    static void fibonacci(int n){
        int a = 0, b = 1;

        for (int i = 1; i <  n;i++) {
                int c = a + b;
                if (isPrime(c)) {
                    System.out.println(c + " là số nguyên tố.");
                } else {
                    System.out.println(c + " không là số nguyên tố.");

            }
            a = b;
            b = c;
        }
    }
   //Xac dinh vi tri va hien thi gia tri trong day so Fibonacci
    static int fibonacciCheck(int n){
        int a = 0, b = 1 ,to = 0;
        for (int i = 0 ; i < n - 1 ; i++){
                to = a + b;
                a = b ;
                b = to;
        }
        return to;

    }

}
