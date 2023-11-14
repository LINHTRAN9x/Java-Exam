import java.util.Scanner;

public class FindClosePrime {
        static boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

        static int findCloserPrime(int x) {
            if ( x <= 1 ){
                return -1;
            }
            int closestPrime = 2;

            for (int i = x - 1; i > 1; i--) {
                if (isPrime(i)) {
                    closestPrime = i;
                    break;
                }
            }

            return closestPrime;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập giá trị để tìm số nguyên tố nhỏ hơn và gần nhất: ");

            int x = sc.nextInt();
            int closestPrime = findCloserPrime(x);
            System.out.println("=============*****************===============");
            if (closestPrime != -1) {
                System.out.println("Số nguyên tố nhỏ hơn và gần nhất với " + x + " là: " + closestPrime);
            } else {
                System.out.println("Không có số nguyên tố nhỏ hơn và gần nhất với " + x);
            }
            System.out.println("=============*****************===============");
        }


}
