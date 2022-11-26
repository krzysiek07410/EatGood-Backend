package pl.pjatk.EatGood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.EatGood.domain.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
