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
    private final User currentUser;

    public FavouriteService(UserRepository userRepository, RecipeRepository recipeRepository, User currentUser) {
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
        this.currentUser = currentUser;
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

    public User saveUser() {
        User userToSave = new User();
        userToSave.setUsername(currentUser.getUsername());
        userToSave.setId(getUserIdFromUsername());
        return userRepository.save(userToSave);
    }

    public Integer getUserIdFromUsername() {
        return Integer.parseInt(currentUser.getUsername().substring(1));
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public User findUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(NotFoundUserException::new);
    }

    public User addRecipeToUser(Integer recipeId) {
        FavouriteRecipe favouriteRecipe = findFavouriteRecipeById(recipeId);
        User user = findUserById(getUserIdFromUsername());
        user.getFavouriteRecipeSet().add(favouriteRecipe);
        userRepository.save(user);
        return user;
    }

    public User removeRecipeFromUser(Integer recipeId) {
        FavouriteRecipe favouriteRecipe = findFavouriteRecipeById(recipeId);
        User user = findUserById(getUserIdFromUsername());
        user.getFavouriteRecipeSet().remove(favouriteRecipe);
        userRepository.save(user);
        return user;
    }

    public Set<FavouriteRecipe> getUserFavouriteRecipes() {
        return findUserById(getUserIdFromUsername()).getFavouriteRecipeSet();
    }

}
