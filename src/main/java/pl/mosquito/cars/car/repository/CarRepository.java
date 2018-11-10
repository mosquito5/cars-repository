package pl.mosquito.cars.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mosquito.cars.car.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String brand);
    List<Car> findByModel(String model);
    List<Car> findByUserName(String user);
    List<Car> findByFuel(String fuel);
}
