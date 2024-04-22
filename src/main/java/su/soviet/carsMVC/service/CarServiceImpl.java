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

    public CarServiceImpl() {
    }

    @Override
    public List<Car> getCars(Long count, String sort) {
        if (count != null && sort != null) {
            List<Car> cars = repo.findAll(Sort.by(Sort.Direction.ASC, sort));
            return cars.subList(0, Math.toIntExact(count));
        }
        if (count == null && sort != null) {
            return repo.findAll(Sort.by(Sort.Direction.ASC, sort));
        }
        if (count != null && sort == null) {
            if (count < 0 || count == 0 || count > maxCars) {
                return repo.findAll();
            }
            return repo.findAll().subList(0, Math.toIntExact(count));
        }  if (count == null && sort == null) {
            return repo.findAll();
        }
        return null;
    }
}
