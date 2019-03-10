package pl.mosquito.cars.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mosquito.cars.car.model.Car;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
  Optional<List<Car>> findByBrand(String brand);
  Optional<List<Car>> findByModel(String model);
  Optional<List<Car>> findByUserName(String userName);
  Optional<List<Car>> findByFuel(String fuel);
  Optional<List<Car>> deleteByUserName(String userName);
}
