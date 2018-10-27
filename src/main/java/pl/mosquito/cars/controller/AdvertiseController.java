package pl.mosquito.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mosquito.cars.car.model.Car;
import pl.mosquito.cars.car.repository.CarRepository;
import pl.mosquito.cars.users.model.User;
import pl.mosquito.cars.users.repoistory.UserRepository;

import java.security.Principal;
import java.util.List;

@Controller
public class AdvertiseController {

    private CarRepository carRepository;
    private UserRepository userRepository;


    @Autowired
    public AdvertiseController(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/show")
    public String showCars(Model model) {
        List<Car> Cars = carRepository.findAll();
        return "add";
    }

    @PostMapping("/save")
    public String saveCar(@ModelAttribute Car car, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        car.setUserName(user.getUsername());
        carRepository.save(car);
        userRepository.save(user);
        return "redirect:/";
    }
}
