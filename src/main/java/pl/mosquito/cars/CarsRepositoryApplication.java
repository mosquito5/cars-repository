package pl.mosquito.cars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.mosquito.cars.car.model.Car;
import pl.mosquito.cars.car.repository.CarRepository;

@SpringBootApplication
public class CarsRepositoryApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(CarsRepositoryApplication.class, args);

//        Car car = new Car(1920000, 1600, 32000, "Opel", "Vectra", "petrol");
//
//        CarRepository carRepo = ctx.getBean(CarRepository.class);
//        carRepo.save(car);
//
//        ctx.close();

    }
}
