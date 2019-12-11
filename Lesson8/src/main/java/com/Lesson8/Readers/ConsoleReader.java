package com.Lesson8.Readers;

import com.Lesson8.Format.CSVFormatterWriter;
import com.Lesson8.SortedParClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader {

    private String[] message;
    private ArrayList<SortedParClass> list=new ArrayList<>();
    private boolean isReversed = false;

    public ConsoleReader(String startMessage, String... message) {
        this.message = message;
        System.out.println(startMessage);
    }

    public ConsoleReader(boolean isReversed, ArrayList<SortedParClass> list, String startMessage, String... message) {
        this.message = message;
        this.isReversed = isReversed;
        this.list = list;
        System.out.println(startMessage);
    }

    public int readTopN(){

        System.out.println("Количество результатов для вывода. Значение должно быть больше 0");
        int topN=0;
        try {
            Scanner scanner=new Scanner(System.in);
            do {
               topN=scanner.nextInt();
            } while (topN<=0);
        } catch (Exception e) {
            System.out.println("Должно быть целое число больше 0");
        }
       return topN;
    }

    public void saveToFile(List<Object> list){
        System.out.println("Сохранить результат в файл. \nВ случае проблеммы результат будет записан в rez.csv\nFilePath:");
        String filePath="rez.csv";
        CSVFormatterWriter csv=new CSVFormatterWriter();
        try {
            Scanner scan=new Scanner(System.in);
             filePath=scan.nextLine();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        csv.fileWriteTo(list,filePath);
    }

    public ArrayList<SortedParClass> start() {
        int timer = 0;
        String str = "";
        Scanner scanner = new Scanner(System.in);
        while (!str.contains("exit")) {
            printMessage(timer);
            if (!(str = scanner.nextLine()).contains("exit")) {
                timer += addToInt(str, timer);
            }
            if (message.length==timer) break;
        }
        return list;
    }

    private void printMessage(int index) {
        System.out.println(message[index]);
    }

    private int addToInt(String s, int index) {
        String err = "Не соответствие типов. Должно быть: целое число, равное 1, или 0";
        Integer rez = null;
        try {
            rez = Integer.valueOf(s);
            if ((rez > 1) || (rez < 0)) {
                System.out.println(err);
                return 0;
            }
        } catch (NumberFormatException|NullPointerException e) {
            System.out.println(err);
            return 0;
        }
        if (isReversed) list.get(index).setIsReverse(rez);
        else list.add(new SortedParClass(rez, 0));
        return 1;
    }
}