package pl.mosquito.cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mosquito.cars.users.model.User;

@Controller
public class HomeController {
    @RequestMapping()
    public String home() {
        return "index";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @GetMapping("/signup")
    public String SignUp(Model model) {
        model.addAttribute("NewUserForm", new User());

        return "signup";
    }


    @GetMapping("/signin")
    public String SignIn(Model model) {
        model.addAttribute("SignInForm", new User());

        return "signin";
    }
}
