import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.regex.Matcher;


public class Supermarket {
    public static volatile int COUNTER_OF_COMPLETED_PROCESSES = 0;
    public static final int COUNTER_PROCESSES = 10;
    
    static ArrayList<String> resultList = new ArrayList<>();
    final ArrayList<String> resultList1 = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        int countPeople=0;
        ArrayList<ConcurrentLinkedQueue<String>> queues = new ArrayList<>();
        for (int i = 0; i < COUNTER_PROCESSES; i++) {
            queues.add(new ConcurrentLinkedQueue<>());
            for (int j = 0; j < 100_000; j++) {
                queues.get(i).add("UserName " + (j + 1));
                countPeople++;

            }
        }
        long time = System.currentTimeMillis();
        ArrayList<Thread> cashiers = new ArrayList<>();
        for (int i = 0; i < COUNTER_PROCESSES; i++) {
            cashiers.add(new Cashier(queues,countPeople));
            cashiers.get(i).start();
        }

       for (int i = 0; i < COUNTER_PROCESSES; i++) {
                cashiers.get(i).join();
        }

        long time2 = System.currentTimeMillis();
        System.out.println("На обработку потребовалось " + (time2 - time) + "мс");
        System.out.println(COUNTER_OF_COMPLETED_PROCESSES);


    }

    static class Cashier extends Thread {
        private ArrayList<ConcurrentLinkedQueue<String>> quares;
        private int countPeople = 0;

        Cashier(ArrayList<ConcurrentLinkedQueue<String>> quares, int countPeople) {
            this.quares = quares;
            this.countPeople=countPeople;
        }

        @Override
        public void run() {
            int i = 0;
            String name = "";
            while (COUNTER_OF_COMPLETED_PROCESSES < countPeople) {
                i = ThreadLocalRandom.current().nextInt(quares.size());
                    name = quares.get(i).poll();

                if (name != null) {
                    synchronized (resultList) {
                        System.out.println("Человек " + name + " обслужен потоком " + this.getName());
                        resultList.add(name);
                        COUNTER_OF_COMPLETED_PROCESSES++;
                    }
                }
            }
        }
    }
}

