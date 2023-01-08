package pl.pjatk.EatGood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.EatGood.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
