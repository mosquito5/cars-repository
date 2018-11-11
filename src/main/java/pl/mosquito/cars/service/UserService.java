package pl.mosquito.cars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.mosquito.cars.users.model.User;
import pl.mosquito.cars.users.model.UserRole;
import pl.mosquito.cars.users.repoistory.UserRepository;
import pl.mosquito.cars.users.repoistory.UserRoleRepository;

@Service
public class UserService {
    private static final String DEFAULT_ROLE = "ROLE_USER";
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void addWithDefaultRole(User user) {
        UserRole defaultUser = new UserRole(DEFAULT_ROLE);
        user.getUserRoles().add(defaultUser);
        String passwordHash = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);
        user.setSpassword(passwordHash);
        userRepository.save(user);
    }
}
