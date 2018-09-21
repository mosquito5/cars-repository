package pl.mosquito.cars.Car.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mosquito.cars.Car.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
}
