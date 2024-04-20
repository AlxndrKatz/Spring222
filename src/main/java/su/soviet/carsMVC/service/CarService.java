package su.soviet.carsMVC.service;

import su.soviet.carsMVC.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCarsByCount(Long count);
    List<Car> getAllCars();
    List<Car> getCarsSorted(String sort);
}
