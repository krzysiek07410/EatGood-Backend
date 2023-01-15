package pl.pjatk.EatGood.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.EatGood.domain.GenericRecipeList;
import pl.pjatk.EatGood.domain.Recipe;
import pl.pjatk.EatGood.domain.RecipeList;
import pl.pjatk.EatGood.service.RecipeService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

//    @GetMapping("/getRecipes")
//    public ResponseEntity<GenericRecipeList> getRecipes(@RequestParam String query) {
//        return recipeService.getRecipesByQuery(query);
//    }

    @GetMapping("/getRecipes")
    public ResponseEntity<GenericRecipeList> getRecipes(@RequestParam String query) {
        return ResponseEntity.ok(recipeService.getRecipesByQuery(query));
    }

    @GetMapping("/getRecipesInformation")
    public ResponseEntity<Recipe[]> getRecipesInformation(@RequestParam String ids) {
        return recipeService.getRecipesInformation(ids);
    }

    @GetMapping("/getRecipesByCalories")
    public ResponseEntity<GenericRecipeList> getRecipesByCalories(@RequestParam(required = false,
            defaultValue = "0") int min, @RequestParam(required = false, defaultValue = "0") int max) {
        return recipeService.getRecipesByCalories(min, max);
    }

    @GetMapping("/getRecipesByCuisine")
    public ResponseEntity<GenericRecipeList> getRecipesByCuisine(@RequestParam String cuisine) {
        return recipeService.getRecipesByCuisine(cuisine);
    }

    @GetMapping("/getRecipesByDiet")
    public ResponseEntity<GenericRecipeList> getRecipesByDiet(@RequestParam String diet) {
        return recipeService.getRecipesByDiet(diet);
    }

    @GetMapping("/getRandomRecipes")
    public ResponseEntity<RecipeList> getRandomRecipes(@RequestParam int recipeCount, @RequestHeader Map<String, String>
            headers, HttpServletRequest request) {
//        System.out.println(headers);
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            String headerValue = request.getHeader(headerName);
//            System.out.println(headerName + ": " + headerValue);
//        }
//        System.out.println(headers);
        headers.forEach((key, value) -> {
            System.out.println((String.format("Header '%s' = %s", key, value)));
        });

        return recipeService.getRandomRecipes(recipeCount);
    }
}
