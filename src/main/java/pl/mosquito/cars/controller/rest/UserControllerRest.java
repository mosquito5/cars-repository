package pl.mosquito.cars.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.mosquito.cars.service.UserService;
import pl.mosquito.cars.users.model.User;

@RestController
@RequestMapping(value = RestURIConstants.NEWUSER_API)
public class UserControllerRest {

    @Autowired
    private UserService userService;

    @RequestMapping(value = RestURIConstants.NEWUSER_API_ADD)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createNewUser(@RequestBody User user) {
        System.out.println(user);

        try{
            userService.addWithDefaultRole(user);

        } catch (org.springframework.dao.DataIntegrityViolationException none) {
            //temporary solution
            return "Creating new user failed\n";

        }
        return "Creating new user successful\n";
    }



}

