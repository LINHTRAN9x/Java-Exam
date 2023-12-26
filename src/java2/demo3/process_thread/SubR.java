package java2.demo3.process_thread;

public class SubR implements Runnable{
    @Override
    public void run() {
        try {
            for (int i = 0; i <20; i++){
                System.out.println("subR i = " + i);
                Thread.sleep(1000);
            } ;
        }catch (Exception e){

        }
    }
}
