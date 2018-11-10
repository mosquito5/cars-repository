package pl.mosquito.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mosquito.cars.car.model.Car;
import pl.mosquito.cars.car.repository.CarRepository;

import java.security.Principal;
import java.util.List;

@Controller
public class AdvertiseController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/show")
    public String showCars(Model model) {
        List<Car> Cars = carRepository.findAll();
        return "add";
    }

    @PostMapping("/save")
    public String saveCar(@ModelAttribute Car car, Principal principal) {
        car.setUserName(principal.getName());
        carRepository.save(car);
        return "redirect:/";
    }
}
