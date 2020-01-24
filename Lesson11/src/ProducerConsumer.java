import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;


public class ProducerConsumer {

    static LinkedList<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        Collections.synchronizedCollection(queue);

        Runnable myConsumer=()->{
                        while (true) {
                        if (queue.size()==0) continue;
                        System.out.println("Take " + queue.getLast());
                    }
        };
        Runnable myProducer=()->{
            while (true) {
                System.out.println("Add");
                queue.addFirst("String");
            }
        };

        Thread consumer=new Thread(myConsumer);
        Thread producer=new Thread(myProducer);
        consumer.setDaemon(true);
        producer.setDaemon(true);
        consumer.start();
        producer.start();
        sleep(3);
    }



    public static void sleep(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}