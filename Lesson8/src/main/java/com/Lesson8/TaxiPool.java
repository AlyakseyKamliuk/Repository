package com.Lesson8;
import com.Lesson8.Comparators.*;
import com.Lesson8.Readers.ConsoleReader;

import java.util.*;

public class TaxiPool {
    private static TreeMap<Car,Car> cars=new TreeMap();
    private final String[] messages1 ={"Сортировать по классу автомобиля?","Сортировать по разгону до 100?","Сортировать по расходу?"
            ,"Сортировать по брэнду?","Сортировать по модели?"};
    private final String[] messages2 ={"Реверсировать по классу автомобиля?","Реверсировать по разгону до 100?","Реверсировать по расходу?"
            ,"Реверсировать по брэнду?","Реверсировать по модели?"};
    private final String startMessage1="Выберите критерии сортировки Автомобилей: \n 1: Учитывать данный критерий во время сортировки " +
            "\n 0: Не учитывать данный критерий во время сортировки";
    private final String startMessage2="Выберите критерии реверсии Автомобилей: \n 1: Реверсировать данный параметр " +
            "\n 0: Не учитывать данный параметр во время реверсировки";


    public TaxiPool(TreeMap<Car,Car> cars,Comparator comparator) {
        this.cars=new TreeMap<>(comparator);
        this.cars.putAll(cars);
    }

    public TaxiPool(){
    }
    public TaxiPool(Car car){
       cars.put(car,car);
    }


    public List<Object> topN(Integer n){
        List<Object> list=new ArrayList<>();
        for (Map.Entry m:cars.entrySet()) {
            if (n==0) break;
            n--;
            list.add(m.getValue());
            System.out.println(m.getValue());
        }
        return list;
    }

    private Comparator createComparator(List<SortedParClass> sortParametrs){
        ArrayList<Comparator> comparators=new ArrayList();
        comparators.add(new CoCarClass());
        comparators.add(new CoOverclockingTo100());
        comparators.add(new CoConsumption());
        comparators.add(new CoCarBrand());
        comparators.add(new CoCarModel());
        boolean comparatorIsIncialized=false;
        Comparator comparator=null;
        for (int i = 0; i < sortParametrs.size(); i++) {
            if (sortParametrs.get(i).getIsSorted()==1) {
                if (comparatorIsIncialized==false) {
                    comparator=comparators.get(i);
                    comparatorIsIncialized=true;
                }
                if (isReversed(sortParametrs.get(i)))
                comparator=comparator.thenComparing(comparators.get(i)).reversed();
                else comparator=comparator.thenComparing(comparators.get(i));
            }
        }
        return comparator;
    }

    private boolean isReversed(SortedParClass isReverse)
    {
        return (isReverse.getIsReverse()==1);
    }


    public void startGame(String filepath){
        ConsoleReader consoleReader=new ConsoleReader(true, new ConsoleReader(startMessage1, messages1).start()
                ,startMessage2, messages2);
        Comparator comparator=createComparator(consoleReader.start());
        TreeMap<Car,Car> map=new TreeMap<>(comparator);
        List<Car> carsF = new CarFormater().createListProducts(filepath);
        for (int i = 0; i < carsF.size(); i++) {
            map.put(carsF.get(i),carsF.get(i));
        }
        cars=new TreeMap<Car,Car>(comparator);
        this.cars.putAll(map);
        List<Object> list=topN(consoleReader.readTopN());
        consoleReader.saveToFile(list);
    }

    @Override
    public String toString() {
        return "TaxiPool{" +
                "cars=" + cars +
                '}';
    }
}
