package demo6.try_catch;

public class Main {
    public static void main(String[] args) {
        try{    //xu ly ngoai le              //1 try nhung co the co nhieu catch.
            int x = 10;
            int y = 0;
            System.out.println("x : y = ");
            if (y < 5){
                throw new ArithmeticException("Khong duoc chia be hon 5!"); //throw :Chủ động phát ra ngoại lệ.
            }
            int z = x/y;
            System.out.println(z);
            demo();
        }catch(ArithmeticException e) {  //catch cu the chi tiet hon,arithmetic...
            System.out.println("Error: Arithmetic");
        }
        catch (Exception e){   //catch chung. //reflection
            System.out.println("Error : "+ e.getMessage());
        }finally {//co the co hoac khong.
            //luc nao cung chay qua finally.

        }

    }

    public static void demo() throws Exception{ //co kha nang ham nay se co sự cố,nhưng nó không đặt try-catch,
             // kiểu tôi có ngoại lệ nhưng tôi k muốn xử lý try catch trong hàm mà đẩy việc xử lý cho hàm khác.
        System.out.println("demo Exception");   //neu duoc goi thi phai dat ham này trong try catch
        int a = 2;
        int b = 0;
        System.out.println(a/b);
    }
}
