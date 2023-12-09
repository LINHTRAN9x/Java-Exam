package Project_Java1.Calculating_interest;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        double rate = 10;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter balance: ");
        double balance = scan.nextDouble();
        Bank interest = new Bank(balance,rate);

        DecimalFormat df = new DecimalFormat("#.##");
        String formattedInterest = df.format(interest.calculateInterest());
        System.out.println("You interest monthly payment is: $"+ formattedInterest);
    }
}
