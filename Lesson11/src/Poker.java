import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.*;

public class Poker {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(6);

        Runnable user=()->{
            try {
                cyclicBarrier.await();
            } catch (InterruptedException|BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Отыграл партию");
            ThreadPoolExecutor aaa;

        };


        while(true){
            new Thread(user).start();
        }
    }
}
