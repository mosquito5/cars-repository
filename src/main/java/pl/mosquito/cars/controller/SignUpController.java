package pl.mosquito.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mosquito.cars.users.model.User;
import pl.mosquito.cars.users.repoistory.UserRepository;

@Controller
public class SignUpController {

    public UserRepository userRepo;

    @Autowired
    public SignUpController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/signup")
    public String newUser(@ModelAttribute User user) {
            userRepo.save(user);
        return "redirect:/";
    }
}
