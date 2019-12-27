package lesson8.Comparators;

import lesson8.Car;

import java.util.Comparator;

public class ComparatorCarBrand implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int rez;
        Car car1 = (Car) o1;
        Car car2 = (Car) o2;
        String tmp = car1.getCarBrand();
        rez = tmp.compareTo(car2.getCarBrand());
        return rez;
    }
}
