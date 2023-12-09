package Calculating_interest;

public class Bank {
    private double balance;
    private double rate;

    public Bank(double balance,double rate) {
        this.balance = balance;
        this.rate = rate;
    }
    public double calculateInterest(){
        return balance*(rate/1200);
    };


}
