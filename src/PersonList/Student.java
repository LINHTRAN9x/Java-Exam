package PersonList;

import java.util.Scanner;

public class Student extends Person{
    int studentID;
    int testScore;
    String email;

    @Override
    public void inputInfo(){
        super.inputInfo();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter studentID: ");
        this.studentID = scan.nextInt();
        System.out.println("Enter test score: ");
        this.testScore = scan.nextInt();
        System.out.println("Enter email: ");
        this.email = scan.next();

    }

    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("(StudentID:"+studentID+") (TestScore:"+testScore+") Email: "+email);
    }
    public boolean checkScore(){
        if (testScore > 8){
            return true;
        }return false;
    }
}
