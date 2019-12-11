package com.Lesson8.Comparators;

import com.Lesson8.Car;

import java.util.Collections;
import java.util.Comparator;

public class CoCarModel implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int rez;
        Car car1 = (Car) o1;
        Car car2 = (Car) o2;
        String tmp = car1.getCarModel();
        rez = tmp.compareTo(car2.getCarModel());
        return rez;
    }

    @Override
    public Comparator reversed() {
        return Collections.reverseOrder(this);
    }
}
