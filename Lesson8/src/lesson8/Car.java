package lesson8;

import java.util.Objects;

public class Car {
    private Character carClass;
    private Double overclockingTo100;
    private Double consumption;
    private String carBrand;
    private String carModel;

    public Car(char carClass, double overclockingTo100, double consumption, String carBrand, String carModel) {
        this.carClass = carClass;
        this.overclockingTo100 = overclockingTo100;
        this.consumption = consumption;
        this.carBrand = carBrand;
        this.carModel = carModel;
    }

    public Car() {
    }

    public Character getCarClass() {
        return carClass;
    }

    public Double getOverclockingTo100() {
        return overclockingTo100;
    }

    public Double getConsumption() {
        return consumption;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carClass == car.carClass &&
                Double.compare(car.overclockingTo100, overclockingTo100) == 0 &&
                Double.compare(car.consumption, consumption) == 0 &&
                Objects.equals(carBrand, car.carBrand) &&
                Objects.equals(carModel, car.carModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carClass, overclockingTo100, consumption, carBrand, carModel);
    }


    public int compareTo(Object o) {
        Car car = (Car) o;

        int rez = this.carClass.compareTo(car.carClass) * -1;
        if (rez == 0) rez += this.overclockingTo100.compareTo(car.overclockingTo100);
        if (rez == 0) rez += this.consumption.compareTo(car.consumption);
        if (rez == 0) rez += this.carBrand.compareTo(car.carBrand);
        if (rez == 0) rez += this.carModel.compareTo(car.carModel);
        if (rez == 0) {
            Integer a = this.hashCode();
            Integer b = o.hashCode();
            rez = a.compareTo(b);
        }
        return rez;
    }



    @Override
    public String toString() {
        return "Car{" +
                "carClass=" + carClass +
                ", overclockingTo100=" + overclockingTo100 +
                ", consumption=" + consumption +
                ", carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                '}';
    }



}
