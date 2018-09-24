package pl.mosquito.cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mosquito.cars.users.model.User;

@Controller
public class SignUpController {


    @PostMapping("/SignUp")
    public String newUser(@ModelAttribute User user) {
        System.out.println(user.getEmail());


        /*System.out.println(password);
        System.out.println(cpassword);
        System.out.println(email);*/

        return "redirect:/";
    }
}
