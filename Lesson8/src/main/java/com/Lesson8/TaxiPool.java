package com.Lesson8;
import com.Lesson8.Comparators.*;
import com.Lesson8.Readers.ConsoleReader;
import java.util.*;

public class TaxiPool {

    private List<Car> carsList=new LinkedList<>();
    private final String startMessage1 = "Выберите критерии сортировки Автомобилей.\nСортировать по:\n0: Классу автомобиля" +
            "\n1: Разгону до 100\n" +
            "2: Расходу\n" +
            "3: Брэнду\n" +
            "4: Модели\n" +
            "5: Добавить реверсию\n" +
            "exit: Выход";

    private List<Object> topN(Integer n) {
        List<Object> list = new ArrayList<>();
        for (int i=0; i<carsList.size(); i++) {
            if (n == 0) break;
            n--;
            list.add(carsList.get(i));
            System.out.println(carsList.get(i));
        }
        return list;
    }

    private Comparator createComparator(List<SortedPairs> sortParametrs) {
        ArrayList<Comparator> comparators=initListComparators();
        Comparator comparator = null;
        for (int i = 0; i < comparators.size(); i++) {
            if (sortParametrs.get(i).getIsSorted() == 1) {
                if (comparator == null) comparator = comparators.get(i);
                if (isReversed(sortParametrs.get(i)))
                    comparator = comparator.thenComparing(comparators.get(i)).reversed();
                else comparator = comparator.thenComparing(comparators.get(i));
            }
        }
        return comparator;
    }

    private ArrayList<Comparator> initListComparators(){
        ArrayList<Comparator> comparators = new ArrayList();
        comparators.add(new ComparatorCarClass());
        comparators.add(new ComparatorOverclockingTo100());
        comparators.add(new ComparatorConsumption());
        comparators.add(new ComparatorCarBrand());
        comparators.add(new ComparatorCarModel());
        return comparators;
    }

    private boolean isReversed(SortedPairs isReverse) {
        return (isReverse.getIsReverse() == 1);
    }

    public void startGame(String filepath) {
        ConsoleReader consoleReader = new ConsoleReader(startMessage1);
        carsList = new CarFormater().createListProducts(filepath);
        carsList.sort(createComparator(consoleReader.start()));
        List<Object> list = topN(consoleReader.readTopN());
        consoleReader.saveToFile(list);
    }

    @Override
    public String toString() {
        return "TaxiPool{" +
                "carsList=" + carsList +
                '}';
    }
}
