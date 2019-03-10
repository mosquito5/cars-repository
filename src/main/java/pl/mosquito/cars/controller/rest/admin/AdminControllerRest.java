package pl.mosquito.cars.controller.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mosquito.cars.car.repository.CarRepository;
import pl.mosquito.cars.controller.rest.RestURIConstants;
import pl.mosquito.cars.users.repoistory.UserRepository;

@RestController
@RequestMapping(value = RestURIConstants.ADMIN_API)
public class AdminControllerRest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = RestURIConstants.ADMIN_API_USER_BY_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> removeUserById(@RequestParam(value = "id", required = true) long id) {
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            System.out.println("user doesn't exist");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = RestURIConstants.ADMIN_API_REMOVE_ADV_BY_ID ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> removeAdvById(@RequestParam(value = "id", required = true) long id) {

        System.out.println(id);

        if(carRepository.findById(id).isPresent()){
            carRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            System.out.println("advertise doesn't exist");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = RestURIConstants.ADMIN_API_REMOVE_ADV_BY_USR, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> removeAdvByUsr(@RequestParam(value = "name") String name) {

        if(carRepository.findByUserName(name).isPresent()){
            carRepository.deleteByUserName(name);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            System.out.println("user doesn't exist");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}