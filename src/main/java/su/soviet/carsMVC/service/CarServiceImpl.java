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
@PropertySource("application.yml")
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository repo;
    @Value("${maxCars}")
    private Long maxCars;

    @Override
    public List<Car> getCars(Long count, String sort) {
        List<Car> cars;
        if (count != null && sort != null) {
            return getCarsByCountSorted(count, sort);
        }
        if (count != null) {
            return getCarsByCount(count);
        }
        if (sort != null) {
            return getCarsSorted(sort);
        }
        else {
            cars = getAllCars();
        }
        return cars;
    }

    @Override
    public List<Car> getCarsByCount(Long count) {
        if (count < 0 || count == 0 || count > maxCars) {
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
        return repo.findAll(Sort.by(Sort.Direction.ASC, sort));
    }

    @Override
    public List<Car> getCarsByCountSorted(Long count, String sort) {
        if (count < 0 || count == 0 || count > maxCars) {
            count = maxCars;
        }
        return repo.findAll(Sort.by(Sort.Direction.ASC, sort))
                .subList(0, Math.toIntExact(count));
    }
}

