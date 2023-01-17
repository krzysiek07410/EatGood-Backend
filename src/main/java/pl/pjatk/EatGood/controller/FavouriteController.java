package pl.pjatk.EatGood.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.EatGood.domain.FavouriteRecipe;
import pl.pjatk.EatGood.domain.User;
import pl.pjatk.EatGood.service.FavouriteService;

import java.util.Set;

@Api(value = "Favourite Controller", description = "Operations related to favorite recipes and users")
@RestController
@RequestMapping("/api/favourite")
public class FavouriteController {

    private final FavouriteService favouriteService;

    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @PostMapping("/test")
    @ApiOperation(
            value = "Test endpoint",
            notes = "Test endpoint",
            response = String.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Bad request", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = String.class)
    })
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test");
    }

    @PostMapping("/recipe/save")
    @ApiOperation(
            value = "Save favourite recipe",
            notes = "Save favourite recipe to user",
            response = FavouriteRecipe.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = FavouriteRecipe.class),
            @ApiResponse(code = 400, message = "Bad request", response = FavouriteRecipe.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = FavouriteRecipe.class)
    })
    public ResponseEntity<FavouriteRecipe> saveFavouriteRecipe(@RequestBody FavouriteRecipe favouriteRecipeToSave) {
        return ResponseEntity.ok(favouriteService.saveFavouriteRecipe(favouriteRecipeToSave));
    }

    @GetMapping("/recipe/delete")
    @ApiOperation(
            value = "Delete favourite recipe",
            notes = "Delete favourite recipe from user",
            response = void.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = void.class),
            @ApiResponse(code = 400, message = "Bad request", response = void.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = void.class)
    })
    public ResponseEntity<Void> deleteFavouriteRecipe(@RequestParam Integer id) {
        favouriteService.deleteFavouriteRecipe(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/recipe/find")
    @ApiOperation(
            value = "Get favourite recipe",
            notes = "Get favourite recipe by id",
            response = FavouriteRecipe.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = FavouriteRecipe.class),
            @ApiResponse(code = 400, message = "Bad request", response = FavouriteRecipe.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = FavouriteRecipe.class)
    })
    public ResponseEntity<FavouriteRecipe> getFavouriteRecipeById(@RequestParam Integer id) {
        return ResponseEntity.ok(favouriteService.findFavouriteRecipeById(id));
    }

    @PostMapping("/recipe/findorsave")
    @ApiOperation(
            value = "Get favourite recipe",
            notes = "Get favourite recipe by id or save if not exist",
            response = FavouriteRecipe.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = FavouriteRecipe.class),
            @ApiResponse(code = 400, message = "Bad request", response = FavouriteRecipe.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = FavouriteRecipe.class)
    })
    public ResponseEntity<FavouriteRecipe> getFavouriteRecipeByIdOrSaveFavouriteRecipe (@RequestBody FavouriteRecipe
                                                                                                    favouriteRecipe) {
        return ResponseEntity.ok(favouriteService.findFavouriteRecipeByIdOrSaveFavouriteRecipe(favouriteRecipe));
    }

    @GetMapping("/user/save")
    @ApiOperation(
            value = "Save user",
            notes = "Save user with given username",
            response = User.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = User.class),
            @ApiResponse(code = 400, message = "Bad request", response = User.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = User.class)
    })
    public ResponseEntity<User> saveUser(@RequestHeader(name = "Username") String username) {
        return ResponseEntity.ok(favouriteService.saveUser(username));
    }

    @GetMapping("/user/delete")
    @ApiOperation(
            value = "Delete user",
            notes = "Delete user with by id",
            response = void.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = void.class),
            @ApiResponse(code = 400, message = "Bad request", response = void.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = void.class)
    })
    public ResponseEntity<Void> deleteUser(@RequestParam Integer id) {
        favouriteService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/find")
    @ApiOperation(
            value = "Get user",
            notes = "Get user by id",
            response = User.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = User.class),
            @ApiResponse(code = 400, message = "Bad request", response = User.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = User.class)
    })
    public ResponseEntity<User> getUserById(@RequestParam Integer id) {
        return ResponseEntity.ok(favouriteService.findUserById(id));
    }

    @GetMapping("/user/findorsave")
    @ApiOperation(
            value = "Get or save the user",
            notes = "Get user by username or save if not exist",
            response = User.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = User.class),
            @ApiResponse(code = 400, message = "Bad request", response = User.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = User.class)
    })
    public ResponseEntity<User> getUserByUsernameOrSaveUser(@RequestHeader(name = "Username") String username) {
        return ResponseEntity.ok(favouriteService.findUserByUsernameOrSaveUser(username));
    }


    @GetMapping("/user/addrecipe")
    @ApiOperation(
            value = "Add favourite recipe",
            notes = "Add favourite recipe to user",
            response = User.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = User.class),
            @ApiResponse(code = 400, message = "Bad request", response = User.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = User.class)
    })
    public ResponseEntity<User> addRecipeToUser(@RequestParam Integer recipeId,
                                                @RequestHeader(name = "Username") String username) {
        return ResponseEntity.ok(favouriteService.addRecipeToUser(recipeId, username));
    }

    @GetMapping("/user/removerecipe")
    @ApiOperation(
            value = "Delete favourite recipe",
            notes = "Delete favourite recipe from user",
            response = User.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = User.class),
            @ApiResponse(code = 400, message = "Bad request", response = User.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = User.class)
    })
    public ResponseEntity<User> removeRecipeFromUser(@RequestParam Integer recipeId,
                                                     @RequestHeader(name = "Username") String username) {
        return ResponseEntity.ok(favouriteService.removeRecipeFromUser(recipeId, username));
    }

    @GetMapping("/user/getrecipes")
    @ApiOperation(
            value = "Get all favourite recipes",
            notes = "Get set of favourite recipes from user by username",
            response = Set.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Set.class),
            @ApiResponse(code = 400, message = "Bad request", response = Set.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Set.class)
    })
    public ResponseEntity<Set<FavouriteRecipe>> getUserFavouriteRecipes(@RequestHeader(name = "Username")
                                                                            String username) {
        return ResponseEntity.ok(favouriteService.getUserFavouriteRecipes(username));
    }

    @GetMapping("/user/getrecipe")
    @ApiOperation(
            value = "Get favourite recipe",
            notes = "Get set of favourite recipe from user by id of recipe and username",
            response = FavouriteRecipe.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Set.class),
            @ApiResponse(code = 400, message = "Bad request", response = Set.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Set.class)
    })
    public ResponseEntity<Set<FavouriteRecipe>> getUserFavouriteRecipe(@RequestParam Integer recipeId,
                                                                       @RequestHeader(name = "Username")
                                                                        String username) {
        return ResponseEntity.ok(favouriteService.getUserFavouriteRecipeById(recipeId, username));
    }

    @GetMapping("/user/isfavouriterecipe")
    @ApiOperation(
            value = "Check if recipe is favourite",
            notes = "Check if recipe is favourite for user by id of recipe and username",
            response = Boolean.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Boolean.class),
            @ApiResponse(code = 400, message = "Bad request", response = Boolean.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Boolean.class)
    })
    public ResponseEntity<Boolean> isFavouriteRecipeUserFavourite(@RequestParam Integer recipeId,
                                                                  @RequestHeader(name = "Username") String username) {
        return ResponseEntity.ok(favouriteService.isFavouriteRecipeUserFavourite(recipeId, username));
    }

}
