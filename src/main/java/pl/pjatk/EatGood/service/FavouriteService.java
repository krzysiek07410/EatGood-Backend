package pl.pjatk.EatGood.service;

import org.springframework.stereotype.Service;
import pl.pjatk.EatGood.domain.FavouriteRecipe;
import pl.pjatk.EatGood.domain.User;
import pl.pjatk.EatGood.exceptionshandlers.NotFoundFavouriteRecipeException;
import pl.pjatk.EatGood.exceptionshandlers.NotFoundUserException;
import pl.pjatk.EatGood.repository.favourite.RecipeRepository;
import pl.pjatk.EatGood.repository.favourite.UserRepository;

import java.util.Set;

@Service
public class FavouriteService {
    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;

    public FavouriteService(UserRepository userRepository, RecipeRepository recipeRepository) {
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
    }

    public FavouriteRecipe saveFavouriteRecipe (FavouriteRecipe favouriteRecipeToSave) {
        return recipeRepository.save(favouriteRecipeToSave);
    }

    public void deleteFavouriteRecipe(Integer id) {
        recipeRepository.deleteById(id);
    }

    public FavouriteRecipe findFavouriteRecipeById(Integer id) {
        return recipeRepository.findById(id)
                .orElseThrow(NotFoundFavouriteRecipeException::new);
    }

    public User saveUser(String username) {
        User userToSave = new User();
        userToSave.setUsername(username);
        userToSave.setId(getUserIdFromUsername(username));
        return userRepository.save(userToSave);
    }

    public Integer getUserIdFromUsername(String username) {
        return Integer.parseInt(username.substring(1));
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public User findUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(NotFoundUserException::new);
    }

    public User addRecipeToUser(Integer recipeId, String username) {
        FavouriteRecipe favouriteRecipe = findFavouriteRecipeById(recipeId);
        User user = findUserById(getUserIdFromUsername(username));
        user.getFavouriteRecipeSet().add(favouriteRecipe);
        userRepository.save(user);
        return user;
    }

    public User removeRecipeFromUser(Integer recipeId, String username) {
        FavouriteRecipe favouriteRecipe = findFavouriteRecipeById(recipeId);
        User user = findUserById(getUserIdFromUsername(username));
        user.getFavouriteRecipeSet().remove(favouriteRecipe);
        userRepository.save(user);
        return user;
    }

    public Set<FavouriteRecipe> getUserFavouriteRecipes(String username) {
        return findUserById(getUserIdFromUsername(username)).getFavouriteRecipeSet();
    }

}
