package pl.mosquito.cars.users.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mosquito.cars.users.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // User findByUserName(String username);
}
