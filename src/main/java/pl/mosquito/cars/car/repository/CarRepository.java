package pl.mosquito.cars.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mosquito.cars.car.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
