package pl.pjatk.EatGood.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.EatGood.domain.Recipe;
import pl.pjatk.EatGood.service.RecipeService;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/getRecipe")
    public ResponseEntity<Recipe> getRecipe(@RequestParam String query) {
        return recipeService.getRecipe(query);
    }
}
