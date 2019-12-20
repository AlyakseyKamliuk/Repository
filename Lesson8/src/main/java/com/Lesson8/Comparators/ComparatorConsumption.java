package com.Lesson8.Comparators;

import com.Lesson8.Car;

import java.util.Collections;
import java.util.Comparator;

public class ComparatorConsumption implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        int rez;
        Car car1 = (Car) o1;
        Car car2 = (Car) o2;
        Double tmp = car1.getConsumption();
        rez = tmp.compareTo(car2.getConsumption());
        return rez;
    }


}
