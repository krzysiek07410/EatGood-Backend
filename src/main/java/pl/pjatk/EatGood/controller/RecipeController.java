package pl.pjatk.EatGood.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.EatGood.domain.GenericRecipe;
import pl.pjatk.EatGood.domain.GenericRecipeList;
import pl.pjatk.EatGood.domain.Recipe;
import pl.pjatk.EatGood.service.RecipeService;

import java.util.List;

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
}
