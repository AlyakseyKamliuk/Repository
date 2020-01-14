import java.util.*;
import java.util.concurrent.TimeUnit;

public class Supermarket {
    static List<String> resultList = Collections.synchronizedList(new ArrayList<>());
    static List<String> quare1 = Collections.synchronizedList(new ArrayList<>());
    static List<String> quare2 = Collections.synchronizedList(new ArrayList<>());
    static List<String> quare3 = Collections.synchronizedList(new ArrayList<>());
    static List<String> quare4 = Collections.synchronizedList(new ArrayList<>());
    static List<String> quare5 = Collections.synchronizedList(new ArrayList<>());
    static List<String> quare6 = Collections.synchronizedList(new ArrayList<>());
    static List<String> quare7 = Collections.synchronizedList(new ArrayList<>());
    static List<String> quare8 = Collections.synchronizedList(new ArrayList<>());
    static List<String> quare9 = Collections.synchronizedList(new ArrayList<>());
    static List<String> quare10= Collections.synchronizedList(new ArrayList<>());


    public static void main(String[] args) {
        for (int i = 0; i < 100_000; i++) {


            quare1.add("UserName" + i);
            quare2.add("UserName" + i);
            quare3.add("UserName" + i);
            quare4.add("UserName" + i);
            quare5.add("UserName" + i);
            quare6.add("UserName" + i);
            quare7.add("UserName" + i);
            quare8.add("UserName" + i);
            quare9.add("UserName" + i);
            quare10.add("UserName" + i);

        }

        Timer timer = new Timer();
        Cashier cashier1 = new Cashier(timer, quare1, quare2, quare3, quare4, quare5, quare6, quare7, quare8, quare9, quare10);
        Cashier cashier2 = new Cashier(timer, quare1, quare2, quare3, quare4, quare5, quare6, quare7, quare8, quare9, quare10);
        Cashier cashier3 = new Cashier(timer, quare1, quare2, quare3, quare4, quare5, quare6, quare7, quare8, quare9, quare10);
        Cashier cashier4 = new Cashier(timer, quare1, quare2, quare3, quare4, quare5, quare6, quare7, quare8, quare9, quare10);
        Cashier cashier5 = new Cashier(timer, quare1, quare2, quare3, quare4, quare5, quare6, quare7, quare8, quare9, quare10);
        Cashier cashier6 = new Cashier(timer, quare1, quare2, quare3, quare4, quare5, quare6, quare7, quare8, quare9, quare10);
        Cashier cashier7 = new Cashier(timer, quare1, quare2, quare3, quare4, quare5, quare6, quare7, quare8, quare9, quare10);
        Cashier cashier8 = new Cashier(timer, quare1, quare2, quare3, quare4, quare5, quare6, quare7, quare8, quare9, quare10);
        Cashier cashier9 = new Cashier(timer, quare1, quare2, quare3, quare4, quare5, quare6, quare7, quare8, quare9, quare10);
        Cashier cashier10 = new Cashier(timer, quare1, quare2, quare3, quare4, quare5, quare6, quare7, quare8, quare9, quare10);
        cashier1.start();
        cashier2.start();
        cashier3.start();
        cashier4.start();
        cashier5.start();
        cashier6.start();
        cashier7.start();
        cashier8.start();
        cashier9.start();
        cashier10.start();
        timer.start();

    }

    public static void sleep(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Timer extends Thread {
        private int time = 0;

        public int getTime() {
            return time;
        }

        @Override
        public void run() {
            while (resultList.size() != 1000_000) {
                try {
                    Thread.sleep(1);
                    time += 1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(time);
        }
    }

    static class Cashier extends Thread {
        private Timer timer;
        private List[] quares;

        Cashier(Timer timer, List... quares) {
            this.timer = timer;
            this.quares = quares;
        }


        @Override
        public void run() {
            int i = 0;
            String name = "";
            Random random = new Random();
            while (true) {
                i = random.nextInt(quares.length);
                if (resultList.size() == 1000_000) {
                    break;
                }
                if (quares[i].size() == 0) {
                    continue;
                }
                name = (String) quares[i].get(0);
                quares[i].remove(0);
                 System.out.println("Человек "+name+" обслужен потоком "+this.getName());
                resultList.add(name);
            }
            System.out.println("Все люди были обслужены за " + timer.getTime() + " мс");
            System.out.println(resultList.size());

        }
    }
}
