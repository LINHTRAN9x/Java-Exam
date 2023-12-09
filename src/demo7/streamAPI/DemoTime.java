package demo7.streamAPI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class DemoTime {
    public static void main(String[] args){
        LocalDate ld = LocalDate.now(); // today
        System.out.println(ld);
        LocalDate ld2 = ld.plusDays(10);
        System.out.println(ld2);
        LocalDate ld3 = ld.plusMonths(1);
        System.out.println(ld3);
        LocalDate ld4 = ld.minusDays(40);
        System.out.println(ld4);
        System.out.println(ld.getMonth());
        System.out.println(ld.getMonthValue());
        System.out.println(ld.getDayOfYear());
        System.out.println(ld.getDayOfWeek());

        // 2023-12-10
//        LocalDate hsd = LocalDate.of(2023,12,10);
        LocalDate hsd = LocalDate.parse("2023-12-10");
        LocalDate new_hsd = hsd.plusMonths(1);
        System.out.println(new_hsd);

        LocalDateTime lt = LocalDateTime.now();
        System.out.println(lt);
        LocalDateTime lt2 = lt.plusHours(1);
        LocalDateTime lt3 = lt.plusMinutes(1);
        LocalDateTime lt4 = lt.plusSeconds(1);

        // 2023-12-10T11:30:00
        LocalDateTime old = LocalDateTime.of(2023,12,10,11,30,0,0);
        LocalDateTime old2 = LocalDateTime.parse("2023-12-10T11:30:00");
        System.out.println(old2);
        // nhập vào 1 ngày nào đó -> kiểm tra xem nó có phải
        // ngày của năm nhuận hay không

        boolean flag = false;
        do{
            flag = false;
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("NHap ngay sinh:");
                String s = sc.nextLine();
                LocalDate dob = LocalDate.parse(s);
                int year = dob.getYear();
                if (year % 4 == 0)
                    System.out.println("Day la nam nhuan");
                else
                    System.out.println("Day khong phai nam nhuan");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                flag = true;
            }
        }while (flag);
    }
}