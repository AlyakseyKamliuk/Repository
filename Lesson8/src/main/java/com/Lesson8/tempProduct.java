package com.Lesson8;

import java.util.ArrayList;

public class tempProduct<T extends Product> {
    T prod;


    void add(T object){

        this.prod=object;
    }

    void print(){
        System.out.println(prod);
    }

}
