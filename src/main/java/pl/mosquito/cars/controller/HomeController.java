package pl.mosquito.cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/Add")
    public String add() {
        return "add";
    }
}
