package repository;

import model.Car;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class CarsRepositoryImpl implements CarsRepository {
    public Object[] showCarsNOmerByColorOrMileage(List<Car> car_list, String colorToFind, Integer mileageToFind){
        return car_list.stream().filter(c -> c.getColor().equalsIgnoreCase(colorToFind) || c.getProbeg().equals(mileageToFind)).map(Car::getNomer).toArray();// .forEach(System.out::println);
    }
    public long showUniqueCarsNumberByCost(List<Car> car_list, Integer minCost, Integer maxCost) {
        return car_list.stream().filter(c -> c.getCost() >= minCost && c.getCost() <= maxCost).map(Car::getModel_).sorted().distinct().count();
    }
    public String showColorOfCarWithMinCost(List<Car> car_list) {
        return car_list.stream().min(Comparator.comparingInt(Car::getCost)).get().getColor();
    }
    public Double showAverageCostOfCarModel(List<Car> car_list, String car_model){
        OptionalDouble obj = OptionalDouble.of(car_list.stream().filter(c -> c.getModel_().equals(car_model)).map(Car::getCost).flatMapToInt(IntStream::of).average().orElse(0));
        return obj.getAsDouble();
    }
}
