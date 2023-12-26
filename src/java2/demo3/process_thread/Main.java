package java2.demo3.process_thread;

public class Main {
    public static void main(String[] args) {
        SubT st = new SubT(); //3
        st.start(); //4

//        SubT st1 = new SubT(); //cac thread chay song song va doc lap!
//        st1.start();
        SubR sr = new SubR();
        Thread tr = new Thread(sr);
        tr.start();

        try {
            for (int i = 0; i <10; i++){
                System.out.println("main i = " + i);
                Thread.sleep(1000); //New--(start())-->running->Terminated/sleep/lock. thread hoạt động
            } ;
        }catch (Exception e){

        }
        System.out.println("Main Done!!!!!!!!!!!!!!!");
    }
}
