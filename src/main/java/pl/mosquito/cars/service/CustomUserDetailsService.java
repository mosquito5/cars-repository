package pl.mosquito.cars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.mosquito.cars.users.CustomUserDetails;
import pl.mosquito.cars.users.model.User;
import pl.mosquito.cars.users.repoistory.UserRepository;

import java.util.Objects;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(Objects.isNull(user))
            throw new UsernameNotFoundException(username);

        return new CustomUserDetails(user);
    }

}
