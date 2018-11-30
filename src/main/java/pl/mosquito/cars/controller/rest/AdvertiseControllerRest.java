package pl.mosquito.cars.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mosquito.cars.car.model.Car;
import pl.mosquito.cars.car.repository.CarRepository;
import pl.mosquito.cars.users.repoistory.UserRepository;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = RestURIConstants.ADVERTISE_API)
public class AdvertiseControllerRest {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = RestURIConstants.ADVERTISE_API_GET_CARS)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> getCars() {
        List<Car> cars = carRepository.findAll();

        return cars;
    }

    @RequestMapping(value = RestURIConstants.ADVERTISE_API_GET_CARS_BY_MODEL)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> getCarsByModel(@RequestParam(value = "model", required = true) String model) {
        Optional<List<Car>> cars = carRepository.findByModel(model);

        if(cars.isPresent())
            return new ResponseEntity<>(cars.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(cars.get(), HttpStatus.NOT_FOUND);

    }

    @RequestMapping(value = RestURIConstants.ADVERTISE_API_GET_CARS_BY_USER_NAME)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> getCarsByUserName(@RequestParam(value = "userName", required = true) String userName) {

        Optional<List<Car>> cars = carRepository.findByUserName(userName);

        if(cars.isPresent())
            return new ResponseEntity<>(cars.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(cars.get(), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = RestURIConstants.ADVERTISE_API_GET_CARS_BY_FUEL)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> getCarsByFuel(@RequestParam(value = "fuel", required = true) String fuel) {
        Optional<List<Car>> cars = carRepository.findByFuel(fuel);

        if(cars.isPresent())
            return new ResponseEntity<>(cars.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(cars.get(), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = RestURIConstants.ADVERTISE_API_GET_CARS_BY_BRAND)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> getCarsByBrand(@RequestParam(value = "brand", required = true) String brand) {
        Optional<List<Car>> cars = carRepository.findByBrand(brand);

        if(cars.isPresent())
            return new ResponseEntity<>(cars.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(cars.get(), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = RestURIConstants.ADVERTISE_API_SAVE_CAR)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveCar(@RequestBody Car car, Principal principal) {
        car.setUserName(principal.getName());
        carRepository.save(car);
    }

}
