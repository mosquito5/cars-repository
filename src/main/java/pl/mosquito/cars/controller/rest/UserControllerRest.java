package pl.mosquito.cars.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.mosquito.cars.email.Email;
import pl.mosquito.cars.service.UserService;
import pl.mosquito.cars.users.model.User;
import pl.mosquito.cars.users.repoistory.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping(value = RestURIConstants.USER_API)
public class UserControllerRest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Email sendEmail;

    @Autowired
    private TemplateEngine templateEngine;

    @RequestMapping(value = RestURIConstants.USER_API_ADD)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNewUser(@RequestBody User user, Model model) {

        Context emailContext = new Context();
        emailContext.setVariable("header","Your account has been registered");
        emailContext.setVariable("title","Dear " + user.getUsername() +
                " your account has been registered successfully");

        System.out.println(user);

        try{
            userService.addWithDefaultRole(user);

        } catch (org.springframework.dao.DataIntegrityViolationException none) {

            return new ResponseEntity<>("Creating new user failed\n", HttpStatus.I_AM_A_TEAPOT);

        }
        String body = templateEngine.process("email/EmailTemplate", emailContext);
        sendEmail.email(user.getEmail(), body, "Your account has been registered");
        return new ResponseEntity<>("Creating new user successful\n", HttpStatus.OK);
    }

    @RequestMapping(value = RestURIConstants.USER_API_RESETPASS)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> resetPassword(@RequestParam(value = "email", required = true) String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent()) {
            String pass = userService.resetPassword(user.get());
            Context emailContext = new Context();
            emailContext.setVariable("header","Your password has been reset!");
            emailContext.setVariable("title","Dear " + user.get().getUsername() +
                    " your password has been reset, your new password: " + pass);
            String body = templateEngine.process("email/EmailTemplate", emailContext);

            sendEmail.email(user.get().getEmail(),body, "Your password has been reset!");
            return new ResponseEntity<>("Reset password success\n", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Reset password failed\n", HttpStatus.BAD_REQUEST);
    }
}

