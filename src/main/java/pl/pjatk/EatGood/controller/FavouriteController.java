package pl.pjatk.EatGood.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.EatGood.domain.FavouriteRecipe;
import pl.pjatk.EatGood.domain.User;
import pl.pjatk.EatGood.service.FavouriteService;

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

    @PostMapping("/recipe/findorsave")
    public ResponseEntity<FavouriteRecipe> getFavouriteRecipeByIdOrSaveFavouriteRecipe (@RequestBody FavouriteRecipe
                                                                                                    favouriteRecipe) {
        return ResponseEntity.ok(favouriteService.findFavouriteRecipeByIdOrSaveFavouriteRecipe(favouriteRecipe));
    }

    @GetMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestHeader(name = "Username") String username) {
        return ResponseEntity.ok(favouriteService.saveUser(username));
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

    @GetMapping("/user/findorsave")
    public ResponseEntity<User> getUserByUsernameOrSaveUser(@RequestHeader(name = "Username") String username) {
        return ResponseEntity.ok(favouriteService.findUserByUsernameOrSaveUser(username));
    }

    @GetMapping("/user/addrecipe")
    public ResponseEntity<User> addRecipeToUser(@RequestParam Integer recipeId,
                                                @RequestHeader(name = "Username") String username) {
        return ResponseEntity.ok(favouriteService.addRecipeToUser(recipeId, username));
    }

    @GetMapping("/user/removerecipe")
    public ResponseEntity<User> removeRecipeFromUser(@RequestParam Integer recipeId,
                                                     @RequestHeader(name = "Username") String username) {
        return ResponseEntity.ok(favouriteService.removeRecipeFromUser(recipeId, username));
    }

    @GetMapping("/user/getrecipes")
    public ResponseEntity<Set<FavouriteRecipe>> getUserFavouriteRecipes(@RequestHeader(name = "Username")
                                                                            String username) {
        return ResponseEntity.ok(favouriteService.getUserFavouriteRecipes(username));
    }

    @GetMapping("/user/getrecipe")
    public ResponseEntity<Set<FavouriteRecipe>> getUserFavouriteRecipe(@RequestParam Integer recipeId,
                                                                       @RequestHeader(name = "Username")
                                                                        String username) {
        return ResponseEntity.ok(favouriteService.getUserFavouriteRecipeById(recipeId, username));
    }

    @GetMapping("/user/isfavouriterecipe")
    public ResponseEntity<Boolean> isFavouriteRecipeUserFavourite(@RequestParam Integer recipeId,
                                                                  @RequestHeader(name = "Username") String username) {
        return ResponseEntity.ok(favouriteService.isFavouriteRecipeUserFavourite(recipeId, username));
    }

}
