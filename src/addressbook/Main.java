package addressbook;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.addContact("Trung","0984782642");
        addressBook.addContact("Nam","0985647111");
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add new contact");
            System.out.println("2. Find a contact by name");
            System.out.println("3. Display contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scan.nextLine();
                    System.out.println("Save this address?");
                    break;
                case 2:
                    System.out.print("Enter Name to find: ");
                    String findName = scan.nextLine();
                    addressBook.findContact(findName);
                    break;
                case 3:
                    addressBook.displayContacts();
                    break;
                case 4:
                    System.out.println("Exiting⟳⟳⟳Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter again.");
            }
        }
    }
}
