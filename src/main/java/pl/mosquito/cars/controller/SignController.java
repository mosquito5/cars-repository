package pl.mosquito.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mosquito.cars.service.UserService;
import pl.mosquito.cars.users.model.User;
import pl.mosquito.cars.users.repoistory.UserRepository;

@Controller
public class SignController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public String signUp(@ModelAttribute User user) {
        try{
            userService.addWithDefaultRole(user);

        } catch (org.springframework.dao.DataIntegrityViolationException none) {
            //temporary solution
            return "redirect:/signup";
        }
        return "redirect:/";
    }
}
