package PersonList;
import java.util.ArrayList;
import java.util.Scanner;

public class Teacher extends Person{
    private ArrayList<String> danhSachLop;
    private double mucLuong;
    private int soMonGiangDay;
    private ArrayList<String> monGiangDay;


    @Override
    public void inputInfo() {
        super.inputInfo();
        Scanner scanner = new Scanner(System.in);


        System.out.print("Nhập số lượng lớp giảng dạy: ");
        int soLuongLop = scanner.nextInt();
        scanner.nextLine();

        danhSachLop = new ArrayList<>();
        for (int i = 0; i < soLuongLop; i++) {
            System.out.print("Nhập lớp giảng dạy thứ " + (i + 1) + ": ");
            danhSachLop.add(scanner.nextLine());
        }

        System.out.print("Nhập mức lương: ");
        mucLuong = scanner.nextDouble();

        System.out.print("Nhập số môn giảng dạy: ");
        soMonGiangDay = scanner.nextInt();
        scanner.nextLine();

        monGiangDay = new ArrayList<>();
        for (int i = 0; i < soMonGiangDay; i++) {
            System.out.print("Nhập môn giảng dạy thứ " + (i + 1) + ": ");
            monGiangDay.add(scanner.nextLine());
        }
    }


    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Danh sách lớp giảng dạy: " + danhSachLop);
        System.out.println("Mức lương: " + mucLuong);
        System.out.println("Số môn giảng dạy: " + soMonGiangDay);
        System.out.println("Các môn giảng dạy: " + monGiangDay);
    }
}
