package com.Lesson9;

import java.util.Arrays;

public class AlArrayList <T> {
    private Object[] mas = new Object[8];
    private int schetchik = 0;

    public AlArrayList(Object... parametr) {
        for (int i = 0; i < parametr.length; i++) {
            add((T) parametr[i]);
        }
    }

    void add(T value) {
        addLengthToMas();
        mas[schetchik] = value;
        schetchik++;
    }


    void delete(int index) {
        if ((index>schetchik)||(schetchik<0)){throw new IndexOutOfBoundsException();}
        int j = 0;
        Object[] tmp = new Object[mas.length];
        for (int i = 0; i < mas.length; i++) {
            if (i != index) {
                tmp[j] = mas[i];
                j++;
            }
        }
        mas = tmp;
        schetchik--;
    }

    int size() {
        return schetchik;
    }


    public T[] getMas() {
        return (T[]) mas;
    }

    @Override
    public String toString() {
        return "AlArrayList{" +
                "mas=" + Arrays.toString(mas) +
                '}';
    }


    private void addLengthToMas() {
       if (schetchik >= mas.length % 75) {
            int j = 0;
            Object[] tmp = new Object[mas.length * 2];
            for (int i = 0; i < mas.length; i++) {
                tmp[i] = mas[i];
            }
            mas = tmp;
        }
    }

}