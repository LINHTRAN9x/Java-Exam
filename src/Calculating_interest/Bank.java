package Calculating_interest;

public class Bank {
    private double balance;
    private double rate;

    public Bank(double balance,double rate) {
        this.balance = balance;
        this.rate = rate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    public double calculateInterest(){
        return balance*(rate/1200);
    };


}
