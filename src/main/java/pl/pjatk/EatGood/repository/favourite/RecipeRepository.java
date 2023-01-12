package pl.pjatk.EatGood.repository.favourite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.EatGood.domain.FavouriteRecipe;

@Repository
public interface RecipeRepository extends JpaRepository<FavouriteRecipe, Integer> {

}