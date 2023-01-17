package pl.pjatk.EatGood.repository.favourite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.pjatk.EatGood.domain.FavouriteRecipe;
import pl.pjatk.EatGood.domain.User;

import java.util.Set;

@Repository
public interface RecipeRepository extends JpaRepository<FavouriteRecipe, Integer> {

    @Query("select f from FavouriteRecipe f join f.userSet u where f.id = :favouriteRecipeId and u.id = :userId")
    Set<FavouriteRecipe> findFavouriteRecipeByIdAndUserId(Integer favouriteRecipeId, Integer userId);
}