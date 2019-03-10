package pl.mosquito.cars.controller.rest.advertise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mosquito.cars.car.model.Car;
import pl.mosquito.cars.car.repository.CarRepository;
import pl.mosquito.cars.controller.rest.RestURIConstants;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = RestURIConstants.ADVERTISE_API)
public class AdvertiseControllerRest {

    @Autowired
    private CarRepository carRepository;


    @GetMapping(value = RestURIConstants.ADVERTISE_API_GET_CARS, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> getCars() {
        List<Car> cars = carRepository.findAll();

        return cars;
    }

    @GetMapping(value = RestURIConstants.ADVERTISE_API_GET_CARS_BY_MODEL, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCarsByModel(@RequestParam(value = "model", required = true) String model) {
        Optional<List<Car>> cars = carRepository.findByModel(model);

        if(cars.isPresent())
            return new ResponseEntity<>(cars.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(cars.get(), HttpStatus.NOT_FOUND);

    }

    @GetMapping(value = RestURIConstants.ADVERTISE_API_GET_CARS_BY_USER_NAME, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCarsByUserName(@RequestParam(value = "userName", required = true) String userName) {

        Optional<List<Car>> cars = carRepository.findByUserName(userName);

        if(cars.isPresent())
            return new ResponseEntity<>(cars.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(cars.get(), HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = RestURIConstants.ADVERTISE_API_GET_CARS_BY_FUEL, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCarsByFuel(@RequestParam(value = "fuel", required = true) String fuel) {
        Optional<List<Car>> cars = carRepository.findByFuel(fuel);

        if(cars.isPresent())
            return new ResponseEntity<>(cars.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(cars.get(), HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = RestURIConstants.ADVERTISE_API_GET_CARS_BY_BRAND, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCarsByBrand(@RequestParam(value = "brand", required = true) String brand) {
        Optional<List<Car>> cars = carRepository.findByBrand(brand);

        if(cars.isPresent())
            return new ResponseEntity<>(cars.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(cars.get(), HttpStatus.NOT_FOUND);
    }

    //car save
    @PostMapping(value = RestURIConstants.ADVERTISE_API_SAVE_CAR, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveCar(@RequestBody Optional<Car> car, Principal principal) {
        if(car.isPresent()) {
            car.get().setUserName(principal.getName());
            carRepository.save(car.get());

            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
