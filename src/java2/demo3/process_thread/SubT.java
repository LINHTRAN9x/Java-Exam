package java2.demo3.process_thread;

public class SubT extends Thread{ //1
    @Override
    public void run() { //ham run() thuc hien thread.  //2
        try {
            for (int i = 0; i <20; i++){
                System.out.println("subT i = " + i);
                Thread.sleep(1000);
            } ;
        }catch (Exception e){

        }
    }
}
