package su.soviet.carsMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import su.soviet.carsMVC.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM Car " +
            "ORDER BY " +
            "CASE WHEN :sort = 'id' THEN Car.id END ASC, " +
            "CASE WHEN :sort = 'manufacturer' THEN Car.manufacturer END ASC, " +
            "CASE WHEN :sort = 'model' THEN Car.model END ASC, " +
            "CASE WHEN :sort = 'power' THEN Car.power END DESC " +
            "LIMIT :count")
    List<Car> getCars(@Param("count") Long count, @Param("sort") String sort);
}
