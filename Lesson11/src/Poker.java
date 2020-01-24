import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

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
        };

        while(true){
            new Thread(user).start();
        }
    }
}
