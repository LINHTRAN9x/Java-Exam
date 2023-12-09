package StudentsManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> studentList  = new ArrayList<>();
        studentList.add(new Student(1, "John Doe", "2000-01-15", "123 Main St", 3.5));
        studentList.add(new Student(2, "Peter Park", "2000-01-10", "123 Main St", 3.5));
        studentList.add(new Student(3, "Micle Hark", "1999-01-15", "123 Main St", 3.5));
        /////////////////////////////////////////
        Scanner scan = new Scanner(System.in);

        int input;
       try {
        do {
            System.out.println("Menu:");
            System.out.println("1.Add student");
            System.out.println("2.Edit student");
            System.out.println("3.Delete student");
            System.out.println("4.Sort student by gpa.");
            System.out.println("5.Sort student by name.");
            System.out.println("6.Show list student");
            System.out.println("0.Exit");
            System.out.print("Enter your choice: ");

            input = scan.nextInt();

            switch (input) {
                case 1: {
                    System.out.println("Add new student.");
                    Student newStudent = addStudent(studentList);
                    studentList.add(newStudent);
                    break;
                }
                case 2:
                    editStudent(studentList);
                    break;
                case 3:
                    deleteStudent(studentList);
                    break;
                case 4:
                    sortByGpa(studentList);
                    break;
                case 5:
                    sortByName(studentList);
                    break;
                case 6: {
                    for (Student s : studentList) {
                        s.displayInfo();
                    }
                    break;
                }
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        } while (input != 0);}catch (Exception e){
            System.out.println("ERORR!!!!We will out program now.");
        scan.close();}
    }


    private static Student addStudent(ArrayList<Student> studentList){
        Scanner scan = new Scanner(System.in);
        int id;
        while (true) {
            System.out.print("Enter ID: ");
            id = scan.nextInt();
            if (isUniqueId(id, studentList)) {
                break;
            } else {
                System.out.println("ID must be unique. Try again.");
            }
        }

        System.out.println("Enter name: ");
        String name = scan.next();
        System.out.println("Enter date of birth: ");
        String dateOfBirth = scan.next();
        System.out.println("Enter address: ");
        String address = scan.next();
        System.out.println("Enter GPA: ");
        double gpa = scan.nextDouble();

        return new Student(id,name,dateOfBirth,address,gpa);
    }
    private static boolean isUniqueId(int id, ArrayList<Student> studentList) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return false;
            }
        }
        return true;
    }
    private static void editStudent(ArrayList<Student> studentList) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the student to edit: ");
        int studentId = scanner.nextInt();

        for (Student student : studentList) {
            if (student.getId() == studentId) {
                System.out.println("Updating student information...");
                Scanner scan = new Scanner(System.in);
                System.out.println("Rename: ");
                String name = scan.nextLine();
                student.setName(name);
                System.out.println("ReDateOfBirth: ");
                String dob = scan.nextLine();
                student.setDateOfBirth(dob);
                System.out.println("ReAddress: ");
                String address = scan.nextLine();
                student.setAddress(address);
                System.out.println("Student information updated.");
                return;
            }
        }

        System.out.println("Student not found with ID: " + studentId);
    }
    private static void deleteStudent(ArrayList<Student> studentList) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the student to delete: ");
        int studentId = scanner.nextInt();
        for (Student student : studentList) {
            if (student.getId() == studentId) {
                studentList.remove(student);
                System.out.println("Student with ID " + studentId + " deleted.");
                return;
            }System.out.println("Student not found with ID: " + studentId);
        }

    }
    public static void sortByName(ArrayList<Student> studentList) {
        Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
        Collections.sort(studentList, nameComparator);
        System.out.println("Students sorted by name.");
    }
    public static void sortByGpa(ArrayList<Student> studentList){
        Comparator<Student> comp = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getGpa(), o2.getGpa());
            }
        };
        Collections.sort(studentList,comp);
        System.out.println("Sort completed!");
    }
}

