package pl.pjatk.EatGood.repository.favourite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.EatGood.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    Integer findIdByUsername(String username);
//    Optional<User> findUserByUsername(String username);
}
