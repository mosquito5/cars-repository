package pl.mosquito.cars.Users.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mosquito.cars.Users.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
