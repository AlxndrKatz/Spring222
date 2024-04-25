package su.soviet.carsMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import su.soviet.carsMVC.model.Car;
import su.soviet.carsMVC.repository.CarRepository;

import java.util.List;

@Service
@PropertySource("application.yml")
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository repo;
    @Value("${maxCars}")
    private Long maxCars;

    @Override
    public List<Car> getCars(Long count, String sort) {
        return repo.getCars(count, sort);
    }
}

