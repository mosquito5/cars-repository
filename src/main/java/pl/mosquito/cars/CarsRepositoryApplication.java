package pl.mosquito.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import pl.mosquito.cars.car.model.Car;
import pl.mosquito.cars.car.repository.CarRepository;
import pl.mosquito.cars.security.PassGen;
import pl.mosquito.cars.service.UserService;
import pl.mosquito.cars.users.model.User;
import pl.mosquito.cars.users.repoistory.UserRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication

public class CarsRepositoryApplication {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void init() {
        if(userRepository.findByUsername("Admin1").isEmpty()) {
            System.out.println("ADMIN NOT FOUND, CREATING...");
            String pass = new PassGen().getPass();
            System.out.println("Admin password: " + pass);
            String name = "admin";
            User user = new User("Admin1", pass, "admin1234@admin.com");
            userService.addWithAdminRole(user);
            System.out.println("DONE");
        }
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(CarsRepositoryApplication.class, args);

    }
}



