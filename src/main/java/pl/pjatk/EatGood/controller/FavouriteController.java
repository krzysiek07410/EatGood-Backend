package pl.pjatk.EatGood.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.EatGood.domain.FavouriteRecipe;
import pl.pjatk.EatGood.domain.User;
import pl.pjatk.EatGood.service.FavouriteService;

import java.security.Principal;
import java.util.Set;

@RestController
@RequestMapping("/api/favourite")
public class FavouriteController {

    private final FavouriteService favouriteService;

    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @PostMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test");
    }

    @PostMapping("/recipe/save")
    public ResponseEntity<FavouriteRecipe> saveFavouriteRecipe(@RequestBody FavouriteRecipe favouriteRecipeToSave) {
        return ResponseEntity.ok(favouriteService.saveFavouriteRecipe(favouriteRecipeToSave));
    }

    @GetMapping("/recipe/delete")
    public ResponseEntity<Void> deleteFavouriteRecipe(@RequestParam Integer id) {
        favouriteService.deleteFavouriteRecipe(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/recipe/find")
    public ResponseEntity<FavouriteRecipe> getFavouriteRecipeById(@RequestParam Integer id) {
        return ResponseEntity.ok(favouriteService.findFavouriteRecipeById(id));
    }

    @GetMapping("/user/save")
    public ResponseEntity<User> saveUser() {
        return ResponseEntity.ok(favouriteService.saveUser());
    }

    @GetMapping("/user/delete")
    public ResponseEntity<Void> deleteUser(@RequestParam Integer id) {
        favouriteService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/find")
    public ResponseEntity<User> getUserById(@RequestParam Integer id) {
        return ResponseEntity.ok(favouriteService.findUserById(id));
    }

    @GetMapping("/user/addrecipe")
    public ResponseEntity<User> addRecipeToUser(@RequestParam Integer recipeId) {
        return ResponseEntity.ok(favouriteService.addRecipeToUser(recipeId));
    }

    @GetMapping("/user/removerecipe")
    public ResponseEntity<User> removeRecipeFromUser(@RequestParam Integer recipeId) {
        return ResponseEntity.ok(favouriteService.removeRecipeFromUser(recipeId));
    }

    @GetMapping("/user/getrecipes")
    public ResponseEntity<Set<FavouriteRecipe>> getUserFavouriteRecipes() {
        return ResponseEntity.ok(favouriteService.getUserFavouriteRecipes());
    }
}
