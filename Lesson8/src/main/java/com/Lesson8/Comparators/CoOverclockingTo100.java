package com.Lesson8.Comparators;

import com.Lesson8.Car;

import java.util.Collections;
import java.util.Comparator;

public class CoOverclockingTo100 implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int rez;
        Car car1 = (Car) o1;
        Car car2 = (Car) o2;
        Double tmp = car1.getOverclockingTo100();
        rez = tmp.compareTo(car2.getOverclockingTo100());
        return rez;
    }

    @Override
    public Comparator reversed() {
        return Collections.reverseOrder(this);
    }
}
