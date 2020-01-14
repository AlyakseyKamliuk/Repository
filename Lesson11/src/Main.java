import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {


        FiveSecondTimer fiveSecondTimer=new FiveSecondTimer();
        fiveSecondTimer.setDaemon(true);
        fiveSecondTimer.start();

        sleep(11);



    }

    public static void sleep(int second){
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class FiveSecondTimer extends Thread{
        @Override
        public void run() {
           while (true){
              Main.sleep(5);
               System.out.println("Прошло 5 секунд");
           }
        }

    }

}


