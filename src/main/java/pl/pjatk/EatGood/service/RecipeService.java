package pl.pjatk.EatGood.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.EatGood.domain.Recipe;

@Service
public class RecipeService {
    private static final String RESOURCE_URL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes";
    private static final String APP_KEY = "8f550b7fa2msha9a927ff991988cp11574ajsn2b82d10d2ca7";
    private final RestTemplate restTemplate;

    public RecipeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Recipe> getRecipe(String query) {
        return restTemplate.getForEntity(RESOURCE_URL + "/complexSearch?" + "apiKey=" + APP_KEY + "&query=" + query, Recipe.class);
    }
}
