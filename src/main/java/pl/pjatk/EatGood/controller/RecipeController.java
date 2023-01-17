package pl.pjatk.EatGood.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.EatGood.domain.GenericRecipeList;
import pl.pjatk.EatGood.domain.RecipeList;
import pl.pjatk.EatGood.service.RecipeService;

import java.util.LinkedHashMap;

@Api(value = "Recipe Controller", description = "Controller for recipes")
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

    @GetMapping("/generic")
    @ApiOperation(
            value = "Get generic recipes by query",
            notes = "Retrieve generic recipes with given query from the API",
            response = GenericRecipeList.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = GenericRecipeList.class),
            @ApiResponse(code = 400, message = "Bad request", response = GenericRecipeList.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericRecipeList.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = GenericRecipeList.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GenericRecipeList.class)

    })
    public ResponseEntity<GenericRecipeList> getRecipes(@RequestParam String query) {
        return ResponseEntity.ok(recipeService.getRecipesByQuery(query));
    }

//    @GetMapping("/getRecipesInformation")
//    public ResponseEntity<Recipe[]> getRecipesInformation(@RequestParam String ids) {
//        return recipeService.getRecipesInformation(ids);
//    }

    @GetMapping("/information")
    @ApiOperation(
            value = "Get recipes information",
            notes = "Retrieve recipes information with given ids from the API",
            response = RecipeList.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = RecipeList.class),
            @ApiResponse(code = 400, message = "Bad request", response = RecipeList.class),
            @ApiResponse(code = 404, message = "Not found", response = RecipeList.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = RecipeList.class),
            @ApiResponse(code = 500, message = "Internal server error", response = RecipeList.class)
    })
    public ResponseEntity<RecipeList> getRecipesInformation(@RequestParam String ids) {
        return ResponseEntity.ok(recipeService.getRecipesInformation(ids));
    }

//    @GetMapping("/getRecipesByCalories")
//    public ResponseEntity<GenericRecipeList> getRecipesByCalories(@RequestParam(required = false,
//            defaultValue = "0") int min, @RequestParam(required = false, defaultValue = "0") int max) {
//        return recipeService.getRecipesByCalories(min, max);
//    }

    @GetMapping("/calories")
    @ApiOperation(
            value = "Get generic recipes by calories",
            notes = "Retrieve generic recipes with given calories from the API",
            response = GenericRecipeList.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = GenericRecipeList.class),
            @ApiResponse(code = 400, message = "Bad request", response = GenericRecipeList.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericRecipeList.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = GenericRecipeList.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GenericRecipeList.class)
    })
    public ResponseEntity<GenericRecipeList> getRecipesByCalories(@RequestParam(required = false,
            defaultValue = "0") int min, @RequestParam(required = false, defaultValue = "0") int max) {
        return ResponseEntity.ok(recipeService.getRecipesByCalories(min, max));
    }

//    @GetMapping("/getRecipesByCuisine")
//    public ResponseEntity<GenericRecipeList> getRecipesByCuisine(@RequestParam String cuisine) {
//        return recipeService.getRecipesByCuisine(cuisine);
//    }

    @GetMapping("/cuisine")
    @ApiOperation(
            value = "Get generic recipes by cuisine",
            notes = "Retrieve generic recipes with given cuisine from the API",
            response = GenericRecipeList.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = GenericRecipeList.class),
            @ApiResponse(code = 400, message = "Bad request", response = GenericRecipeList.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericRecipeList.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = GenericRecipeList.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GenericRecipeList.class)
    })
    public ResponseEntity<GenericRecipeList> getRecipesByCuisine(@RequestParam String cuisine) {
        return ResponseEntity.ok(recipeService.getRecipesByCuisine(cuisine));
    }

//    @GetMapping("/getRecipesByDiet")
//    public ResponseEntity<GenericRecipeList> getRecipesByDiet(@RequestParam String diet) {
//        return recipeService.getRecipesByDiet(diet);
//    }

    @GetMapping("/diet")
    @ApiOperation(
            value = "Get generic recipes by diet",
            notes = "Retrieve recipes with given diet from the API",
            response = GenericRecipeList.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = GenericRecipeList.class),
            @ApiResponse(code = 400, message = "Bad request", response = GenericRecipeList.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericRecipeList.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = GenericRecipeList.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GenericRecipeList.class)
    })
    public ResponseEntity<GenericRecipeList> getRecipesByDiet(@RequestParam String diet) {
        return ResponseEntity.ok(recipeService.getRecipesByDiet(diet));
    }


