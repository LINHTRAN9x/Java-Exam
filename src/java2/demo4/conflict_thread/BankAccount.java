package java2.demo4.conflict_thread;

public class BankAccount {
    private int balance = 0;

    public synchronized void deposit(int amount){
        if (amount > 0) {
            balance += amount;
            System.out.println("Nap tien vao tai khoan: " + amount);
            notify(); //goi day
        }
    }

    public synchronized void withdraw(int amount){
        while (balance < amount) {
            System.out.println("So tien khong du:");
            try{
                wait(); //ngủ
//                Thread.sleep(1000);
            }catch (Exception e){

            }

        }
        if (amount > 0) {
            balance -= amount;
            System.out.println("Rut thanh cong so tien: " + amount);
        }
    }
}
