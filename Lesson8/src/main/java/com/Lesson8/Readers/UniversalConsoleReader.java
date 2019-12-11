package com.Lesson8.Readers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniversalConsoleReader {

    private int index = 0;
    private int numberOfFields = 0;
    private final ArrayList listFields = new ArrayList();
    private ArrayList<String> listType = new ArrayList<>();
    private ArrayList listNameFields = new ArrayList();
    private ArrayList<RandomClass> randomClass = new ArrayList<>();

    public UniversalConsoleReader(Object o) {
        downloadFieldsClass(o);
    }

    private void downloadFieldsClass(Object clasNasme) {

        numberOfFields = clasNasme.getClass().getDeclaredFields().length;

        for (int i = 0; i < numberOfFields; i++) {
            listType.add(clasNasme.getClass().getDeclaredFields()[i].getType().toString());
            listNameFields.add(clasNasme.getClass().getDeclaredFields()[i].getName());
        }
    }


    public void consoleReader(String startMessage) {
        boolean isExit = false;
        System.out.println(startMessage);
        try(Scanner skaner = new Scanner(System.in)) {
                while (!isExit) {
                if (index == numberOfFields) return;
                message();
                String string = skaner.next();
                if (string.contains("exit")) {
                    isExit = true;
                }
                if (!isExit) {
                    testingEnter(string);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void testingEnter(String string) {
        int indexEl = index;
        if ((Integer.parseInt(string)!=0)&&(Integer.parseInt(string)!=1)) {
            System.out.println("Должно быть 1 или 0");
            return;
        }
        String cash=listType.get(indexEl);
        try {
            if (cash.contains("Character") || (cash.contains("char"))) {
                listFields.add(string.charAt(0));
            }
            if (cash.contains("Integer") || (cash.contains("int"))) {
                listFields.add(Integer.parseInt(string));
            }
            if (cash.contains("Double") || (cash.contains("double"))) {
                listFields.add(Double.parseDouble(string));
            }
            if (cash.contains("String")) {
                listFields.add(string);
            }
        } catch (
                NumberFormatException e) {
            System.out.println("Неверный тип данных! повторите попытку");
            return;
        }
        index++;
        createNewRandomClass();
    }

    private void createNewRandomClass() {
        if (index == numberOfFields) {
            randomClass.add(new RandomClass(listFields));
            listFields.clear();
        }
    }

    private void message() {
        if (index == numberOfFields) {
            index = 0;
            System.out.println("Данные внесены! Для выхода наберите Exit или продолжайте ввод");
        }
        System.out.println("" + listNameFields.get(index) + "(" + listType.get(index) + "):");
    }

    public List<RandomClass> getListsOfAlreadyFilledFields() {
        return randomClass;
    }

    public List getField(Integer index) {
        return randomClass.get(index).getFields();
    }


    public class RandomClass {
        private ArrayList fields = new ArrayList();

        private RandomClass(ArrayList listFields) {
            for (int i = 0; i < listFields.size(); i++) {
                this.fields.add(listFields.get(i));
            }
        }

        public ArrayList getFields() {
            return fields;
        }

    }

    @Override
    public String toString() {
        return "UniversalConsoleReader{" +
                "randomClass=" + randomClass +
                '}';
    }


}
