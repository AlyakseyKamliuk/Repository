package com.Lesson8.Readers;
import com.Lesson8.Format.CSVFormatterWriter;
import com.Lesson8.SortedPairs;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader {

    private String[] message;
    private ArrayList<SortedPairs> list = new ArrayList<>();
    private int index = 0;

    public ConsoleReader(String startMessage, String... message) {
        this.message = message;
        System.out.println(startMessage);
        for (int i = 0; i < 6; i++) {
            list.add(new SortedPairs());
        }

    }

    public int readTopN() {

        System.out.println("Количество результатов для вывода. Значение должно быть больше 0");
        int topN = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            do {
                topN = scanner.nextInt();
            } while (topN <= 0);
        } catch (Exception e) {
            System.out.println("Должно быть целое число больше 0");
        }
        return topN;
    }

    public void saveToFile(List<Object> list) {
        System.out.println("Сохранить результат в файл. \nВ случае проблеммы результат будет записан в rez.csv\nFilePath:");
        String filePath = "rez.csv";
        CSVFormatterWriter csv = new CSVFormatterWriter();
        try {
            Scanner scan = new Scanner(System.in);
            filePath = scan.nextLine();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        csv.fileWriteTo(list, filePath);
    }

    public ArrayList<SortedPairs> start() {
        String str = "";
        Scanner scanner = new Scanner(System.in);
        while (!str.contains("exit")) {
            if (!(str = scanner.nextLine()).contains("exit")) {
                parseInt(str);
            }
        }
        return list;
    }

    private void printMessage(int index) {
        if ((index > 0) && (index <= message.length)) {
            System.out.println(message[index]);
        }
    }

    private int parseInt(String s) {
        String err = "Не соответствие типов. Должно быть: целое число, от 0 до 5";
        Integer rez = null;
        try {
            rez = Integer.valueOf(s);
            if ((rez > 5) || (rez < 0)) {
                System.out.println(err);
                return 0;
            }
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println(err);
            return 0;
        }
         addToListSortedParameter(rez);
        return 1;
    }

    private void addToListSortedParameter(int sortedParameter){
        if (sortedParameter != 5) {
            index = sortedParameter;
            list.get(index).setIsSorted(1);
        } else {
            list.get(index).setIsReverse(1);
        }
    }
}