package DanhBa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Thử nghiệm các phương thức
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.insertPhone("John Doe","123456789");
        phoneBook.insertPhone("Jane Doe","987654321");
        phoneBook.insertPhone("John Doe","555555555");
        phoneBook.insertPhone("ha yen","855555555");
        phoneBook.insertPhone("ha yen","0000002222");
        phoneBook.insertPhone("ha yen","034343002222");
        phoneBook.insertPhone("ha yen","034343002222");
//        phoneBook.insertPhone("ha yen", "855555555");
        phoneBook.removePhone("Jane Doe");
//        phoneBook.removePhone("ha yen");
        phoneBook.searchPhone("ha yen");
        phoneBook.updatePhone("ha yen","855555555","0336980961");
        phoneBook.sort();
        phoneBook.printPhoneList();
    }
}
