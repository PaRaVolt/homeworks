package repository;

import model.Car;

import java.util.List;

public interface CarsRepository {
    public Object[] showCarsNOmerByColorOrMileage(List<Car> car_list, String colorToFind, Integer mileageToFind);
    public long showUniqueCarsNumberByCost(List<Car> car_list, Integer minCost, Integer MaxCost);
    public String showColorOfCarWithMinCost(List<Car> car_list);
    public Double showAverageCostOfCarModel(List<Car> car_list, String car_model);
}
