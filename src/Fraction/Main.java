package Fraction;

public class Main {
    public static void main(String[] agrs){
        Fraction fraction = new Fraction(3,4);


        System.out.println("Phân số ban đầu:");
        fraction.inFraction();

        System.out.println("Nhập phân số mới:");
        fraction.inputFraction();

        System.out.println("Phân số sau khi nhập:");
        fraction.inFraction();

        System.out.println("Phân số sau khi rút gọn:");
        fraction.rutGonFraction();
        fraction.inFraction();

        System.out.println("Phân số sau khi nghịch đảo:");
        fraction.nghichDaoFraction();
        fraction.inFraction();

        // Nhập phân số thứ nhất
        System.out.print("phân số thứ nhất:");
        Fraction fraction1 = new Fraction(1, 2);
        fraction1.inFraction();


        // Nhập phân số thứ hai
        System.out.print("phân số thứ hai:");
        Fraction fraction2 = new Fraction(3, 4);
        fraction2.inFraction();


        // Thực hiện các phép toán
        Fraction sum = fraction1.add(fraction2);
        Fraction sub = fraction1.sub(fraction2);
        Fraction mul = fraction1.mul(fraction2);
        Fraction div = fraction1.div(fraction2);

        System.out.print("Sum = ");
        sum.inFraction();
        System.out.print("Sub = ");
        sub.inFraction();
        System.out.print("Mul = ");
        mul.inFraction();
        System.out.print("Div = ");
        div.inFraction();



    }
}
