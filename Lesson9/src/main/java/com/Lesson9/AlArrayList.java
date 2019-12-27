package com.Lesson9;

import java.util.Arrays;

public class AlArrayList <T> {
    private Object[] elements = new Object[8];
    private int enumerator = 0;
    public AlArrayList(Object... parametr) {
        for (int i = 0; i < parametr.length; i++) {
            add((T) parametr[i]);
        }
    }

    void add(T value) {
        addLengthToElements();
        elements[enumerator] = value;
        enumerator++;
    }


    void delete(int index) {
        if ((index> enumerator)||(enumerator <0)){throw new IndexOutOfBoundsException();}
        int j = 0;
        Object[] tmp = new Object[elements.length];
        enumerator--;
        System.arraycopy(elements,0,tmp,0,index);
        System.arraycopy(elements,index+1,tmp,index,(elements.length-(index+1)));
        elements = tmp;
    }

    int size() {
        return enumerator;
    }


   public T get(int i) {
        if (i<enumerator){
        return (T) elements[i];} else throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        return "AlArrayList{" +
                "mas=" + Arrays.toString(elements) +
                '}';
    }


    private void addLengthToElements() {
       if (enumerator >= elements.length*0.75) {
            int j = 0;
            Object[] tmp = new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                tmp[i] = elements[i];
            }
            elements = tmp;
        }
    }

}