//    @GetMapping("/getRandomRecipes")
//    public ResponseEntity<RecipeList> getRandomRecipes(@RequestParam int recipeCount, @RequestHeader Map<String, String>
//            headers, HttpServletRequest request) {
////        System.out.println(headers);
////        Enumeration<String> headerNames = request.getHeaderNames();
////        while (headerNames.hasMoreElements()) {
////            String headerName = headerNames.nextElement();
////            String headerValue = request.getHeader(headerName);
////            System.out.println(headerName + ": " + headerValue);
////        }
////        System.out.println(headers);
//        headers.forEach((key, value) -> {
//            System.out.println((String.format("Header '%s' = %s", key, value)));
//        });
//
//        return recipeService.getRandomRecipes(recipeCount);
//    }

    @GetMapping("/queryanddiet")
    @ApiOperation(
            value = "Get generic recipes by query and diet",
            notes = "Retrieve recipes with given query and diet from the API",
            response = RecipeList.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = GenericRecipeList.class),
            @ApiResponse(code = 400, message = "Bad request", response = GenericRecipeList.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericRecipeList.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = GenericRecipeList.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GenericRecipeList.class)
    })
    public ResponseEntity<GenericRecipeList> getRecipesByQueryAndDiet(@RequestParam String query,
                                                                      @RequestParam String diet) {
        return ResponseEntity.ok(recipeService.getRecipesByQueryAndDiet(query, diet));
    }

    @GetMapping("/queryandcalories")
    @ApiOperation(
            value = "Get generic recipes by query and calories",
            notes = "Retrieve generic recipes with given query and calories from the API",
            response = GenericRecipeList.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = GenericRecipeList.class),
            @ApiResponse(code = 400, message = "Bad request", response = GenericRecipeList.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericRecipeList.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = GenericRecipeList.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GenericRecipeList.class)
    })
    public ResponseEntity<GenericRecipeList> getRecipesByQueryAndCalories(@RequestParam String query,
                                                                          @RequestParam(required = false,
                                                                                  defaultValue = "0") int min,
                                                                          @RequestParam(required = false,
                                                                                  defaultValue = "0") int max) {
        return ResponseEntity.ok(recipeService.getRecipesByQueryAndCalories(query, min, max));
    }

    @GetMapping("/dietandcalories")
    @ApiOperation(
            value = "Get generic recipes by diet and calories",
            notes = "Retrieve generic recipes with given diet and calories from the API",
            response = GenericRecipeList.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = GenericRecipeList.class),
            @ApiResponse(code = 400, message = "Bad request", response = GenericRecipeList.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericRecipeList.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = GenericRecipeList.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GenericRecipeList.class)
    })
    public ResponseEntity<GenericRecipeList> getRecipesByDietAndCalories(@RequestParam String diet,
                                                                         @RequestParam(required = false,
                                                                                 defaultValue = "0") int min,
                                                                         @RequestParam(required = false,
                                                                                 defaultValue = "0") int max) {
        return ResponseEntity.ok(recipeService.getRecipesByDietAndCalories(diet, min, max));
    }

    @GetMapping("/queryanddietandcalories")
    @ApiOperation(
            value = "Get generic recipes by query, diet and calories",
            notes = "Retrieve generic recipes with given query, diet and calories from the API",
            response = GenericRecipeList.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = GenericRecipeList.class),
            @ApiResponse(code = 400, message = "Bad request", response = GenericRecipeList.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericRecipeList.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = GenericRecipeList.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GenericRecipeList.class)
    })
    public ResponseEntity<GenericRecipeList> getRecipesByDietAndCalories(@RequestParam String query,
                                                                         @RequestParam String diet,
                                                                         @RequestParam(required = false,
                                                                                 defaultValue = "0") int min,
                                                                         @RequestParam(required = false,
                                                                                 defaultValue = "0") int max) {
        return ResponseEntity.ok(recipeService.getRecipesByQueryAndDietAndCalories(query, diet, min, max));
    }

    @GetMapping("/random")
    @ApiOperation(
            value = "Get random recipes",
            notes = "Retrieve random recipes from the API",
            response = RecipeList.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = GenericRecipeList.class),
            @ApiResponse(code = 400, message = "Bad request", response = GenericRecipeList.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericRecipeList.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = GenericRecipeList.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GenericRecipeList.class)
    })
    public ResponseEntity<RecipeList> getRandomRecipe() {
        return ResponseEntity.ok(recipeService.getRandomRecipe());
    }

    @GetMapping("/headers")
    @ApiOperation(
            value = "Get headers",
            notes = "Retrieve headers from the API",
            response = LinkedHashMap.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = LinkedHashMap.class),
            @ApiResponse(code = 400, message = "Bad request", response = LinkedHashMap.class),
            @ApiResponse(code = 404, message = "Not found", response = LinkedHashMap.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = LinkedHashMap.class),
            @ApiResponse(code = 500, message = "Internal server error", response = LinkedHashMap.class)
    })
    public ResponseEntity<LinkedHashMap<String, Integer>> getHeaders() {
        return ResponseEntity.ok(recipeService.getHeaders());
    }
}
