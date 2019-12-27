package lesson8;
import lesson8.Comparators.*;
import lesson8.Search.Search;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TaxiPool {

    public TaxiPool(){
        carsList=new CreateCars().createListProducts("file.csv");
    }

    public TaxiPool(String filename){
        carsList=new CreateCars().createListProducts(filename);
    }

    private boolean isReversed=false;
    private List<Car> carsList=new LinkedList<>();
    private ArrayList<Car> tmpList=new ArrayList<>();


    private Comparator createComparator(List<Integer> sortParametrs) {
        ArrayList<Comparator> comparators=initListComparators();
        Comparator comparator = null;
        for (int i = 0; i < comparators.size(); i++) {
            if (sortParametrs.get(i) == 1) {
                if (comparator == null) comparator = comparators.get(i);
                else comparator = comparator.thenComparing(comparators.get(i));
            }
        }
        if (isReversed) return comparator.reversed();
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

    private void isReversed() {
        isReversed=true;
    }


    public void saveFile(String filePath, String saveString){
        if (filePath==null) filePath="testA.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))){
            if (saveString != null) {
                writer.write(saveString+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Car> sort(List<Integer> sortedParameter){
        Comparator comparator=createComparator(sortedParameter);
        if (tmpList.size()==0) {
            tmpList=new ArrayList<>(carsList);
        }
        if (comparator!=null){
        Collections.sort(tmpList,comparator);}
        return tmpList;
    }

    public void reset(){
        tmpList.clear();
    }

    public List<Car> search(Character carClass, String brand, String carModel,
                       Double fromOverclockingTo100, Double toOverclockingTo100,
                       Double fromConsumption, Double toConsumption){
        if (tmpList.size()==0) {
                tmpList=new Search((ArrayList<Car>) carsList).search(carClass,brand, carModel,
                fromOverclockingTo100, toOverclockingTo100,
                fromConsumption, toConsumption);
        } else tmpList=new Search(tmpList).search(carClass,brand, carModel,
                fromOverclockingTo100, toOverclockingTo100,
                fromConsumption, toConsumption);
        return tmpList;
    }
    @Override
    public String toString() {
        return "TaxiPool{" +
                "carsList=" + carsList +
                '}';
    }
}
