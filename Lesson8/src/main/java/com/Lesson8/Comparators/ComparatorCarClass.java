package com.Lesson8.Comparators;

import com.Lesson8.Car;

import java.util.Collections;
import java.util.Comparator;

public class ComparatorCarClass implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int rez;
        Car car1 = (Car) o1;
        Car car2 = (Car) o2;
        Character tmp = car1.getCarClass();
        rez = tmp.compareTo(car2.getCarClass()) * -1;
        return rez;
    }


}
