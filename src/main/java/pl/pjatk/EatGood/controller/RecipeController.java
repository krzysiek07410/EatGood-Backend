package pl.pjatk.EatGood.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.EatGood.domain.*;
import pl.pjatk.EatGood.service.RecipeService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/getRecipes")
    public ResponseEntity<GenericRecipeList> getRecipes(@RequestParam String query) {
        return recipeService.getRecipesByQuery(query);
    }

    @GetMapping("/getRecipesInformation")
    public ResponseEntity<Recipe[]> getRecipesInformation(@RequestParam String ids) {
        return recipeService.getRecipesInformation(ids);
    }
}
