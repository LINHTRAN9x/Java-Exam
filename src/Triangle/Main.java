package Triangle;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] agrs){
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập chiều dài cạnh a: ");
        int canhA = scan.nextInt();

        System.out.print("Nhập chiều dài cạnh b: ");
        int canhB = scan.nextInt();

        System.out.print("Nhập chiều dài cạnh c: ");
        int canhC = scan.nextInt();
        //////////////////////////////
            TamGiac i = new TamGiac(canhA,canhB,canhC);
            if (i.isTriangle()){
            System.out.println("Chu vi của hình tam giác là: " + i.perimeter());
            System.out.println("Diện tích của hình tam giác là: " + i.area());
            }else {
                System.out.println("Chiều dài của ba cạnh không thể tạo được một tam giác.");
            }


    }
}
