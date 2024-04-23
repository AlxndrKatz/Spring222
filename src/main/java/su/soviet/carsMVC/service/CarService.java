package su.soviet.carsMVC.service;

import su.soviet.carsMVC.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCarsByCount(Long count);
    List<Car> getCarsSorted(String sort);
    List<Car> getCarsByCountSorted(Long count, String sort);
    List<Car> getAllCars();
    List<Car> getCars(Long count, String sort);
}
