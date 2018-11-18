package pl.mosquito.cars.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mosquito.cars.email.Email;
import pl.mosquito.cars.service.UserService;
import pl.mosquito.cars.users.model.User;

@RestController
@RequestMapping(value = RestURIConstants.NEWUSER_API)
public class UserControllerRest {

    @Autowired
    private UserService userService;

    @Autowired
    private Email sendEmail;

    @RequestMapping(value = RestURIConstants.NEWUSER_API_ADD)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        System.out.println(user);

        try{
            userService.addWithDefaultRole(user);

        } catch (org.springframework.dao.DataIntegrityViolationException none) {
            //temporary solution
            return new ResponseEntity<>("Creating new user failed\n", HttpStatus.I_AM_A_TEAPOT);

        }
        sendEmail.regEmail(user.getEmail());
        return new ResponseEntity<>("Creating new user successful\n", HttpStatus.OK);
    }



}

