package lesson8.Search;

import lesson8.Car;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Search {
    private ArrayList<Car> cars;

    public Search(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> search(Character carClass, String brand, String carModel,
                                 Double fromOverclockingTo100, Double toOverclockingTo100,
                                 Double fromConsumption, Double toConsumption) {
        ArrayList<Car> result = searchCarClass(cars, carClass);
        result = searchForBrand(result, brand);
        result = searchForModel(result, carModel);
        result = searchForConsumption(result, fromConsumption, toConsumption);
        result = searchForOverclockingTo100(result, fromOverclockingTo100, toOverclockingTo100);
        return result;
    }


    private ArrayList<Car> searchCarClass(ArrayList<Car> listCar, Character carClass) {
        if (carClass == null) return listCar;
        return (ArrayList<Car>) cars.stream()
                .filter((p) -> p.getCarClass() == carClass)
                .collect(Collectors.toList());
    }

    private ArrayList<Car> searchForBrand(ArrayList<Car> listCar, String brand) {
        if (brand==null) return listCar;
        return (ArrayList<Car>) listCar.stream().filter((p) -> p.getCarBrand().contains(brand))
                .collect(Collectors.toList());
    }

    private ArrayList<Car> searchForModel(ArrayList<Car> listCar, String carModel) {
        if (carModel==null) return listCar;
        return (ArrayList<Car>) cars.stream()
                .filter((p) -> p.getCarModel().contains(carModel))
                .collect(Collectors.toList());
    }

    private ArrayList<Car> searchForOverclockingTo100(ArrayList<Car> listCar, Double fromOverclockingTo100, Double toOverclockingTo100) {
        if ((fromOverclockingTo100 == null) || (toOverclockingTo100 == null)) return listCar;
        return (ArrayList<Car>) cars.stream()
                .filter((p) -> ((p.getOverclockingTo100() >= fromOverclockingTo100)
                        && (p.getOverclockingTo100() <= toOverclockingTo100)))
                .collect(Collectors.toList());
    }

    private ArrayList<Car> searchForConsumption(ArrayList<Car> listCar, Double fromConsumption, Double toConsumption) {
        if ((fromConsumption == null) || (toConsumption == null)) return listCar;

        return (ArrayList<Car>) listCar.stream().filter((p) -> p.getConsumption() >= fromConsumption &&
                p.getConsumption() <= toConsumption)
                .collect(Collectors.toList());
    }


}
