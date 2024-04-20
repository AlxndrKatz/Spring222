package su.soviet.carsMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import su.soviet.carsMVC.model.Car;
import su.soviet.carsMVC.repository.CarRepository;

import java.util.List;

@Service
@PropertySource("car.properties")
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository repo;
    @Value("${max.cars}")//
    private Long maxCars;

    public CarServiceImpl() {
    }

    public CarServiceImpl(CarRepository repo, Long maxCars) {//
        this.maxCars = maxCars;
        this.repo = repo;
    }

    @Override
    public List<Car> getCarsByCount(Long count) {
        if (count < 0 || count > maxCars) {
            count = maxCars;
        }
        return repo.findAll().subList(0, Math.toIntExact(count));
    }

    @Override
    public List<Car> getAllCars() {
        return repo.findAll();
    }

    @Override
    public List<Car> getCarsSorted(String sort) {
        return null;
    }
}
